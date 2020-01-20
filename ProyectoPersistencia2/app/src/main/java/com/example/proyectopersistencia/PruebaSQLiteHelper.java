package com.example.proyectopersistencia;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PruebaSQLiteHelper extends SQLiteOpenHelper {

    String createTable = "CREATE TABLE prueba (codigo INTEGER PRIMARY KEY AUTOINCREMENT, texto1 TEXT, texto2 TEXT)";

    public PruebaSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS prueba");
        db.execSQL(createTable);
    }
}
