package com.example.mati.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by mati on 30/01/17.
 */
public class perfilDialog extends DialogFragment{
    public static perfilDialog newInstance() {
        
        Bundle args = new Bundle();
        
        perfilDialog fragment = new perfilDialog();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.perfil_changepassword,null);
        builder.setView(view);
        
        return builder.create();
    }
}
