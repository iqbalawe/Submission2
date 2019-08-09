package com.iqbal.submission2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.iqbal.submission2.adapter.ViewPagerAdapter;
import com.iqbal.submission2.fragment.MovieFragment;
import com.iqbal.submission2.fragment.TvFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.view_pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment & Show Tab Layout
        adapter.addFragment(new MovieFragment(), "MOVIE");
        adapter.addFragment(new TvFragment(), "TV SHOW");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
