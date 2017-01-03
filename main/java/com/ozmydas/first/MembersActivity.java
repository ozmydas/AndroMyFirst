package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * Created by Admin on 23/12/2016.
 */

public class MembersActivity extends AppCompatActivity{
    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;

    public static MembersActivity ma;

    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_members_list);

        Button tambah = (Button) findViewById(R.id.memlis_btn1);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lempar = new Intent(MembersActivity.this, MembersInsert.class);
                startActivity(lempar);
            }
        });

        ma = this;
        dbcenter = new DataHelper(this);

        refreshList();
    } //end onStart


    public void refreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM members", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

        ListView01 = (ListView) findViewById(R.id.memlis_listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);

        ListView01.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Members", "Update Members", "Hapus Members"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MembersActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int item){
                        switch (item){
                            case 0:
                                Intent i = new Intent(getApplicationContext(), MembersView.class);
                                i.putExtra("username", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent u = new Intent(getApplicationContext(), MembersUpdate.class);
                                u.putExtra("username", selection);
                                startActivity(u);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("DELETE FROM members WHERE name = '"+ selection +"'");
                                refreshList();
                                break;
                        }
                    }
                });
                builder.create().show();

            }
        });
        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();
    } //end method

}
