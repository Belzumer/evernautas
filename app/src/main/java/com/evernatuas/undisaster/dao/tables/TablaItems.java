package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evernatuas.undisaster.dto.PlanAccion;

public class TablaItems extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "tb_items";
    public static final String PREF_COLUM = "it_";
    public static final String COLUMN_ID = PREF_COLUM + "id";
    public static final String COLUMN_NAME = PREF_COLUM + "nombre";
    public static final String COLUMN_DESCRIPTION = PREF_COLUM + "descripcion";
    public static final String COLUMN_PESO = PREF_COLUM + "peso";
    public static final String COLUMN_CATEGORIA = PREF_COLUM + "categoria";

    public static final String[] allColumns = {
            COLUMN_ID,
            COLUMN_NAME,
            COLUMN_DESCRIPTION,
            COLUMN_PESO,
            COLUMN_CATEGORIA
    };

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PESO + " NUMERIC, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_CATEGORIA + " NUMERIC " +
                    ")";
    //endregion

    //region OPERACIONES
    SQLiteDatabase database;
    Context contexto;

    public TablaItems(Context context) {
        super(context, Tabla.DATABASE_NAME, null, Tabla.DATABASE_VERSION);
        this.contexto = context;
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockValues(sqLiteDatabase, new PlanAccion(1L, 1L, 1,
                "Gran profesional con experiencia de 5 años en casos penales.",
                "carlos_perez.jpg"));
    }

    public long mockValues(SQLiteDatabase db, PlanAccion element) {
        return db.insert(TABLE,
                null,
                element.toContentValues());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        mockData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Tabla.DROP_TABLE_IF_EXISTS + TABLE);
        db.execSQL(TABLE_CREATE);
    }
    //endregion
}
