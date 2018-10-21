package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evernatuas.undisaster.dto.PlanAccion;

public class TablaPlanAccion extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "tb_planAccion";
    public static final String PREF_COLUM = "ps_";
    public static final String COLUMN_ID = PREF_COLUM + "id_plan";
    public static final String COLUMN_ID_PLAN = PREF_COLUM + "id_plan";
    public static final String COLUMN_POSITION = PREF_COLUM + "posicion";
    public static final String COLUMN_TITLE = PREF_COLUM + "titulo";
    public static final String COLUMN_DESCRIPTION = PREF_COLUM + "descripcion";

    public static final String[] allColumns = {
            COLUMN_ID,
            COLUMN_POSITION,
            COLUMN_TITLE,
            COLUMN_DESCRIPTION
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
    Context contexto;

    public TablaPlanAccion(Context context) {
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
