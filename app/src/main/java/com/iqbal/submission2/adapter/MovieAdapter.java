package com.iqbal.submission2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iqbal.submission2.model.Movie;
import com.iqbal.submission2.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private ArrayList<Movie> listMovie;

    public MovieAdapter(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int position) {
        Movie movie = listMovie.get(position);

        Glide.with(movieHolder.itemView.getContext())
                .load(movie.getPoster())
                .apply(new RequestOptions().override(200, 250))
                .into(movieHolder.imgPoster);

        movieHolder.tvTitle.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle;

        MovieHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
