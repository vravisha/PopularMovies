package com.example.vijay.popularmovies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vijay.popularmovies.data.Movie;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    @Bind(R.id.detail_image)ImageView imageView;
    @Bind(R.id.detail_title)TextView titleView;
    @Bind(R.id.detail_date)TextView dateView;
    @Bind(R.id.detail_rating)TextView rateView;
    @Bind(R.id.detail_summary)TextView summaryView;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        //Butter knife library for binding views
        ButterKnife.bind(this, rootView);
        Movie movie = getActivity().getIntent().getParcelableExtra("movie");
        //Setting back poster of movie
        Picasso.with(getActivity()).load(movie.getPoster_path()).into(imageView);
        //Setting title of movie
        titleView.setText(movie.getOriginal_title());
        //Setting release date of movie
        dateView.setText(movie.getRelease_date());
        //Setting ratings of movie
        String text = movie.getVote_avg()+"";
        rateView.setText(text);
        //Setting summary of movie
        summaryView.setText(movie.getOverview());
        return rootView;
    }
}
