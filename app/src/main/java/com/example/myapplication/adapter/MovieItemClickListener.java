package com.example.myapplication.adapter;

import android.widget.ImageView;

import com.example.myapplication.model.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView);
}
