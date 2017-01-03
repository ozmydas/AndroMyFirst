package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.net.Uri;

/**
 * Created by Admin on 18/12/2016.
 */

public class AboutActivity extends AppCompatActivity{

    Button tombol;
    Button browse;
    Button galeri, home;

    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_about);

        tombol = (Button) findViewById(R.id.btnGoto);
        tombol.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicit_intent = new Intent(AboutActivity.this, MembersActivity.class);
                startActivity(explicit_intent);
            }
        });

        galeri = (Button) findViewById(R.id.btnToGallery);
        galeri.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toGallery_intent = new Intent(AboutActivity.this, GalleryActivity.class);
                startActivity(toGallery_intent);
            }
        });

        home = (Button) findViewById(R.id.btnToHome);
        home.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(AboutActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });

        browse = (Button) findViewById(R.id.btnBrowse);
        browse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri alamat = Uri.parse("http://facebook.com");

                Intent browse_intent = new Intent(Intent.ACTION_VIEW, alamat);
                startActivity(browse_intent);
            }
        });

    } //end method onCreate


}
