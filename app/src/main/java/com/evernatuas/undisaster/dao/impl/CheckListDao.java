package com.evernatuas.undisaster.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.evernatuas.undisaster.dao.ICheckListDao;
import com.evernatuas.undisaster.dao.tables.TablaPlanesAccion;
import com.evernatuas.undisaster.dto.CheckList;
import com.evernatuas.undisaster.dto.PlanAccion;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Plan accion dao.
 */
public class CheckListDao implements ICheckListDao {


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
    public CheckListDao(Context context) {
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
    public CheckList add(Context context, CheckList elemento) {
        ContentValues values = new ContentValues();
        values.put(TablaPlanesAccion.COLUMN_ID_DESASTRE, elemento.getIdDesastre());
        values.put(TablaPlanesAccion.COLUMN_TITLE, elemento.getTitulo());

        Long insertid = database.insert(TablaPlanesAccion.TABLE, null, values);
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
    public CheckList get(Context context, Long id) {

        Cursor cursor = database.query(TablaPlanesAccion.TABLE, TablaPlanesAccion.allColumns, TablaPlanesAccion.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        CheckList elemento = null;

        if (cursor != null) {
            cursor.moveToFirst();
            elemento = new CheckList(Long.parseLong(cursor.getString(0)),
                    cursor.getLong(1),
                    cursor.getString(2));
        }
        // return Element
        return elemento;
    }

    /**
     * @return
     */
    @Override
    public List<CheckList> getAll(Context context) {
        Cursor cursor = database.query(TablaPlanesAccion.TABLE, TablaPlanesAccion.allColumns,
                null, null, null, null, null);

        List<CheckList> elementos = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                CheckList elemento = new CheckList();
                elemento.setId(cursor.getLong(cursor.getColumnIndex(TablaPlanesAccion.COLUMN_ID)));
                elemento.setIdDesastre(cursor.getLong(cursor.getColumnIndex(TablaPlanesAccion.COLUMN_ID_DESASTRE)));
                elemento.setTitulo(cursor.getString(cursor.getColumnIndex(TablaPlanesAccion.COLUMN_TITLE)));
                elementos.add(elemento);
            }
        }
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
    public int update(Context context, CheckList elemento) {
        ContentValues values = new ContentValues();
        values.put(TablaPlanesAccion.COLUMN_TITLE, elemento.getTitulo());
        values.put(TablaPlanesAccion.COLUMN_ID_DESASTRE, elemento.getIdDesastre());

        // updating row
        return database.update(TablaPlanesAccion.TABLE, values,
                TablaPlanesAccion.COLUMN_ID + "=?", new String[]{String.valueOf(elemento.getId())});
    }

    /**
     * Deleting Element
     *
     * @param elemento
     */
    @Override
    public void remove(Context context, CheckList elemento) {
        database.delete(TablaPlanesAccion.TABLE,
                TablaPlanesAccion.COLUMN_ID + "=" + elemento.getId(), null);
    }
    //endregion

}
