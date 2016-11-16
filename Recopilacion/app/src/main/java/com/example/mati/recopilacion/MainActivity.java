package com.example.mati.recopilacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButtonNormal, radioButtonUrgente;
    CheckBox checkBoxRegalo, checkBoxDedicada;
    EditText editText;
    Button button;
    RadioGroup radioGroup;
    String mensaje;
    Facturacion facturacion= new Facturacion();
    Spinner spinner;
    private Destino[] destinos = new Destino[]
            {
                    new Destino("ZonaA","Asia y Oceanía",30),
                    new Destino("ZonaB","América y África",20),
                    new Destino("ZonaC","Europa",10)};

    final static String zona[]={"zona a","Asia y Oceania","30"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this,Pantalla2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("factura",facturacion);
                startActivity(miIntent);

            }
    });

}
    private void iniciarComponentes()
    {
        radioButtonNormal = (RadioButton) findViewById(R.id.radioButtonNormal);
        radioButtonUrgente = (RadioButton) findViewById(R.id.radioButtonUrgente);
        spinner = (Spinner) findViewById(R.id.spinner);
        checkBoxDedicada = (CheckBox)findViewById(R.id.checkBoxCaja);
        checkBoxRegalo = (CheckBox)findViewById(R.id.checkBoxTarjeta);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.buttonCalcular);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        AdapterSpinner adapter = new AdapterSpinner(this,destinos );

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            facturacion.setPrecioZona(destinos[position].getPrecio());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(!editText.getText().toString().isEmpty()) {
            facturacion.setPesoPaquete(Double.parseDouble(editText.getText().toString()));
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getId()){
                    case R.id.radioButtonNormal:
                        break;
                    case R.id.radioButtonUrgente:
                        facturacion.setUrgente(true);
                        break;
                }
            }
        });
    }
}
