package com.aalvarez.proyecto01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5);
    }

    public void boton1(View v) {
        Intent pasar = new Intent(this, MainActivity.class);
        startActivity(pasar);
    }

    public void boton3(View v) {
        Intent pasar = new Intent(this, Activity3.class);
        startActivity(pasar);
    }

}
