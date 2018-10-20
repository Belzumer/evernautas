package com.evernatuas.undisaster.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.evernatuas.undisaster.dao.IPlanListAccionDao;
import com.evernatuas.undisaster.dao.tables.TablaPlanesAccion;
import com.evernatuas.undisaster.dto.PlanAccion;
import com.evernatuas.undisaster.dto.PlanListAccion;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Plan accion dao.
 */
public class PlanListAccionDao implements IPlanListAccionDao {


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
    public PlanListAccionDao(Context context) {
        dbhandler = new TablaPlanesAccion(context);
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
     * @param elemento the elemento accion
     * @return
     */
    @Override
    public PlanListAccion add(Context context, PlanListAccion elemento) {
        ContentValues values = new ContentValues();
        values.put(TablaPlanesAccion.COLUMN_ID_DESASTRE, elemento.getIdDesastre());
        values.put(TablaPlanesAccion.COLUMN_TITLE, elemento.getTitulo());
        open();
        Long insertid = database.insert(TablaPlanesAccion.TABLE, null, values);
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
    public PlanListAccion get(Context context, Long id) {
        open();
        Cursor cursor = database.query(TablaPlanesAccion.TABLE, TablaPlanesAccion.allColumns, TablaPlanesAccion.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        PlanListAccion elemento = null;

        if (cursor != null) {
            cursor.moveToFirst();
            elemento = new PlanListAccion(Long.parseLong(cursor.getString(0)),
                    cursor.getLong(1),
                    cursor.getString(2));
        }
        close();
        // return Element
        return elemento;
    }

    /**
     * @return
     */
    @Override
    public List<PlanListAccion> getAll(Context context) {
        open();
        Cursor cursor = database.query(TablaPlanesAccion.TABLE, TablaPlanesAccion.allColumns,
                null, null, null, null, null);

        List<PlanListAccion> elementos = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                PlanListAccion elemento = new PlanListAccion();
                elemento.setId(cursor.getLong(cursor.getColumnIndex(TablaPlanesAccion.COLUMN_ID)));
                elemento.setIdDesastre(cursor.getLong(cursor.getColumnIndex(TablaPlanesAccion.COLUMN_ID_DESASTRE)));
                elemento.setTitulo(cursor.getString(cursor.getColumnIndex(TablaPlanesAccion.COLUMN_TITLE)));
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
     * @param elemento
     * @return
     */
    @Override
    public int update(Context context, PlanListAccion elemento) {
        ContentValues values = new ContentValues();
        values.put(TablaPlanesAccion.COLUMN_TITLE, elemento.getTitulo());
        values.put(TablaPlanesAccion.COLUMN_ID_DESASTRE, elemento.getIdDesastre());

        // updating
        open();
        int numRow = database.update(TablaPlanesAccion.TABLE, values,
                TablaPlanesAccion.COLUMN_ID + "=?", new String[]{String.valueOf(elemento.getId())});
        close();
        return numRow;
    }

    /**
     * Deleting Element
     *
     * @param elemento
     */
    @Override
    public void remove(Context context, PlanListAccion elemento) {
        open();
        database.delete(TablaPlanesAccion.TABLE,
                TablaPlanesAccion.COLUMN_ID + "=" + elemento.getId(), null);
        close();
    }
    //endregion

}
