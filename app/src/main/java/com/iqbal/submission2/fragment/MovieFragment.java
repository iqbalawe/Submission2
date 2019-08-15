package com.iqbal.submission2.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iqbal.submission2.DetailFragment;
import com.iqbal.submission2.R;
import com.iqbal.submission2.adapter.MovieAdapter;
import com.iqbal.submission2.model.Movie;

import java.util.ArrayList;

public class MovieFragment extends Fragment implements MovieAdapter.OnItemClickListener {

    private RecyclerView rvMovies;
    private ArrayList<Movie> list = new ArrayList<>();
    private String[] dataName, dataDescription;
    private TypedArray dataPhoto;
    public static String EXTRA_MOVIE = "extra_movie";

    public MovieFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inisialisasi disini
        rvMovies = view.findViewById(R.id.rv_movie);
        rvMovies.setHasFixedSize(true);

        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

        // Panggil item dari string-array ke fragment
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setDesc(dataDescription[i]);
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            list.add(movie);

            showRecyclerItem();
        }
    }

    private void showRecyclerItem() {
        // set layout manager disini
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter adapter = new MovieAdapter(getContext());
        adapter.setMovies(list);
        rvMovies.setAdapter(adapter);

        // implementasikan pula onClick
        adapter.setOnItemClickListener(MovieFragment.this);
    }

    @Override
    public void onItemClick(int position) {
        Movie movie = new Movie();
        movie.setName(dataName[position]);
        movie.setDesc(dataDescription[position]);
        movie.setPhoto(dataPhoto.getResourceId(position, -1));

        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailFragment.EXTRA_MOVIE, movie);
        detailFragment.setArguments(bundle);

        FragmentManager mFragmentManager = getFragmentManager();
        if (mFragmentManager != null) {
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_layout, detailFragment, DetailFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}
