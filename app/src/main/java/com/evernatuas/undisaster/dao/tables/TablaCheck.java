package com.evernatuas.undisaster.dao.tables;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.evernatuas.undisaster.bo.Item;
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
        mockValues(sqLiteDatabase, new Check(1L, 1L, "Recoger la ropa tendida", true, new Item()));
        mockValues(sqLiteDatabase, new Check(2L, 1L, "Atar la abuela a la silla", true, new Item()));
        mockValues(sqLiteDatabase, new Check(3L, 1L, "Poner comida a los perros", true, new Item()));
        mockValues(sqLiteDatabase, new Check(4L, 1L, "Tomar una copa de Whisky", true, new Item()));
        mockValues(sqLiteDatabase, new Check(5L, 1L, "Arrancar el coche", true, new Item()));

        mockValues(sqLiteDatabase, new Check(1L, 2L, "Ponerse ropa seca", true, new Item()));
        mockValues(sqLiteDatabase, new Check(2L, 2L, "Salir al patio de la casa", true, new Item()));
        mockValues(sqLiteDatabase, new Check(3L, 2L, "Exponerse a la intemperie", true, new Item()));
        mockValues(sqLiteDatabase, new Check(4L, 2L, "Esperar unos minutos", true, new Item()));
        mockValues(sqLiteDatabase, new Check(5L, 2L, "Si la ropa esta mojada, llueve", true, new Item()));

        mockValues(sqLiteDatabase, new Check(1L, 3L, "Recoger la ropa tendida", true, new Item()));
        mockValues(sqLiteDatabase, new Check(2L, 3L, "Atar la abuela a la silla", true, new Item()));
        mockValues(sqLiteDatabase, new Check(3L, 3L, "Poner comida a los perros", true, new Item()));
        mockValues(sqLiteDatabase, new Check(4L, 3L, "Tomar una copa de Whisky", true, new Item()));
        mockValues(sqLiteDatabase, new Check(5L, 3L, "Arrancar el coche", true, new Item()));

        mockValues(sqLiteDatabase, new Check(1L, 4L, "Recoger la ropa tendida", true, new Item()));
        mockValues(sqLiteDatabase, new Check(2L, 4L, "Atar la abuela a la silla", true, new Item()));
        mockValues(sqLiteDatabase, new Check(3L, 4L, "Poner comida a los perros", true, new Item()));
        mockValues(sqLiteDatabase, new Check(4L, 4L, "Tomar una copa de Whisky", true, new Item()));
        mockValues(sqLiteDatabase, new Check(5L, 4L, "Arrancar el coche", true, new Item()));
        mockValues(sqLiteDatabase, new Check(6L, 4L, "Arrancar las malas hierbas", true, new Item()));
        mockValues(sqLiteDatabase, new Check(7L, 4L, "Arrancar el corazon del vecino", true, new Item()));

        mockValues(sqLiteDatabase, new Check(1L, 5L, "Recoger la ropa tendida", true, new Item()));
        mockValues(sqLiteDatabase, new Check(2L, 5L, "Atar la abuela a la silla", true, new Item()));
        mockValues(sqLiteDatabase, new Check(3L, 5L, "Poner comida a los perros", true, new Item()));
        mockValues(sqLiteDatabase, new Check(4L, 5L, "Tomar una copa de Whisky", true, new Item()));
        mockValues(sqLiteDatabase, new Check(5L, 5L, "Arrancar el coche", true, new Item()));
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
