package com.aalvarez.proyectof08;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

public class Contenido extends Fragment {
    final static String ARG_POSITION = "position";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment08, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        TextView contenido = (TextView) getActivity().findViewById(R.id.contenido);
        contenido.setText(Elementos.Contenidos[args.getInt(ARG_POSITION)]);
    }
}
