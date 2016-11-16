package com.example.mati.recopilacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    private TextView textViewZonas, textViewTarifas, textViewPeso,textViewFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        initComponents();

    }
    private void initComponents(){
        textViewZonas = (TextView)findViewById(R.id.textViewZona);
        textViewTarifas = (TextView)findViewById(R.id.textViewTarifa);
        textViewFinal = (TextView)findViewById(R.id.textViewFinal);
        textViewPeso = (TextView)findViewById(R.id.textViewPeso);
    }
    private void mostrarDatos(){
        Intent intent = getIntent();
        Bundle bundle = 
    }
}
