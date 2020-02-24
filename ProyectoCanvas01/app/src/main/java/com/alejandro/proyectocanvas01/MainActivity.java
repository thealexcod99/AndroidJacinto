package com.alejandro.proyectocanvas01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MiVista grafico = new MiVista(this);

        setContentView(grafico);




    }



    private class MiVista extends View {

        private int x = 25;
        private int y = 25;
        static final int radio = 25;
        private int alto;
        private int ancho;
        private Paint pincel;

        public MiVista(Context context) {
            super(context);
            pincel = new Paint();
            pincel.setColor(Color.BLUE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(x, y, radio, pincel);
            invalidate();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            ancho=w;
            alto=h;
        }
    }
}
