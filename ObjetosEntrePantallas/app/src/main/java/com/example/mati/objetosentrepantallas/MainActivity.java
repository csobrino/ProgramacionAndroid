package com.example.mati.objetosentrepantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    protected EditText eTextNombre, eTextApellido, eTextEdad;
    protected Button btnSiguiente;
    protected Intent miIntent;
    protected Bundle miBundle;
    protected RadioGroup miRadioGroup;

        String nombre, apellido;
        int edad,imagen;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicioDatos();
    }

    public void inicioDatos() {
        eTextNombre = (EditText) findViewById(R.id.eTextNombre);
        eTextApellido = (EditText) findViewById(R.id.eTextApellido);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        eTextEdad = (EditText) findViewById(R.id.iTypeEdad);
        miRadioGroup = (RadioGroup) findViewById(R.id.rGroupSexo);

        siguiente();
    }
    public void siguiente(){
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datosPersona();
                miIntent = new Intent(MainActivity.this,Pantalla2.class);
                miBundle = new Bundle();
                Persona persona  = new Persona(nombre,apellido,edad, imagen);
                miBundle.putSerializable("Persona", persona );
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

            }
        });
    }
    protected void datosPersona (){

        nombre = eTextNombre.getText().toString();
        apellido = eTextApellido.getText().toString();
        edad = Integer.parseInt(eTextEdad.getText().toString());
        if (miRadioGroup.getCheckedRadioButtonId()== R.id.rbuttonH)
        {
            imagen = R.drawable.persona1;
        }
        if (miRadioGroup.getCheckedRadioButtonId()== R.id.rbuttonF)
        {
            imagen = R.drawable.persona2;
        }

    }
}
