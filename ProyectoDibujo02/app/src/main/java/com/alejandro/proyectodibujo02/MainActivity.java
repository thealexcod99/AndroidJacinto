package com.alejandro.proyectodibujo02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DibujoView dibujoView = new DibujoView(this);
        setContentView(R.layout.activity_main);
        //dibujoView.setViewColor(Color.CYAN);






    }
}
