package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evernatuas.undisaster.dto.PlanAccion;

public class TablaPlanAccion extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "tb_planAccion";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_PLAN = "id_plan";
    public static final String COLUMN_POSITION = "posicion";
    public static final String COLUMN_TITLE = "titulo";
    public static final String COLUMN_DESCRIPTION = "descripcion";

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
