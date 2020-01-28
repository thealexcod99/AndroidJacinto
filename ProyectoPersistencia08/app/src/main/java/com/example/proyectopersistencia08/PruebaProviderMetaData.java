package com.example.proyectopersistencia08;

import android.net.Uri;
import android.provider.BaseColumns;

public class PruebaProviderMetaData {

    public static final String AUTHORITY = "com.alejandro.provider.Prueba";

    public static final String DATABASE_NAME = "prueba.db";
    public static final int DATABASE_VERSION = 1;
    public static final String PRUEBA_TABLE_NAME = "prueba";

    private PruebaProviderMetaData() {}

    public static final class PruebaTablaMetaData implements BaseColumns {

        private PruebaTablaMetaData() {}

        public static final String TABLE_NAME = "prueba";

        public static final Uri CONTENT_URI
                = Uri.parse("content://" + AUTHORITY + "/datos");

        public static final String CONTENT_TYPE
                = "vnd.android.cursor.dir/vnd.prueba.data";

        public static final String CONTENT_ITEM_TYPE
                = "vnd.android.cursor.item/vnd.prueba.data";

        public static final String DEFAULT_SORT_ORDER = "_ID ASC";

        public static final String SORT_BY_NAME_DESC = "name DESC";
        public static final String SORT_BY_NAME_ASC = "name ASC";

        public static final String NAME = "name";

        public static final String ANIO = "anio";

        public static final String ID = "_id";
    }
}
