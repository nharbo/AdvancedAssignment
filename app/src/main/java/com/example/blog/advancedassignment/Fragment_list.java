package com.example.blog.advancedassignment;

import android.app.Activity;
import android.app.ListFragment;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.lang.annotation.Target;
import java.util.ArrayList;


public class Fragment_list extends Fragment {

    static GridView gridView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gridview, container, false);

        Activity activity = (Activity)view.getContext();

        gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(activity));

//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.CONTEXT_IGNORE_SECURITY, "Clicked!" + position, Toast.LENGTH_SHORT).show();
//            }
//        });

        Log.w("FRAGMENT_LIST", "IN FRAGMENTLIST");

        return view;
    }

    public static void refreshGrid(){
        gridView.invalidateViews();
    }

//    //This is getting called from the AsyncTask
//    public static void showImages(){
//
//        Activity activity = (Activity)view.getContext();
//        Log.w("IN SHOWIMAGES", "METHOD");
//
//        for(int i = 0; i < URIs.size(); i++){
//            //Lav nyt imageview for hver iteration.
//
//            File f = new File(URIs.get(i));
//
//            Picasso.with(activity).load(f).into(imageView);
//        }
//
//    }


}
