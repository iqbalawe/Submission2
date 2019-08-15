package com.iqbal.submission2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iqbal.submission2.R;
import com.iqbal.submission2.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private Context context;
    private ArrayList<Movie> movies;
    private OnItemClickListener mListener;

    // Setter dan Getter untuk ArrayList
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    // Constructor Context
    public MovieAdapter(Context context) {
        this.context = context;
    }

    // Settingan onClick
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int i) {
        movieHolder.tvName.setText(getMovies().get(i).getName());
        movieHolder.tvDesc.setText(getMovies().get(i).getDesc());
        Glide.with(context)
                .load(getMovies().get(i).getPhoto())
                .apply(new RequestOptions().override(100, 200))
                .into(movieHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getMovies().size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDesc;
        ImageView imgPhoto;


        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
