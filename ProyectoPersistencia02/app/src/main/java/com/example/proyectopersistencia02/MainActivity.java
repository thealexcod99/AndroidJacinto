package com.example.proyectopersistencia02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button btnGuardar;
    private Button btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnRecuperar = findViewById(R.id.btnRecuperar);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStreamWriter fich =
                        new OutputStreamWriter(
                            openFileOutput("prueba.txt", Context.MODE_PRIVATE));
                    fich.write(editText.getText().toString());
                    fich.close();
                }
                catch (Exception ex) {
                    Log.e("FICHEROS", "Error al escribir fichero a memoria interna");
                }
            }
        });

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedReader fich =
                        new BufferedReader(
                            new InputStreamReader(
                                openFileInput("prueba.txt")));
                    textView.setText(fich.readLine());
                    fich.close();
                }
                catch (Exception ex) {
                    Log.e("FICHEROS", "Error al leer fichero desde memoria interna");
                }
            }
        });
    }
}
