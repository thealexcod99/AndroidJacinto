package com.alejandro.proyectotactil01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout arribaIzquierda;
    private LinearLayout arribaDerecha;
    private LinearLayout abajoIzquierda;
    private LinearLayout abajoDerecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arribaIzquierda = findViewById(R.id.arribaIzquierda);
        arribaDerecha = findViewById(R.id.arribaDerecha);
        abajoIzquierda = findViewById(R.id.abajoIzquierda);
        abajoDerecha = findViewById(R.id.abajoDerecha);

        arribaIzquierda.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Rojo tocado",Toast.LENGTH_LONG).show();
                return true;
            }
        });

        arribaDerecha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Verde tocado",Toast.LENGTH_LONG).show();
                return true;
            }
        });

        abajoIzquierda.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Azul tocado",Toast.LENGTH_LONG).show();
                return true;
            }
        });

        abajoDerecha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(), "Amarillo tocado",Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
