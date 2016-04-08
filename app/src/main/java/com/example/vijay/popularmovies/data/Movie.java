package com.example.vijay.popularmovies.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vijay on 2/29/2016.
 */
public class Movie implements Parcelable{
    private String poster_path;
    private String overview;
    private String release_date;
    private String id;
    private String original_title;
    private Double popularity;
    private Double vote_avg;

    //Movie constructor used by parcelable
    protected Movie(Parcel in) {

        poster_path = in.readString();
        overview = in.readString();
        release_date = in.readString();
        id = in.readString();
        original_title = in.readString();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        vote_avg = in.readByte() == 0x00 ? null : in.readDouble();
    }

    public Movie(String poster, String overview, String date, String id, String title, double popularity, double vote) {
        this.poster_path = poster;
        this.overview = overview;
        this.release_date = date;
        this.id = id;
        this.original_title = title;
        this.popularity = popularity;
        this.vote_avg = vote;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poster_path);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeString(id);
        dest.writeString(original_title);
        if(popularity == null){
            dest.writeByte((byte)(0));
        }else{
            dest.writeByte((byte)(1));
            dest.writeDouble(vote_avg);
        }
        if(vote_avg == null){
            dest.writeByte((byte)(0));
        }else{
            dest.writeByte((byte)(1));
            dest.writeDouble(vote_avg);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>(){


        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
