package com.example.vijay.popularmovies.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Vijay on 4/7/2016.
 */
public class MovieContract {

    public static final String CONTENT_AUTHORITY = "com.example.vijay.popularmovies";

    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_MOVIE = "movie";

    public static final class MovieEntry implements BaseColumns {
        //column for table name
        public static final String TABLE_NAME = "movie";
        //column for movie id
        public static final String COL_MOVIE_ID = "movie_id";
        //column for movie title
        public static final String COL_MOVIE_TITLE = "title";
        //column for movie poster
        public static final String COL_MOVIE_POSTER = "poster";
        //column for movie summary
        public static final String COL_MOVIE_SUMMARY = "summary";
        //column for movie release date
        public static final String COL_MOVIE_DATE = "date";
        //column for movie rating
        public static final String COL_MOVIE_RATING = "rating";
        //column for votes
        public static final String COL_MOVIE_VOTES = "votes";
        //column for favorite movies
        public static final String COL_MOVIE_FAVORITES = "favorites";

        //content uri for table
        public static final Uri CONTENT_URI = MovieContract.CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        //MIME type for directory of items
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_URI.toString();
        //MIME type for single item
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_URI.toString();
    }

    //Apppending id to uri
    public static Uri getUriForId(long id){
        return MovieEntry.CONTENT_URI.buildUpon().appendPath(Integer.toString((int)id)).build();
    }
}
