package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TablaPlanAccion extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "planAccion";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_PLAN = "id_plan";
    public static final String COLUMN_POSITION = "posicion";
    public static final String COLUMN_TITLE = "titulo";
    public static final String COLUMN_DESCRIPTION = "descripcion";

    public static final String[] allColumns = {
            TablaPlanAccion.COLUMN_ID,
            TablaPlanAccion.COLUMN_POSITION,
            TablaPlanAccion.COLUMN_TITLE,
            TablaPlanAccion.COLUMN_DESCRIPTION
    };

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ID_PLAN + " NUMERIC, " +
                    COLUMN_POSITION + " NUMERIC, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT " +
                    ")";
    //endregion

    //region OPERACIONES
    SQLiteDatabase database;

    public TablaPlanAccion(Context context) {
        super(context, Tabla.DATABASE_NAME, null, Tabla.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablaPlanAccion.TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Tabla.DROP_TABLE_IF_EXISTS + TablaPlanAccion.TABLE);
        db.execSQL(TablaPlanAccion.TABLE_CREATE);
    }
    //endregion
}
