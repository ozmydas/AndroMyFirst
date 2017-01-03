package com.ozmydas.first;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Admin on 23/12/2016.
 */

public class MembersUpdate extends AppCompatActivity {
    EditText name, ttl, gender, address;
    Button btnUpdate;
    SQLiteDatabase db;
    DataHelper dbHelper;
    Cursor cursor;

    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_members_update);

        name = (EditText) findViewById(R.id.txtName);
        ttl = (EditText) findViewById(R.id.txtBirthdate);
        gender = (EditText) findViewById(R.id.txtGender);
        address = (EditText) findViewById(R.id.txtAddress);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        dbHelper = new DataHelper(this);

        //select and asign data to input
        db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM members where username='"+getIntent().getStringExtra("username")+"'", null);
        cursor.moveToFirst();

        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            name.setText(cursor.getString(3).toString());
            ttl.setText(cursor.getString(4).toString());
            gender.setText(cursor.getString(5).toString());
            address.setText(cursor.getString(6).toString());
        }

        //when user clik update and data saved to database
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("UPDATE members SET name='"+
                        name.getText().toString()+"', birthdate='"+
                        ttl.getText().toString()+"', gender='"+
                        gender.getText().toString()+"', address='"+
                        address.getText().toString()+"' WHERE username='"+
                        getIntent().getStringExtra("username")+"'");

                Toast.makeText(getApplicationContext(), "Berhasil Terupdate", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    } //end onCreate

    public void moveFinish(View view){
        finish();
    }



}
