package com.example.mati.checkbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


    public class RadioButton extends AppCompatActivity {


        Button  vuelta;
        public void initialUISetup() {
            vuelta = (Button) findViewById(R.id.vuelta);

            vuelta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent miIntent = new Intent(RadioButton.this,MainActivityCheckBox.class);
                    startActivity(miIntent);
                    finish();

                }
            });

        }




        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_radio_button);
            final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
            final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
            rg.clearCheck();
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String textoOpcion="";
                    if( group.getCheckedRadioButtonId()==R.id.radio1)
                        textoOpcion +="OPCION 1 con ID:" + checkedId;
                    if( group.getCheckedRadioButtonId()==R.id.radio2)
                        textoOpcion +="OPCION 2 con ID:" + checkedId ;
                    lblMensaje.setText(textoOpcion);
                }
            });
            initialUISetup();
        }
    }