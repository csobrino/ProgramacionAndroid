package com.example.mati.examen_pmm;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class AdaptadorSpinner extends ArrayAdapter<Destino>
{
    private TextView textViewZona,textViewContinente,textViewPrecio, imagen;
    private Activity context;
    private Destino[] destinos;
    public AdaptadorSpinner(Activity context, Destino[] destinos) {
        super(context, R.layout.content_spinner, destinos);
        this.context = context;
        this.destinos = destinos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.content_spinner,null);
        }
        textViewZona = (TextView) view.findViewById(R.id.textView_Spinner_Zona);
        textViewContinente = (TextView) view.findViewById(R.id.textView_Spinner_Continente);
        textViewPrecio = (TextView) view.findViewById(R.id.textView_Spinner_Precio);


        textViewZona.setText(destinos[position].getModelo());
        textViewContinente.setText(destinos[position].getMarca());
        textViewPrecio.setText(String.valueOf(destinos[position].getPrecio()));

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = getView(position,convertView,parent);
        return view;
    }
}
