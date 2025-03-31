package ru.stankin.labs.lab3;

import java.util.List;

public class NewsResponse {
    private String status;  // Статус ответа (например, "ok")
    private int totalResults;  // Общее количество новостей
    private List<News> articles;  // Список новостей

    // Геттеры и сеттеры
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
