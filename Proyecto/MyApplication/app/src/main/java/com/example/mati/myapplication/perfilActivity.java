package com.example.mati.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class perfilActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        TextView userName = (TextView) findViewById(R.id.getUserName);
        TextView userPassword = (TextView) findViewById(R.id.getUserPassword);
        Button buttonChange = (Button) findViewById(R.id.buttonChangePass);
        userName.setText(MainActivity.userName);
        userPassword.setText(MainActivity.password);


        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(perfilDialog.newInstance(),"DIALOGO_PERFIL").commit();

            }
        });
    }


}

