package com.alejandro.proyectodibujo02;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class DibujoView extends View {
    private int viewColor = 0;
    private float alto = 0f;
    private float ancho = 0f;
    private Paint pincel = new Paint();

    public void setViewColor(int viewColor) {
        this.viewColor = viewColor;
    }

    public int getViewColor() {
        invalidate();
        return viewColor;
    }

    public DibujoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        pincel.setStyle(Paint.Style.FILL);
        pincel.setFlags(Paint.ANTI_ALIAS_FLAG);
        TypedArray color = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DibujoView,0,0);
        viewColor = color.getInteger(R.styleable.DibujoView_vistaColor,0);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.viewColor == 0) {
            Random rnd = new Random();
            this.viewColor = Color.argb(255, (int) rnd.nextInt(256), (int) rnd.nextInt(256), (int) rnd.nextInt(256));
        }
        pincel.setColor(viewColor);
        canvas.drawRect(0,0,alto,ancho,pincel);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        alto = h;
        ancho = w;
    }
}
