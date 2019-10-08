package com.aalvarez.proyectof02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fragment02 extends AppCompatActivity {

    FragmentManager FM = getSupportFragmentManager();
    FragmentTransaction FT = FM.beginTransaction();
    Fragmento1 fragment1 = new Fragmento1();
    Fragmento2 fragment2 = new Fragmento2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment02);

    }

    public void mostrarFragmento1(View v) {
        FT.add(R.id.contenedor, fragment1);
        FT.commit();
    }

    public void mostrarFragmento2(View v) {
        FT.replace(R.id.contenedor, fragment2);
        FT.commit();
    }



}
