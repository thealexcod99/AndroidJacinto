package com.example.proyectopersistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView texto1;
    private TextView texto2;
    private Button boton1;
    private Button boton2;
    private EditText edit1;
    private EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto1 = findViewById(R.id.textView1);
        texto2 = findViewById(R.id.textView2);
        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        edit1 = findViewById(R.id.editText1);
        edit2 = findViewById(R.id.editText2);

        final SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);



        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Text1", edit1.getText().toString());
                editor.putString("Text2", edit2.getText().toString());
                editor.commit();
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto1.setText(prefs.getString("Text1", ""));
                texto2.setText(prefs.getString("Text2", ""));
            }
        });
    }
}
