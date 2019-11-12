package com.example.proyectof05;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fragment05 extends AppCompatActivity {

    private FragmentManager FM;
    private FragmentTransaction FT;
    private Fragment preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment05);
        FM = getFragmentManager();
        FT = FM.beginTransaction();


    }

    public void mostrarPreferencias(View view) {
        preferencias = new Fragmento1();
        FT.replace(R.id.fragmentoPreferencias, preferencias);
        FT.commit();
    }
}
