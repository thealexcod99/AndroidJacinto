package com.aalvarez.proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
    }

    public void boton7(View v) {
        Intent pasar = new Intent(this, Activity7.class);
        startActivity(pasar);
    }
}
