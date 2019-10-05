package com.aalvarez.proyecto01;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity7 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity7);
    }

    public void boton1(View v) {
        Intent pasar = new Intent(this, MainActivity.class);
        startActivity(pasar);
    }

    public void boton2(View v) {
        Intent pasar = new Intent(this, Activity2.class);
        startActivity(pasar);
    }

    public void botonSalir(View v) {
        finishAffinity();
    }

}
