package com.example.proyectopersistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
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

        final List<String> datos = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, datos);
        listView.setAdapter(adapter);

        PruebaSQLiteHelper pruebaBBDD = new PruebaSQLiteHelper(this, "DBPrueba", null, 1);
        final SQLiteDatabase db = pruebaBBDD.getWritableDatabase();


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Boton Crear",Toast.LENGTH_LONG).show();
                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("texto1", texto1.getText().toString());
                nuevoRegistro.put("texto2", texto2.getText().toString());
                db.insert("prueba", null, nuevoRegistro);
            }
        });

        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Boton Leer",Toast.LENGTH_LONG).show();
                Cursor cursor = db.query("prueba", null, null, null, null, null, null);
                datos.clear();
                if(cursor.moveToFirst()){

                    do{
                        int id = cursor.getInt(0);
                        String data1 = cursor.getString(1);
                        String data2 = cursor.getString(2);
                        datos.add(id + ". " + data1 + " " + data2);


                    }while (cursor.moveToNext());
                    cursor.close();
                }
                adapter.notifyDataSetChanged();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Boton Borrar",Toast.LENGTH_LONG).show();

                db.delete("prueba", "codigo=" + codigo, null);
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Boton Actualizar",Toast.LENGTH_LONG).show();
                ContentValues actualizarRegistro = new ContentValues();
                actualizarRegistro.put("texto1", texto1.getText().toString());
                actualizarRegistro.put("texto2", texto2.getText().toString());
                db.update("prueba", actualizarRegistro, "codigo=" + codigo, null);

            }
        });


    }

}
