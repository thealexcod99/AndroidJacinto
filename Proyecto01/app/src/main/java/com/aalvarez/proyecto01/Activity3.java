package com.aalvarez.proyecto01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
    }

    public void boton4(View v) {
        Intent pasar = new Intent(this, Activity4.class);
        startActivity(pasar);
    }

    public void boton6(View v) {
        Intent pasar = new Intent(this, Activity6.class);
        startActivity(pasar);
    }


}
