package com.aalvarez.proyectomaterial04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Material04 extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private FloatingActionButton fab;
    private Button btnSimple;
    private Button btnInteractivo;
    private Button btnPersonalizado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material04);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        fab = findViewById(R.id.fab);
        btnSimple = findViewById(R.id.btnSimple);
        btnInteractivo = findViewById(R.id.btnInteractivo);
        btnPersonalizado = findViewById(R.id.btnPersonalizado);
    }

    public void funBtnSimple(View view) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "EJEMPLO SNACKBAR", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void funBtnInteractivo(View view) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "EJEMPLO SNACKBAR", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "MENSAJE RESTAURADO", Snackbar.LENGTH_LONG);
                        snackbar1.show();
                    }
                });
        snackbar.show();
    }

    public void funBtnPersonalizado(View view) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, "EJEMPLO SNACKBAR", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "MENSAJE RESTAURADO", Snackbar.LENGTH_LONG);
                        View sbView = snackbar1.getView();
                        TextView texto = (TextView) sbView.findViewById(R.id.snackbar_text);
                        texto.setTextColor(Color.YELLOW);
                        snackbar1.setActionTextColor(Color.CYAN);
                        snackbar1.show();
                    }
                });
        snackbar.show();
    }
}
