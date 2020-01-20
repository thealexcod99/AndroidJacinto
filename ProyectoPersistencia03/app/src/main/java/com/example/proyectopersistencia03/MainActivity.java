package com.example.proyectopersistencia03;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button btnGuardar;
    private Button btnRecuperar;
    private boolean sdDisponible = false;
    private boolean sdAccesoEscritura = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        comprobarTarjeta();


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File ruta_sd = Environment.getExternalStorageDirectory();
                    File file = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                    OutputStreamWriter fich =
                        new OutputStreamWriter(
                            new FileOutputStream(file));
                    fich.write(editText.getText().toString());
                    fich.close();
                }
                catch (Exception ex) {
                    Log.e("FICHEROS", "Error al escribir fichero en la SD");
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File ruta_sd = Environment.getExternalStorageDirectory();
                    File file = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                    BufferedReader fich = new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(file)));
                    textView.setText(fich.readLine());
                    fich.close();
                }
                catch (Exception ex) {
                    Log.e("FICHEROS", "Error al leer fichero desde la SD");
                }
            }
        });
    }

    private void comprobarTarjeta() {
        String estado = Environment.getExternalStorageState();
        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisponible = true;
            sdAccesoEscritura = true;
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisponible = true;
            sdAccesoEscritura = false;
        } else {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }
    }
}
