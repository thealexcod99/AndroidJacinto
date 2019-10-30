package com.aalvarez.proyectof10;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class Fragmento2  extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_unpanel);
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA, //ERROR
                    getIntent().getStringExtra(Fragmento3.ARG_ID_ENTRADA_SELECCIONADA));  //No llega ningun id
            Fragmento3 fragment = new Fragmento3();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.frame_contenedor, fragment).commit();
        }

    }
}
