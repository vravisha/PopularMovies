package com.example.vijay.popularmovies;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Vijay on 3/2/2016.
 */
public class MovieAdapter extends BaseAdapter {
    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();
    private Context mContext;
    private ArrayList<Movie> movieArrayList;

   public MovieAdapter(Context context, ArrayList<Movie> objects) {
       mContext = context;
       movieArrayList = objects;
       notifyDataSetChanged();
   }

    //View holder class to make scrolling smooth
    static class ViewHolder{
        @Bind(R.id.imageView)ImageView imageView;
        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public int getCount() {
        return movieArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieArrayList.get(position).getPoster_path();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            LayoutInflater inflater = ((MainActivity)mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.gridview_item_movies, parent, false);
            holder = new ViewHolder(convertView);
            holder.imageView = (ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        Picasso.with(mContext).load(movieArrayList.get(position).getPoster_path()).into(holder.imageView);
        Log.v(LOG_TAG, "Inside getView");
        return convertView;
    }
}

//Initialize ImageView
//        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);

//Loading image from below url into imageView
//        Picasso.with(getContext())
//                .load("http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg ")
//                .into(imageView);