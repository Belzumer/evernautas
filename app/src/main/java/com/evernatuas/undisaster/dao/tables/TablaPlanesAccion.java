package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evernatuas.undisaster.dto.PlanListAccion;

public class TablaPlanesAccion extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "tb_planesAccion";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "titulo";
    public static final String COLUMN_ID_DESASTRE = "id_desastre";

    public static final String[] allColumns = {
            COLUMN_ID,
            COLUMN_ID_DESASTRE,
            COLUMN_TITLE
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

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        // TODO rellenar datos
        mockValues(sqLiteDatabase, new PlanListAccion(1L, 1L,
                "carlos_perez.jpg"));

    }

    public long mockValues(SQLiteDatabase db, PlanListAccion element) {
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
