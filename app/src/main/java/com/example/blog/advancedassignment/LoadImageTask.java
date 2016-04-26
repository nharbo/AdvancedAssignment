package com.example.blog.advancedassignment;

import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class LoadImageTask extends AsyncTask<Void, Void, ArrayList<String>> {

    Context context;

    public LoadImageTask(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<String> doInBackground(Void... params) {

        ArrayList<String> listOfAllImages = new ArrayList<String>();

        String absolutePathOfImage = null;

        Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.MediaColumns.DISPLAY_NAME};

        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        int column_index = 0;
        if (cursor != null) {
            column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        }

        if (cursor != null) {
            while (cursor.moveToNext()) {
                absolutePathOfImage = cursor.getString(column_index);
                listOfAllImages.add(absolutePathOfImage);
            }
        }
        cursor.close();
        return listOfAllImages;
    }

    @Override
    protected void onPostExecute(ArrayList<String> result) {

        //Fyld imageViewet op

        Log.w("URI's FROM POST EXECUTE", result.toString());

//        if (ImageAdapter.URIs.size() > 0) {
//            ImageAdapter.URIs.clear();
//        }
//
//        ImageAdapter.URIs.addAll(result);

        ImageAdapter ia = new ImageAdapter();
        ia.refresh(result);
        Fragment_list.refreshGrid();
        ia.notifyDataSetChanged();

    }


    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }


}