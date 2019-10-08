package com.aalvarez.proyectof03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

public class Fragmento1 extends ListFragment {

    private String[] artistas = {"Alberto Durero","Miguel Ángel","Rafael Sanzio","Tiziano ",
            "Donatello ","Paolo Uccello","Giotto","Peter Breughel","F. Brunelleschi",
            "Fra Angelico","A. Mantegna","Leonardo","G. Bellini","S. Botticelli","Cosimo Rosselli",
            "Masaccio","Ghirlandaio","Giorgione","Filippino Lippi","P. della Francesca"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento1, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, artistas));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "Ha pulsado " + artistas[position], Toast.LENGTH_SHORT).show();
    }
}


//definicion de dispositivo movil
//Tipos de dispositivos moviles
//inconvenientes a la hora de programar dispositivos moviles
//HOJA, quien ha creado android
//arquitectura de android
//lenguajes de programacion de cada dispositivo
//entorno de desarrollo
//resumen de android
//tipos de lenguajes de programación