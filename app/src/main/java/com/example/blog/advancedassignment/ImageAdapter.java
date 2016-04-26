package com.example.blog.advancedassignment;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {


    private Context mContext;

    ImageView imageView;

    //This is getting filled up from the AsyncTask
    public static ArrayList<String> URIs = new ArrayList<String>();

//    Integer[] images = {
//            R.drawable.fish,
//            R.drawable.fish2,
//            R.drawable.fish3,
//            R.drawable.fish,
//            R.drawable.fish2,
//            R.drawable.fish3,
//            R.drawable.fish,
//            R.drawable.fish2,
//            R.drawable.fish3
//    };


    public ImageAdapter(Context c) {
        mContext = c;
    }

    public ImageAdapter() {

    }

    @Override
    public int getCount() {
        Log.w("get count", "" + URIs.size());
//        return images.length;
        return URIs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.w("In getView", "alalal");

        imageView = new ImageView(mContext);

        imageView.setImageURI(Uri.fromFile(new File(URIs.get(position))));

        return imageView;
    }


    public void refresh(ArrayList<String> newlist) {
        URIs.clear();
        URIs.addAll(newlist);
        ArrayList<String> list = newlist;
        Log.w("Refresh URI size", "" + URIs.size());
        getCount();
    }
}




