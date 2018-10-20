package com.evernatuas.undisaster.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.evernatuas.undisaster.dao.IPlanAccionDao;
import com.evernatuas.undisaster.dao.tables.TablaPlanAccion;
import com.evernatuas.undisaster.dto.PlanAccion;

import java.util.ArrayList;
import java.util.List;

public class PlanAccionDao extends TablaPlanAccion implements IPlanAccionDao {


    //region OPERACIONES
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    public PlanAccionDao(Context context) {
        dbhandler = new TablaPlanAccion(context);
    }

    public void open() {
        Log.i(LOGTAG, "Database Opened");
        database = dbhandler.getWritableDatabase();


    }

    public void close() {
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }

    public PlanAccion add(PlanAccion planAccion) {
        ContentValues values = new ContentValues();
        values.put(TablaPlanAccion.COLUMN_DESCRIPTION, planAccion.getDescripcion());
        values.put(TablaPlanAccion.COLUMN_POSITION, planAccion.getPosicion());
        values.put(TablaPlanAccion.COLUMN_TITLE, planAccion.getTitulo());

        Long insertid = database.insert(TablaPlanAccion.TABLE, null, values);
        planAccion.setId(insertid);
        return planAccion;

    }

    // Getting single Employee
    public PlanAccion get(Long id) {

        Cursor cursor = database.query(TablaPlanAccion.TABLE, allColumns, TablaPlanAccion.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        PlanAccion plan = new PlanAccion(Long.parseLong(cursor.getString(0)),
                cursor.getInt(1),
                cursor.getString(2),
                cursor.getString(3));
        // return Element
        return plan;
    }

    /**
     * @return
     */
    public List<PlanAccion> getAll() {
        Cursor cursor = database.query(TablaPlanAccion.TABLE, allColumns,
                null, null, null, null, null);

        List<PlanAccion> elementos = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                PlanAccion elemento = new PlanAccion();
                elemento.setId(cursor.getLong(cursor.getColumnIndex(TablaPlanAccion.COLUMN_ID)));
                elemento.setDescripcion(cursor.getString(cursor.getColumnIndex(TablaPlanAccion.COLUMN_DESCRIPTION)));
                elemento.setPosicion(cursor.getInt(cursor.getColumnIndex(TablaPlanAccion.COLUMN_POSITION)));
                elemento.setTitulo(cursor.getString(cursor.getColumnIndex(TablaPlanAccion.COLUMN_TITLE)));
                elementos.add(elemento);
            }
        }
        // return All Elements
        return elementos;
    }

    /**
     * Updating Element
     *
     * @param plan
     * @return
     */
    public int update(PlanAccion plan) {

        ContentValues values = new ContentValues();
        values.put(TablaPlanAccion.COLUMN_TITLE, plan.getTitulo());
        values.put(TablaPlanAccion.COLUMN_POSITION, plan.getPosicion());
        values.put(TablaPlanAccion.COLUMN_DESCRIPTION, plan.getPosicion());

        // updating row
        return database.update(TablaPlanAccion.TABLE, values,
                TablaPlanAccion.COLUMN_ID + "=?", new String[]{String.valueOf(plan.getId())});
    }

    /**
     * Deleting Element
     *
     * @param plan
     */
    public void remove(PlanAccion plan) {
        database.delete(TablaPlanAccion.TABLE,
                TablaPlanAccion.COLUMN_ID + "=" + plan.getId(), null);
    }
    //endregion

}
