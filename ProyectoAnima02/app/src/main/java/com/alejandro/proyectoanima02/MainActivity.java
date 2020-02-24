package com.alejandro.proyectoanima02;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        final ValueAnimator movimiento = ValueAnimator.ofFloat(0f, 180f);
        movimiento.setInterpolator(new AccelerateDecelerateInterpolator());
        movimiento.setDuration(2000);
        movimiento.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
                imageView.setRotation(progress);
                imageView.setRotationX(progress);
                imageView.setTranslationX(200f);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movimiento.start();
            }
        });
    }
}
