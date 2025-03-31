package ru.stankin.labs.lab3;

// NewsViewModel.java
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {

    // MutableLiveData для NewsResponse
    private MutableLiveData<NewsResponse> newsResponse;

    public NewsViewModel() {
        newsResponse = new MutableLiveData<>();
    }

    // Геттер для LiveData
    public LiveData<NewsResponse> getNewsResponse() {
        return newsResponse;
    }

    // Метод для загрузки новостей
    public void fetchNews() {
        NewsApiService apiService = RetrofitInstance.getRetrofitInstance().create(NewsApiService.class);
        Call<NewsResponse> call = apiService.getNews();  // Получаем объект NewsResponse

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Успешно получили данные, обновляем LiveData
                    newsResponse.setValue(response.body());
                } else {
                    // Логирование ошибки
                    Log.e("NewsViewModel", "Response Error: " + response.message());
                    Log.e("NewsViewModel", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                // Логирование ошибки в случае сбоя запроса
                Log.e("NewsViewModel", "Request failed: " + t.getMessage());
            }
        });
    }
}

