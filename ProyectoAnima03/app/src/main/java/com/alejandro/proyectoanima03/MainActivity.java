package com.alejandro.proyectoanima03;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        ObjectAnimator movimiento1 = ObjectAnimator.ofFloat(imageView, "rotation", 360f);
        movimiento1.setDuration(2000);
        ObjectAnimator movimiento2 = ObjectAnimator.ofFloat(imageView, "translationX", metrics.widthPixels);
        movimiento2.setDuration(2000);
        ObjectAnimator movimiento3 = ObjectAnimator.ofFloat(imageView, "translationY", metrics.heightPixels);
        movimiento3.setDuration(2000);

        final AnimatorSet variosMovimientos = new AnimatorSet();
        variosMovimientos.playTogether(movimiento1, movimiento2, movimiento3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                variosMovimientos.start();
            }
        });
    }
}
