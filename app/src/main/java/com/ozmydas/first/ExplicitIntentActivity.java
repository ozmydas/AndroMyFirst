package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

/**
 * Created by Admin on 20/12/2016.
 */

public class ExplicitIntentActivity extends ActionBarActivity{

    Button browse;

    public void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_about);

        browse = (Button) findViewById(R.id.btnBrowse);

        browse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri alamat = Uri.parse("http://www.facebook.com");

                Intent browse_intent = new Intent(Intent.ACTION_VIEW, alamat);
                startActivity(browse_intent);
            }
        });
    } //end func

}
