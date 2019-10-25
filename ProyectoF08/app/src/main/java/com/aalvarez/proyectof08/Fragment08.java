package com.aalvarez.proyectof08;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class Fragment08 extends FragmentActivity implements Cabecera.CabeceraListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment08);
        Cabecera primerFragmento = new Cabecera();
        primerFragmento.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor, primerFragmento).commit();
        if (savedInstanceState != null) {return;}

    }

    public void tocado(int position) {
        //Toast.makeText(getBaseContext(), "TOCADO EL "+ String.valueOf(position+1),Toast.LENGTH_SHORT).show();
        Contenido detalle = new Contenido();
        Bundle args = new Bundle();
        args.putInt(Contenido.ARG_POSITION, position);
        detalle.setArguments(args);
        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.replace(R.id.contenedor, detalle);
        FT.addToBackStack(null);
        FT.commit();
    }



}
