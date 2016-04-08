package com.example.vijay.popularmovies.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vijay on 4/7/2016.
 */
public class MovieDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "movie.db";

    public MovieDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " + MovieContract.MovieEntry.TABLE_NAME + " ("
                + MovieContract.MovieEntry._ID  + " INTEGER PRIMARY KEY AUTOINCREMENT"
                + MovieContract.MovieEntry.COL_MOVIE_ID + " TEXT NOT NULL"
                + MovieContract.MovieEntry.COL_MOVIE_TITLE + "TEXT NOT NULL"
                + MovieContract.MovieEntry.COL_MOVIE_POSTER + "TEXT NOT NULL"
                + MovieContract.MovieEntry.COL_MOVIE_SUMMARY + " TEXT NOT NULL,"
                + MovieContract.MovieEntry.COL_MOVIE_DATE + " TEXT NOT NULL,"
                + MovieContract.MovieEntry.COL_MOVIE_RATING + " REAL NOT NULL,"
                + MovieContract.MovieEntry.COL_MOVIE_VOTES + " INTEGER NOT NULL,"
                + MovieContract.MovieEntry.COL_MOVIE_FAVORITES + " INTEGER NOT NULL" + ")";

        //execute the query to create table
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //delete table if exists
        db.execSQL("DROP TABLE IF EXISTS " + MovieContract.MovieEntry.TABLE_NAME);
    }
}
