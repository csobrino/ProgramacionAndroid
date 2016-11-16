package com.example.mati.recopilacion;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mati.recopilacion.Destino;
import com.example.mati.recopilacion.R;


/**
 * Created by mati on 14/11/16.
 */
public class AdapterSpinner extends ArrayAdapter<Destino>
{
    private Activity context;
    private TextView textViewZona, textViewContinente, textViewPrecio;
    Destino[] destinos;
    public AdapterSpinner(Activity context, Destino[] destinos)
    {
        super(context, R.layout.layout_spinner,destinos);
        this.destinos = destinos;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.layout_spinner,null);
        }
        textViewZona = (TextView) view.findViewById(R.id.txtView_layoutSpinner_Zona);
        textViewContinente = (TextView) view.findViewById(R.id.txtView_layoutSpinner_Continente);
        textViewPrecio = (TextView) view.findViewById(R.id.txtView_layoutSpinner_Precio);

        textViewZona.setText(destinos[position].getZona());
        textViewContinente.setText(destinos[position].getContinente());
        textViewPrecio.setText(String.valueOf(destinos[position].getPrecio()));


        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = getView(position,convertView,parent);
        return view;
    }
}