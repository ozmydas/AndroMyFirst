package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Admin on 16/12/2016.
 */

public class SplashActivity extends AppCompatActivity {
    RelativeLayout introMessage;
    LinearLayout appContent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splashscreen);

        introMessage = (RelativeLayout) findViewById(R.id.splashBox);
        appContent = (LinearLayout) findViewById(R.id.contentBox);
    } //end method

    public void dismissWelcome(View view){
        introMessage.setVisibility(View.INVISIBLE);
        appContent.setVisibility(View.VISIBLE);
    } //end method

}
