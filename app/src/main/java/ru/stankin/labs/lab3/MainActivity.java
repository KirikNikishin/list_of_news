package ru.stankin.labs.lab3;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NewsViewModel newsViewModel;
    private ListView newsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsListView = findViewById(R.id.newsListView);
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        // Наблюдаем за LiveData, который теперь возвращает NewsResponse
        newsViewModel.getNewsResponse().observe(this, new Observer<NewsResponse>() {
            @Override
            public void onChanged(NewsResponse newsResponse) {
                if (newsResponse != null && newsResponse.getArticles() != null && !newsResponse.getArticles().isEmpty()) {
                    // Получены новости, обновляем UI
                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsResponse.getArticles());
                    newsListView.setAdapter(adapter);
                } else {
                    // Ошибка или пустой ответ
                    Toast.makeText(MainActivity.this, "Ошибка загрузки данных или пустой ответ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Запрашиваем новости
        newsViewModel.fetchNews();
    }
}