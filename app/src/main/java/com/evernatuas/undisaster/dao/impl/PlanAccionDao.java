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

/**
 * The type Plan accion dao.
 */
public class PlanAccionDao implements IPlanAccionDao {


    /**
     * The Dbhandler.
     */
//region OPERACIONES
    SQLiteOpenHelper dbhandler;
    /**
     * The Database.
     */
    SQLiteDatabase database;

    /**
     * Instantiates a new Plan accion dao.
     *
     * @param context the context
     */
    public PlanAccionDao(Context context) {
        dbhandler = new TablaPlanAccion(context);
    }

    /**
     * Open.
     */
    public void open() {
        Log.i(PlanAccion.class.getName(), "Database Opened");
        database = dbhandler.getWritableDatabase();
    }

    /**
     * Close.
     */
    public void close() {
        Log.i(PlanAccion.class.getName(), "Database Closed");
        dbhandler.close();

    }
    /**
     * add element
     *
     * @param elemento the plan accion
     * @return
     */
    @Override
    public PlanAccion add(Context context, PlanAccion elemento) {
        ContentValues values = new ContentValues();
        values.put(TablaPlanAccion.COLUMN_DESCRIPTION, elemento.getDescripcion());
        values.put(TablaPlanAccion.COLUMN_POSITION, elemento.getPosicion());
        values.put(TablaPlanAccion.COLUMN_TITLE, elemento.getTitulo());
        open();
        Long insertid = database.insert(TablaPlanAccion.TABLE, null, values);
        close();
        elemento.setId(insertid);
        return elemento;

    }

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    @Override
    public PlanAccion get(Context context, Long id) {

        open();
        Cursor cursor = database.query(TablaPlanAccion.TABLE, TablaPlanAccion.allColumns, TablaPlanAccion.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        PlanAccion plan = null;

        if (cursor != null) {
            cursor.moveToFirst();
            plan = new PlanAccion(Long.parseLong(cursor.getString(0)),
                    cursor.getLong(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4));
        }
        close();
        // return Element
        return plan;
    }

    /**
     * @return
     */
    @Override
    public List<PlanAccion> getAll(Context context) {
        open();
        Cursor cursor = database.query(TablaPlanAccion.TABLE, TablaPlanAccion.allColumns,
                null, null, null, null, null);
        List<PlanAccion> elementos = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                PlanAccion elemento = new PlanAccion();
                elemento.setId(cursor.getLong(cursor.getColumnIndex(TablaPlanAccion.COLUMN_ID)));
                elemento.setId(cursor.getLong(cursor.getColumnIndex(TablaPlanAccion.COLUMN_ID)));
                elemento.setDescripcion(cursor.getString(cursor.getColumnIndex(TablaPlanAccion.COLUMN_DESCRIPTION)));
                elemento.setPosicion(cursor.getInt(cursor.getColumnIndex(TablaPlanAccion.COLUMN_POSITION)));
                elemento.setTitulo(cursor.getString(cursor.getColumnIndex(TablaPlanAccion.COLUMN_TITLE)));
                elementos.add(elemento);
            }
        }
        close();
        // return All Elements
        return elementos;
    }

    /**
     * Updating Element
     *
     * @param plan
     * @return
     */
    @Override
    public int update(Context context, PlanAccion plan) {
        ContentValues values = new ContentValues();
        values.put(TablaPlanAccion.COLUMN_TITLE, plan.getTitulo());
        values.put(TablaPlanAccion.COLUMN_POSITION, plan.getPosicion());
        values.put(TablaPlanAccion.COLUMN_DESCRIPTION, plan.getPosicion());
        open();
        // updating row
        int numRow = database.update(TablaPlanAccion.TABLE, values,
                TablaPlanAccion.COLUMN_ID + "=?", new String[]{String.valueOf(plan.getId())});
        close();
        return numRow;
    }

    /**
     * Deleting Element
     *
     * @param plan
     */
    @Override
    public void remove(Context context, PlanAccion plan) {
        open();
        database.delete(TablaPlanAccion.TABLE,
                TablaPlanAccion.COLUMN_ID + "=" + plan.getId(), null);
        close();
    }
    //endregion

}
