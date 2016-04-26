package com.example.blog.advancedassignment;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        Log.w("START", "App started");

        ImageAdapter.URIs.add("/storage/sdcard0/DCIM/Camera/IMG_20160419_184458.jpg");

        final Button takePhotoButton = (Button) findViewById(R.id.addPhotoButton);
        final Button loadPhotosButton = (Button) findViewById(R.id.loadImagesButton);


        takePhotoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
            }
        });

        loadPhotosButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                new LoadImageTask(MainActivity.this).execute();

            }

        });


    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if(id == R.id.action_settings){
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}



