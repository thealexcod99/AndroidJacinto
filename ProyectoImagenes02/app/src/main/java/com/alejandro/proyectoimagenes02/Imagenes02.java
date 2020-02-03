package com.alejandro.proyectoimagenes02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Imagenes02 extends AppCompatActivity {
    AnimationDrawable animation;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes02);
        ImageView image= (ImageView) findViewById(R.id.imagen);
        image.setVisibility(ImageView.VISIBLE);
        image.setBackgroundResource(R.drawable.fotogramas);
        animation = (AnimationDrawable) image.getBackground();
        Button boton1=(Button) findViewById(R.id.button1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.start();
            }
        });
        Button boton2=(Button) findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation.stop();
            }
        });
    }
}