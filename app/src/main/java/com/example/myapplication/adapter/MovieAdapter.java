package com.example.myapplication.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.myapplication.R;
import com.example.myapplication.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    static List<Movie> movieList;
    static MovieItemClickListener movieItemClickListener;

    public MovieAdapter (Context context, List<Movie> movieList, MovieItemClickListener listener){
        this.context = context;
        MovieAdapter.movieList = movieList;
        movieItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.TvTitle.setText(movieList.get(i).getTitle());
        myViewHolder.ImgMovie.setImageResource(movieList.get(i).getThumbnail());
        myViewHolder.TvRating.setText(String.valueOf(movieList.get(i).getRating()));
//        Glide.with(context).load(movieList.get(i).getImageUrl()).into((ImageView) myViewHolder.itemView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView TvTitle, TvRating;
        ImageView ImgMovie;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            TvTitle = itemView.findViewById(R.id.movie_title);
            ImgMovie = itemView.findViewById(R.id.movie_image);
            TvRating = itemView.findViewById(R.id.movie_rating);

            itemView.setOnClickListener(v -> movieItemClickListener.onMovieClick(movieList.get(getAdapterPosition()), ImgMovie));
        }
    }
}
