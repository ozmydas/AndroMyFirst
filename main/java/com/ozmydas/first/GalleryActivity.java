package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Admin on 20/12/2016.
 */

public class GalleryActivity extends AppCompatActivity {

    ImageView iniGambar;
    Button btnNext, btnPrev;

    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_gallery);

        //set var
        iniGambar = (ImageView) findViewById(R.id.imgGaller);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrev = (Button) findViewById(R.id.btnPrev);

        //hide button prev
        btnPrev.setVisibility(View.INVISIBLE);
    } //end onCreate


    public void nextImage(View view){
        //mainkan tombol
        btnNext.setVisibility(View.INVISIBLE);
        btnPrev.setVisibility(View.VISIBLE);
        //mainkan gambar
        iniGambar.setImageResource(R.drawable.image_2);
    } //end method


    public void previousImage(View view){
        //mainkan tombol
        btnNext.setVisibility(View.VISIBLE);
        btnPrev.setVisibility(View.INVISIBLE);
        //mainkan gambar
        iniGambar.setImageResource(R.drawable.image_1);
    } //end method

}
