package com.ozmydas.first;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Admin on 23/12/2016.
 */

public class MembersView extends AppCompatActivity {

    TextView name, ttl, gender, address;
    SQLiteDatabase db;
    DataHelper dbHelper;
    protected Cursor cursor;
    Button btnBack;

    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_members_view);

        //define variable
        name = (TextView)findViewById(R.id.memvi_name);
        ttl = (TextView) findViewById(R.id.memvi_ttl);
        gender = (TextView) findViewById(R.id.memvi_gender);
        address = (TextView) findViewById(R.id.memvi_address);
        btnBack = (Button) findViewById(R.id.memvi_btnBack);

        //define database query
        dbHelper = new DataHelper(this);
        db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM members WHERE username='"+getIntent().getStringExtra("username")+"'", null);
        cursor.moveToFirst();

        //assign data
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            name.setText(cursor.getString(3).toString());
            ttl.setText(cursor.getString(4).toString());
            gender.setText(cursor.getString(5).toString());
            address.setText(cursor.getString(6).toString());
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    } //end onCreate



}
