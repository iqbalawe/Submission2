package com.iqbal.submission2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iqbal.submission2.fragment.MovieFragment;
import com.iqbal.submission2.model.Movie;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    public static String EXTRA_MOVIE = "extra_movie";
    Movie movie;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inisialisasi
        TextView detailTitle = view.findViewById(R.id.txt_title);
        TextView detailDesc = view.findViewById(R.id.txt_description);
        ImageView detailPhoto = view.findViewById(R.id.img_poster);

        Movie mMovie = getArguments().getParcelable(MovieFragment.EXTRA_MOVIE);

        String title = mMovie.getName();
        detailTitle.setText(title);
        String desc = mMovie.getDesc();
        detailDesc.setText(desc);
        int image = mMovie.getPhoto();
        detailPhoto.setImageResource(image);

        /*Bundle bundle = this.getArguments();

        if (bundle != null) {
            movie = bundle.getParcelable(MovieFragment.EXTRA_MOVIE);
        }

        String title = movie.getName();
        detailTitle.setText(title);
        String desc = movie.getDesc();
        detailDesc.setText(desc);
        int image = movie.getPhoto();
        detailPhoto.setImageResource(image);*/
    }
}
