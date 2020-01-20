package com.example.proyectopersistencia05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    URL url = new URL("https://www.google.com/humans.txt");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setReadTimeout(10000);
                    urlConnection.setConnectTimeout(15000);
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setDoInput(true);
                    urlConnection.connect();
                    StringBuffer strBuff = new StringBuffer();
                    BufferedReader fichRedH = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                    String texto;
                    while ((texto = fichRedH.readLine()) != null) {
                        strBuff.append(texto);
                    }
                    fichRedH.close();
                    textView.setText(strBuff.toString());

                } catch (Exception ex) {
                    Log.e("FICHEROS", "Error al leer datos en la red");
                }
            }
        });

    }
}
