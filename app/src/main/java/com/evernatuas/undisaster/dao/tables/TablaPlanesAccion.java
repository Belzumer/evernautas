package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TablaPlanesAccion extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "planesAccion";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "titulo";
    public static final String COLUMN_ID_DESASTRE = "id_desastre";

    public static final String[] allColumns = {
            TablaPlanesAccion.COLUMN_ID,
            TablaPlanesAccion.COLUMN_ID_DESASTRE,
            TablaPlanesAccion.COLUMN_TITLE
    };

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ID_DESASTRE + " NUMERIC, " +
                    COLUMN_TITLE + " TEXT " +
                    ")";
    //endregion

    //region OPERACIONES
    SQLiteDatabase database;

    public TablaPlanesAccion(Context context) {
        super(context, Tabla.DATABASE_NAME, null, Tabla.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablaPlanesAccion.TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Tabla.DROP_TABLE_IF_EXISTS + TablaPlanesAccion.TABLE);
        db.execSQL(TablaPlanesAccion.TABLE_CREATE);
    }
    //endregion
}
