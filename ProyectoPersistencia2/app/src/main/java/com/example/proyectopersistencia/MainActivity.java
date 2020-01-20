package com.example.proyectopersistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnCrear;
    private Button btnLeer;
    private Button btnBorrar;
    private Button btnActualizar;
    private EditText texto1;
    private EditText texto2;
    private int codigo;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.btnCrear);
        btnLeer = findViewById(R.id.btnLeer);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnActualizar = findViewById(R.id.btnActualizar);
        texto1 = findViewById(R.id.editText1);
        texto2 = findViewById(R.id.editText2);
        listView = findViewById(R.id.listView);

        /*List<String> datos = new ArrayList<>();
        datos.add("Dato1");
        datos.add("Dato2");
        datos.add("Dato3");
        datos.add("Dato4");
        datos.add("Dato5");

        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, datos);
        listView.setAdapter(adapter);*/

        PruebaSQLiteHelper pruebaBBDD = new PruebaSQLiteHelper(this, "DBPrueba", null, 1);
        final SQLiteDatabase db = pruebaBBDD.getWritableDatabase();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Boton Crear",Toast.LENGTH_LONG);
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("texto1", texto1.getText().toString());
                nuevoRegistro.put("texto2", texto2.getText().toString());
                db.insert("prueba", null, nuevoRegistro);
            }
        });

        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Boton Leer",Toast.LENGTH_LONG);
                /*String[] args = new String[] {"5"};
                * Cursor miCursor = db.rawQuery("SELECT codigo, texto1, texto2 FROM prueba WHERE codigo=?", );
                * txtResultado.setText
                */
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Boton Borrar",Toast.LENGTH_LONG);
                /*db.delete("prueba", "codigo=" + codigo, null);*/
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Boton Actualizar",Toast.LENGTH_LONG);

            }
        });




    }
}
