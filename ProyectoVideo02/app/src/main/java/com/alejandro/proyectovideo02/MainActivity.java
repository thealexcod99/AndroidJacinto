package com.alejandro.proyectovideo02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnReproducir;
    private Button btnPausar;
    private Spinner spinner;
    private TextView mediaUri;
    private SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReproducir = findViewById(R.id.btnReproducir);
        btnPausar = findViewById(R.id.btnPausar);
        spinner = findViewById(R.id.spinner);
        mediaUri = findViewById(R.id.mediaUri);
        surfaceView = findViewById(R.id.surfaceView);

        final Uri mediaSrc = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = managedQuery(mediaSrc,null,null,null,MediaStore.Audio.Media.TITLE);
        String[] nombre = {MediaStore.MediaColumns.TITLE};
        int[] ids = {android.R.id.text1};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,cursor,nombre,ids);
        spinner.setAdapter(simpleCursorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
