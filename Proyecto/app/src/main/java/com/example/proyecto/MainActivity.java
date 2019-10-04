package com.example.proyecto;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Button boton_eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //boton_eliminar = findViewById(R.id.boton_eliminar);
        Log.i("ESTADO", "estoy en onCreate");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ESTADO", "estoy en onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ESTADO", "estoy en onResume");
    }

    /*
    @Override
    public void onClick(View v) {
        boton1.setOnClickListener(this);
        boton1.setText("Boton1 Cambiado");
    }*/

    /* Forma 3 */
    public void pulsado(View vista) {
        finish();

    }

}
