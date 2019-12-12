package com.example.proyectosensores08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class Sensores08 extends AppCompatActivity implements SensorEventListener {

    public static int x = 0;
    public static int y = 0;
    public static int centrox = 250;
    public static int centroy = 250;
    private SensorManager sensorManager;
    private Sensor acelerometro;
    private ShapeDrawable mDibujo;
    private ConstraintLayout mainLayout;
    private View miVista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores08);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mDibujo = new ShapeDrawable();
        mainLayout = findViewById(R.id.lay);
        miVista = new MiVistaPersonal(this);
        mainLayout.addView(miVista);


    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = centrox + (int) Math.pow(event.values[1], 2);
        y = centroy + (int) Math.pow(event.values[2], 2);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public class MiVistaPersonal extends View {

        static final int ancho = 100;
        static final int alto = 100;

        public MiVistaPersonal(Context context) {
            super(context);
            mDibujo = new ShapeDrawable(new OvalShape());
            mDibujo.getPaint().setColor(0xff74AC23);
            mDibujo.setBounds(x,y,x+ancho,y+alto);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            RectF oval = new RectF(Sensores08.x, Sensores08.y, Sensores08.x + ancho, Sensores08.y +alto);
            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            canvas.drawOval(oval, pincel);
            invalidate();
        }
    }
}


