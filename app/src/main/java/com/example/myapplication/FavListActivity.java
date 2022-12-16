package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.adapter.MovieItemClickListener;
import com.example.myapplication.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class FavListActivity extends AppCompatActivity implements MovieItemClickListener {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_list);
        recyclerView = findViewById(R.id.fav_list);
        ArrayList<Movie> movies = getIntent().getExtras().getParcelableArrayList("FavList");
        setMoviesPagerAdapter(movies);
        Log.d("dasdas", "onCreate: "+ array2string(movies));
    }
    public String array2string(ArrayList<Movie> films){
        String ab = "";
        for(Movie i:films){
            ab += i.toString() + "  ";
        }
        return ab;
    }
    private void setMoviesPagerAdapter(List<Movie> listMovies){
        MovieAdapter movieAdapter = new MovieAdapter(this,listMovies,this);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgUrl", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        intent.putExtra("director", movie.getDirector());
        intent.putExtra("type", movie.getType());
        intent.putExtra("rated", movie.getRated());
        intent.putExtra("description", movie.getDescription());

//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, movieImageView, "sharedName");
        startActivity(intent);
    }
}