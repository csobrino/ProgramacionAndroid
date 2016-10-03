package com.example.mati.checkbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityCheckBox extends AppCompatActivity {
    CheckBox chkBoxBici, chkBoxBoxeo, chkBoxGames;
    Button btnBoton1, btnBoton2, radioBoton;
    TextView txtRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_check_box);

        initialUISetup();
    }

    public void initialUISetup(){
        chkBoxBici = (CheckBox) findViewById(R.id.chkBoxBici);
        chkBoxBoxeo= (CheckBox) findViewById(R.id.chkBoxBoxeo);
        chkBoxGames= (CheckBox) findViewById(R.id.chkBoxGames);
        btnBoton1  = (Button) findViewById(R.id.btnBoton1);
        btnBoton2 = (Button) findViewById(R.id.btnBoton2);
        radioBoton = (Button) findViewById(R.id.radioBoton);
        txtRespuesta=(TextView) findViewById(R.id.TxtRespuesta);

        btnBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });

        btnBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivityCheckBox.this,CehckBox2.class);
                startActivity(miIntent);
            }
        });
        radioBoton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent miIntent2= new Intent(MainActivityCheckBox.this, RadioButton.class);
                startActivity(miIntent2);
            }
        });




    }
    public void getHobbyClick(View v) {
        String mensaje = "";

        if (chkBoxBici.isChecked()) {
            mensaje += "Montar en bici ";
        }
        if (chkBoxBoxeo.isChecked()) {
            mensaje += "Practicar boxeo";
        }
        if (chkBoxGames.isChecked()) {
            mensaje += "Jugar a videojuegos";
        }
        showTextNotification(mensaje);
    }
    public void showTextNotification(String msgToDisplay) {
        txtRespuesta.setText(msgToDisplay);
        Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
    }

