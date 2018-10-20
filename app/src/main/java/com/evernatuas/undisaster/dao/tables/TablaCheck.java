package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evernatuas.undisaster.dto.Check;

public class TablaCheck extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "tb_check";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_CHECK = "id_check";
    public static final String COLUMN_MARCA = "sn_marca";
    public static final String COLUMN_TITLE = "titulo";
    public static final String COLUMN_ITEM = "id_item";

    public static final String[] allColumns = {
            COLUMN_ID,
            COLUMN_MARCA,
            COLUMN_ITEM,
            COLUMN_TITLE,
            COLUMN_ID_CHECK
    };

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ID_CHECK + " NUMERIC, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_MARCA + " NUMERIC, " +
                    COLUMN_ITEM + " NUMERIC " +
                    ")";
    //endregion

    //region OPERACIONES
    SQLiteDatabase database;
    Context contexto;

    public TablaCheck(Context context) {
        super(context, Tabla.DATABASE_NAME, null, Tabla.DATABASE_VERSION);
        this.contexto = context;
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockValues(sqLiteDatabase, new Check(1L, "carlos_perez.jpg", true));

    }

    public long mockValues(SQLiteDatabase db, Check element) {
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
