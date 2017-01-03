package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;


/**
 * Created by Admin on 18/12/2016.
 */


public class EmptyAlertActivity extends AppCompatActivity{

    EditText input;
    Button check;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactform);

        input = (EditText) findViewById(R.id.txtName);
        check = (Button) findViewById(R.id.btnSubmit);

        check.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(input.getText().toString().equals("")){
                    Toast.makeText(EmptyAlertActivity.this, "Input Text Kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EmptyAlertActivity.this, "Gotcha!", Toast.LENGTH_SHORT).show();
                } //end if

            } //end void onClick

        }); //end check.set

    } //end method

}
