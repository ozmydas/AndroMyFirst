package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.ozmydas.first.R.id.txtEmail;
import static com.ozmydas.first.R.id.txtName;
import static com.ozmydas.first.R.id.txtPassword;
import static com.ozmydas.first.R.id.txtPhone;
import static com.ozmydas.first.R.id.txtUsername;

/**
 * Created by Admin on 23/12/2016.
 */

public class MembersInsert extends AppCompatActivity{
    protected Cursor cursor;
    SQLiteDatabase db;
    DataHelper dbHelper;
    Button btnSubmit;
    EditText txtUsername, txtPassword, txtName, txtTTL, txtAddress;


    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_member_register);

        dbHelper = new DataHelper(this);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtName = (EditText) findViewById(R.id.txtName);
        txtTTL = (EditText) findViewById(R.id.txtBirthdate);
        txtAddress = (EditText) findViewById(R.id.txtAddress);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO members(username, password, name, birthdate, address) VALUES( '" +
                        txtUsername.getText().toString() + "', '" +
                        txtPassword.getText().toString() + "', '" +
                        txtName.getText().toString() + "', '" +
                        txtTTL.getText().toString() + "', '" +
                        txtAddress.getText().toString() + "' )");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();

                MembersActivity.ma.refreshList();
                finish();
            }
        });

    } //end onCreate




}
