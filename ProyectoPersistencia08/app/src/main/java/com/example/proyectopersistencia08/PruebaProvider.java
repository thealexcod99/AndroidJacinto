package com.example.proyectopersistencia08;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import java.util.HashMap;

import com.example.proyectopersistencia08.PruebaProviderMetaData.PruebaTablaMetaData;

public class PruebaProvider extends ContentProvider {

    private static final String TAG = "PruebaProvider";

    private static HashMap<String, String> sPruebaProjectionMap;
    static {
        sPruebaProjectionMap = new HashMap();
        sPruebaProjectionMap.put(PruebaTablaMetaData._ID,
                                 PruebaTablaMetaData._ID);

        sPruebaProjectionMap.put(PruebaTablaMetaData.NAME,
                                 PruebaTablaMetaData.NAME);

        sPruebaProjectionMap.put(PruebaTablaMetaData.ANIO,
                                 PruebaTablaMetaData.ANIO);
    }

    private static final UriMatcher sUriMatcher;
    private static final  int INCOMING_PRUEBA_COLLECTION_URI_INDICATOR = 1;
    private static final  int INCOMING_SINGLE_PRUEBA_URI_INDICATOR = 2;
    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(PruebaProviderMetaData.AUTHORITY, "datos",
                            INCOMING_PRUEBA_COLLECTION_URI_INDICATOR);
        sUriMatcher.addURI(PruebaProviderMetaData.AUTHORITY, "datos/#",
                            INCOMING_SINGLE_PRUEBA_URI_INDICATOR);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context,
                    PruebaProviderMetaData.DATABASE_NAME,
                    null,
                    PruebaProviderMetaData.DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "inner onCreate called");
            db.execSQL("CREATE TABLE " + PruebaTablaMetaData.TABLE_NAME
                + " ("
                + PruebaTablaMetaData._ID +  " INTEGER PRIMARY KEY, "
                + PruebaTablaMetaData.NAME + " TEXT, "
                + PruebaTablaMetaData.ANIO + " TEXT"
                + ");" );

            //Generamos los datos de muestra
            for(int i=1; i<=15; i++)
            {
                String name = "Versión" + i;
                String anio = "" + i;

                db.execSQL("INSERT INTO " + PruebaTablaMetaData.TABLE_NAME + " ("
                        + PruebaTablaMetaData.NAME + ", "
                        + PruebaTablaMetaData.ANIO
                        + ") VALUES ('" + name + "', '" + anio + "')");
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "inner onUpgrade called");
            Log.w(TAG, "Upgrading database from version "
                + oldVersion + " to "
                + newVersion + ", wich will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS "
                + PruebaTablaMetaData.TABLE_NAME);
            onCreate(db);
        }
    }

    private DatabaseHelper mOpenHelper;

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {

        int cont;

        if(sUriMatcher.match(uri) == INCOMING_SINGLE_PRUEBA_URI_INDICATOR){
            where = "_id=" + uri.getLastPathSegment();
            SQLiteDatabase db = mOpenHelper.getWritableDatabase();

            cont = db.delete(PruebaTablaMetaData.TABLE_NAME, where, whereArgs);

            return cont;
        }

        return 0;
    }

    @Override
    public String getType(Uri uri) {
        int match = sUriMatcher.match(uri);

        switch (match)
        {
            case INCOMING_PRUEBA_COLLECTION_URI_INDICATOR:
                return PruebaTablaMetaData.CONTENT_TYPE;
            case INCOMING_SINGLE_PRUEBA_URI_INDICATOR:
                return PruebaTablaMetaData.CONTENT_ITEM_TYPE;
            default:
                return null;
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        long regId = 1;

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        regId = db.insert(PruebaTablaMetaData.TABLE_NAME, null, initialValues);

        Uri newUri = ContentUris.withAppendedId(PruebaTablaMetaData.CONTENT_URI, regId);

        return newUri;
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "main onCreate called");
        mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Log.d(TAG, "method query called");
        if(sUriMatcher.match(uri) == INCOMING_SINGLE_PRUEBA_URI_INDICATOR){
            selection = "_id=" + uri.getLastPathSegment();
        }

        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        Cursor c = db.query(PruebaTablaMetaData.TABLE_NAME, projection, selection,
                selectionArgs, null, null, PruebaTablaMetaData.DEFAULT_SORT_ORDER);

        return c;

    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        return 0;
    }
}
