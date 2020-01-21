package com.example.proyectopersistencia05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL("https://www.google.com/humans.txt");
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                            Integer estado = urlConnection.getResponseCode();
                            Toast.makeText(getApplicationContext(), estado.toString(), Toast.LENGTH_LONG).show();
                            *//*InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                texto = bufferedReader.lines().collect(Collectors.joining());

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(texto);
                                    }
                                });
                            }*//*
                            urlConnection.disconnect();

                        } catch (Exception ex) {
                            Log.e("FICHEROS", "Error al leer datos en la red");
                        }
                    }
                });*/

                try {
                    URL url = new URL("https://www.google.com/humans.txt");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.connect();
                    Integer estado = urlConnection.getResponseCode();
                    Toast.makeText(getApplicationContext(), estado.toString(), Toast.LENGTH_LONG).show();
                            /*InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                texto = bufferedReader.lines().collect(Collectors.joining());

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView.setText(texto);
                                    }
                                });
                            }*/
                    urlConnection.disconnect();

                } catch (Exception ex) {
                    Log.e("FICHEROS", "Error al leer datos en la red");
                }

            }
        });

    }
}
