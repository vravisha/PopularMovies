package com.example.vijay.popularmovies;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by weejay on 12/1/2015.
 */
public class MoviesDataParser {
    static String unitType;

    MoviesDataParser(String units) {
        unitType = units;
    }

    private static final String LOG_TAG = com.example.vijay.popularmovies.MoviesDataParser.class.getSimpleName();
    private final String BASE_URL = "http://image.tmdb.org/t/p/w185/";

    /**
     * Take the String representing the complete movie info in JSON Format and
     * pull out the data we need to construct the Strings needed for the wireframes.
     *
     * Fortunately parsing is easy:  constructor takes the JSON string and converts it
     * into an Object hierarchy for us.
     */
    public ArrayList<Movie> getMovieDataFromJson(String movieJsonStr)
            throws JSONException {

        // These are the names of the JSON objects that need to be extracted.
        final String MDB_RESULTS = "results";
        final String MDB_POSTER = "poster_path";
        final String MDB_OVERVIEW = "overview";
        final String MSB_RELEASE_DATE = "release_date";
        final String MDB_ID = "id";
        final String MDB_TITLE = "original_title";
        final String MDB_VOTE_AVG = "vote_average";
        final String MDB_POPULARITY = "popularity";

        JSONObject movieJson = new JSONObject(movieJsonStr);
        JSONArray moviesArray = movieJson.getJSONArray(MDB_RESULTS);

        ArrayList<Movie> resultStrs = new ArrayList<>();
        for(int i = 0; i < moviesArray.length(); i++) {
            String poster_path;
            String overview;
            String release_date;
            String id;
            String original_title;
            double popularity;
            double vote_avg;

            JSONObject movieInfo = moviesArray.getJSONObject(i);
            poster_path = BASE_URL + movieInfo.getString(MDB_POSTER);
            overview = movieInfo.getString(MDB_OVERVIEW);
            release_date = movieInfo.getString(MSB_RELEASE_DATE);
            id = movieInfo.getString(MDB_ID);
            original_title = movieInfo.getString(MDB_TITLE);
            popularity = movieInfo.getDouble(MDB_POPULARITY);
            vote_avg = movieInfo.getDouble(MDB_VOTE_AVG);

            resultStrs.add(new Movie(poster_path, overview, release_date, id, original_title, popularity, vote_avg));
        }

        for (Movie movie : resultStrs) {
            Log.v(LOG_TAG, "Movie Title: " + movie.getOriginal_title() + " Date:" + movie.getRelease_date());
        }
        return resultStrs;

    }
}
