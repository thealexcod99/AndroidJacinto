package com.aalvarez.proyecto01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
    }

    public void boton5(View v) {
        Intent pasar = new Intent(this, Activity5.class);
        startActivity(pasar);
    }


}
