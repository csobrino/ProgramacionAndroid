package com.example.mati.fragmentosdiversos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SimpleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    // TODO: Rename and change types of parameters
    private int mParam1_num;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SimpleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SimpleFragment newInstance(int param1) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1_num = getArguments().getInt(ARG_PARAM1);
        }
        Toast.makeText(getContext(), "onCreate-FRAGMENTO" + mParam1_num, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = null;
        Toast.makeText(getContext(), "onCreateVIEW-FRAGMENTO" + mParam1_num, Toast.LENGTH_SHORT).show();
        // dependiendo de si es par o impar mostramos distintos layouts
        if (mParam1_num % 2 == 0) {
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            View tv = v.findViewById(R.id.text);
            //informamos el numero de Fragment
            ((TextView) tv).setText("Fragmento numero #" + mParam1_num);
        } else {
            v = inflater.inflate(R.layout.fragment_simple2, container, false);
            View tv = v.findViewById(R.id.text2);
            //informamos el nÃºmero de Fragment
            ((TextView) tv).setText("Fragmento numero #" + mParam1_num);
        }
        // Inflate the layout for this fragment
        return v;
    }
}