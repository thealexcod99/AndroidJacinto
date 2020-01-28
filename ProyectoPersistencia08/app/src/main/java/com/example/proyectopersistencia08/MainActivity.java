package com.example.proyectopersistencia08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAnio;
    private Button btnListar;
    private Button btnCrear;
    private Button btnBorrar;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAnio = findViewById(R.id.editTextAnio);
        btnListar = findViewById(R.id.btnListar);
        btnCrear = findViewById(R.id.btnCrear);
        btnBorrar = findViewById(R.id.btnBorrar);
        gridView = findViewById(R.id.gridView);


        String[] projection = new String[] {
                PruebaProviderMetaData.PruebaTablaMetaData._ID,
                PruebaProviderMetaData.PruebaTablaMetaData.NAME,
                PruebaProviderMetaData.PruebaTablaMetaData.ANIO};

        Uri datosUri = PruebaProviderMetaData.PruebaTablaMetaData.CONTENT_URI;

        ContentResolver cr = getContentResolver();

        Cursor cur = cr.query(datosUri,
                projection, //Columnas a devolver
                null,       //Condición de la query
                null,       //Argumentos variables de la query
                PruebaProviderMetaData.PruebaTablaMetaData.DEFAULT_SORT_ORDER);


        final CursorAdapter cursorAdapter = new CursorAdapter(this, cur) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

                TextView textViewName = view.findViewById(R.id.textViewName);
                TextView textViewAnio = view.findViewById(R.id.textViewAnio);
                TextView textViewId = view.findViewById(R.id.textViewId);

                int colName = cursor.getColumnIndex(PruebaProviderMetaData.PruebaTablaMetaData.NAME);
                int colAnio = cursor.getColumnIndex(PruebaProviderMetaData.PruebaTablaMetaData.ANIO);
                int colId = cursor.getColumnIndex(PruebaProviderMetaData.PruebaTablaMetaData.ID);

                textViewName.setText(cursor.getString(colName));
                textViewAnio.setText(cursor.getString(colAnio));
                textViewId.setText(cursor.getInt(colId));
            }


        };

        gridView.setAdapter(cursorAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] projection = new String[] {
                        PruebaProviderMetaData.PruebaTablaMetaData._ID,
                        PruebaProviderMetaData.PruebaTablaMetaData.NAME,
                        PruebaProviderMetaData.PruebaTablaMetaData.ANIO};

                Uri datosUri = PruebaProviderMetaData.PruebaTablaMetaData.CONTENT_URI;

                ContentResolver cr = getContentResolver();

                Cursor curlista = cr.query(datosUri,
                        projection, //Columnas a devolver
                        null,       //Condición de la query
                        null,       //Argumentos variables de la query
                        PruebaProviderMetaData.PruebaTablaMetaData.DEFAULT_SORT_ORDER);

                cursorAdapter.changeCursor(curlista);

            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();

                values.put(PruebaProviderMetaData.PruebaTablaMetaData.NAME, editTextName.getText().toString());
                values.put(PruebaProviderMetaData.PruebaTablaMetaData.ANIO, editTextAnio.getText().toString());

                ContentResolver cr = getContentResolver();

                cr.insert(PruebaProviderMetaData.PruebaTablaMetaData.CONTENT_URI, values);

                editTextName.setText("");
                editTextAnio.setText("");
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver cr = getContentResolver();

                cr.delete(PruebaProviderMetaData.PruebaTablaMetaData.CONTENT_URI,
                        "id= " + "ID DEL DATO", null);
            }
        });

    }
}
