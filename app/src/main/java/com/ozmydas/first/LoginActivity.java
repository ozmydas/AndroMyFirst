package com.ozmydas.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.text.TextWatcher;

import static android.os.Build.VERSION_CODES.M;


/**
 * Created by Admin on 20/12/2016.
 */

public class LoginActivity extends AppCompatActivity{

    EditText username, password;
    TextView notif;
    String strUser, strPass;

    protected void onCreate(Bundle savedStateInstance){
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_txtUsername);
        password = (EditText) findViewById(R.id.login_txtPassword);
        notif = (TextView) findViewById(R.id.login_notif);

        password.addTextChangedListener(inputPasswordWatcher);
    } //end onCreate


    /** TEXT WATCHER **/

    private final TextWatcher inputPasswordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //tidak ada yang dilakukan
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            notif.setVisibility(View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length()==0){
                notif.setVisibility(View.GONE);
            } else{
                notif.setText("Password Kamu : "+password.getText());
            }
        }
    };


    /** PROSES LOGIN **/

    public void loginProses(View view){
        strUser = username.getText().toString();
        strPass = password.getText().toString();

        if( (strUser.contains("master")) && (strPass.contains("master")) ){
            Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show();
            Intent gotoAbout = new Intent(LoginActivity.this, AboutActivity.class);
            startActivity(gotoAbout);
        } else if( (strUser.matches("")) || (strPass.matches("")) ){
            Toast.makeText(this, "Username dan Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show();
        } //endif
    } //end method

}
