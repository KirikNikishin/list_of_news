package ru.stankin.labs.lab3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApiService {
    @GET("v2/top-headlines?country=us&apiKey=479f87651be041c59dcdb373bd75822b")
    Call<NewsResponse> getNews();
}