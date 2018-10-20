package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evernatuas.undisaster.dto.CheckList;
import com.evernatuas.undisaster.dto.PlanAccion;

public class TablaChecks extends SQLiteOpenHelper {
    // region DDL
    public static final String TABLE = "tb_checks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_DESASTRE = "id_desastre";
    public static final String COLUMN_TITLE = "titulo";

    public static final String[] allColumns = {
            COLUMN_ID,
            COLUMN_TITLE,
            COLUMN_ID_DESASTRE
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
    Context contexto;

    public TablaChecks(Context context) {
        super(context, Tabla.DATABASE_NAME, null, Tabla.DATABASE_VERSION);
        this.contexto = context;
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockValues(sqLiteDatabase, new CheckList(1L, 1L, "Checklist Tornado"));
        mockValues(sqLiteDatabase, new CheckList(2L, 2L, "Checklist Huracan"));
        mockValues(sqLiteDatabase, new CheckList(3L, 3L, "Checklist Incendio"));
        mockValues(sqLiteDatabase, new CheckList(4L, 4L, "Checklist Terremoto"));
        mockValues(sqLiteDatabase, new CheckList(5L, 5L, "Checklist Asteroide"));
    }

    public long mockValues(SQLiteDatabase db, CheckList element) {
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
