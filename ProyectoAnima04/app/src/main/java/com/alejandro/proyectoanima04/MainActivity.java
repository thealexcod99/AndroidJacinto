package com.alejandro.proyectoanima04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        int ancho = layout.getMaxWidth() / 2;
        int alto = layout.getMaxHeight() / 2;

        float radio_final = (float) Math.hypot(ancho,alto);

        Animator movimiento = ViewAnimationUtils.createCircularReveal(layout, ancho, alto, 0, radio_final);
        layout.setVisibility(View.INVISIBLE);
        movimiento.start();
    }
}
