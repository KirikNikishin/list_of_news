package ru.stankin.labs.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }

        News news = getItem(position);

        TextView titleTextView = convertView.findViewById(R.id.newsTitle);
        TextView descriptionTextView = convertView.findViewById(R.id.newsDescription);

        titleTextView.setText(news.getTitle());
        descriptionTextView.setText(news.getDescription());

        return convertView;
    }
}


