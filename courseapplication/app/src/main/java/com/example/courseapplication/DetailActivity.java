package com.example.courseapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.ITEM_INDEX", -1);

        if (index > -1){
            int pic = getImage(index); //first get the image we want
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    private int getImage(int index){
        switch (index) {
            case 0: return R.drawable.eka;
            case 1: return R.drawable.toka;
            case 2: return R.drawable.kolmas;
            default: return -1;
        }
    }
    private void scaleImg(ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay(); //default displaysize acssees
        BitmapFactory.Options options = new BitmapFactory.Options(); //factory java library class that scales images

        options.inJustDecodeBounds = true; // boundaries
        BitmapFactory.decodeResource(getResources(), pic, options); //Optimizes the code..

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round( (float)imgWidth/(float)screenWidth);
            options.inSampleSize = ratio;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaleImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaleImg);

    }
}