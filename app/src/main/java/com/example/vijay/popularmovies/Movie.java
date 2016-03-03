package com.example.vijay.popularmovies;

/**
 * Created by Vijay on 2/29/2016.
 */
public class Movie {
    private String poster_path;
    private String overview;
    private String release_date;
    private String id;
    private String original_title;
    private double popularity;
    private double vote_avg;

    Movie(String poster, String overview, String date, String id, String title, double popularity, double vote) {
        poster_path = poster;
        this.overview = overview;
        release_date = date;
        this.id = id;
        original_title = title;
        this.popularity = popularity;
        vote_avg = vote;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getVote_avg() {
        return vote_avg;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setVote_avg(double vote_avg) {
        this.vote_avg = vote_avg;
    }
}
