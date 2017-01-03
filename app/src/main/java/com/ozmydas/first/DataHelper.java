package com.ozmydas.first;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Admin on 23/12/2016.
 */

public class DataHelper extends  SQLiteOpenHelper{

    private static final String DATABASE_NAME = "ozmybase.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //todo auto generated constructor stub
    } //end methods


    public void onCreate(SQLiteDatabase db){
        //todo auto generated method stub
        String sql = "CREATE TABLE members(id integer primary key, username text, password text, name text, birthdate text null, gender text null, address text null);";
        Log.d("Data", "onCreate: "+sql);
        db.execSQL(sql);

        sql = "INSERT INTO members(id, username, password, name, birthdate, gender, address) VALUES ('1', 'master', 'master', 'Aba', '2000-01-01', 'male', 'Jakarta')";
        db.execSQL(sql);
    } //end method


    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
        //todo auto generated method sub
    } //end method

}
