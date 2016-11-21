package com.example.mati.examen_pmm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoFactura extends AppCompatActivity {

    private TextView textViewZona, textViewTarifa, textViewPeso, textViewDecoracion, textViewCosteFinal;
    private ImageView imageViewModelo;
    private Factura facturaResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_factura);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iniciarComponentesUI();
        registerForContextMenu(imageViewModelo);
    }

    private void iniciarComponentesUI() {
        textViewZona = (TextView) findViewById(R.id.textView_Factura_Zona);
        textViewTarifa = (TextView) findViewById(R.id.textView_Factura_Tarifa);
        textViewPeso = (TextView) findViewById(R.id.textView_Factura_Peso);
        textViewDecoracion = (TextView) findViewById(R.id.textView_Factura_Decoracion);
        textViewCosteFinal = (TextView) findViewById(R.id.textView_Factura_CosteFinal);
        imageViewModelo = (ImageView) findViewById(R.id.imageView_Factura_Mapa);
        Intent intent = getIntent();
        facturaResultado = (Factura) intent.getSerializableExtra("factura");
        textViewZona.setText(facturaResultado.getModelo()+" ("+facturaResultado.getMarca()+")");
        textViewTarifa.setText(facturaResultado.getTipoSeguro());
        textViewPeso.setText(String.valueOf(facturaResultado.getPesoPaquete()));
        textViewDecoracion.setText(facturaResultado.getTipoExtras());
        textViewCosteFinal.setText(String.valueOf(facturaResultado.getPrecioFinal()));

        switch (facturaResultado.getModelo()){
            case "Megane":
                imageViewModelo.setImageResource(R.drawable.megan1);
                break;
            case "x-11":
                imageViewModelo.setImageResource(R.drawable.ferrari3);
                break;
            case "Leon":
                imageViewModelo.setImageResource(R.drawable.leon1);
                break;
            case "Fiesta":
                imageViewModelo.setImageResource(R.drawable.fiesta2);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenuContextual_Zona:
                Toast.makeText(this,"ZONA "+facturaResultado.getModelo()+"\n"+facturaResultado.getMarca(), Toast.LENGTH_SHORT).show();
                break;
            default:
                super.onContextItemSelected(item);
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual_mundo,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.home:
                setResult(RESULT_OK);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
