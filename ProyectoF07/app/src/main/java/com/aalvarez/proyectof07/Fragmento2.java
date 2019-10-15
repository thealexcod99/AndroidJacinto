package com.aalvarez.proyectof07;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragmento2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        final Button btn1 = (Button) getActivity().findViewById(R.id.btnImportarTexto2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView lbl = (TextView) getActivity().findViewById(R.id.texto1);
                Toast.makeText(getActivity(), lbl.getText(), Toast.LENGTH_SHORT).show();

                Button btn2 = (Button) getActivity().findViewById(R.id.btnExportarTexto2);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView texto = (TextView) getActivity().findViewById(R.id.texto2);
                        texto.setText("TOCADO FRAG 2");
                    }
                });
            }
        });
    }
}
