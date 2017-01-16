package com.example.mati.pruebasbdsqllite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mati on 11/01/17.
 */
public class adapterCliente_Spinner extends ArrayAdapter<Cliente> {
        private TextView textViewNombre,textViewTelefono,textViewCodigo;
        Context context;
        private List<Cliente>clientes;

        public adapterCliente_Spinner(Context context, List<Cliente> clientes) {
            super(context, R.layout.spinner_clientes, clientes);
            this.context = context;
            this.clientes = clientes;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null){
                view = inflater.inflate(R.layout.spinner_clientes,null);
            }
            textViewNombre = (TextView) view.findViewById(R.id.textView_Spinner_Nombre);
            textViewTelefono = (TextView) view.findViewById(R.id.textView_Spinner_Telefono);
            textViewCodigo = (TextView) view.findViewById(R.id.textView_Spinner_Codigo);


            textViewNombre.setText(clientes.get(position).getNombre());
            textViewTelefono.setText(clientes.get(position).getTelefono());
            textViewCodigo.setText(String.valueOf(clientes.get(position).getCodigo()));

            return view;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getView(position,convertView,parent);

        }
    }