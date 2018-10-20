package com.evernatuas.undisaster.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.evernatuas.undisaster.dao.ICheckDao;
import com.evernatuas.undisaster.dao.tables.TablaCheck;
import com.evernatuas.undisaster.dto.Check;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Plan accion dao.
 */
public class CheckDao implements ICheckDao {


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
    public CheckDao(Context context) {
        dbhandler = new TablaCheck(context);
    }

    /**
     * Open.
     */
    public void open() {
        Log.i(Check.class.getName(), "Database Opened");
        database = dbhandler.getWritableDatabase();
    }

    /**
     * Close.
     */
    public void close() {
        Log.i(Check.class.getName(), "Database Closed");
        dbhandler.close();

    }

    /**
     * add element
     *
     * @param elemento the plan accion
     * @return
     */
    @Override
    public Check add(Context context, Check elemento) {
        ContentValues values = new ContentValues();
        values.put(TablaCheck.COLUMN_ITEM, elemento.getItem().getId());
        values.put(TablaCheck.COLUMN_MARCA, elemento.getSnMarcado());
        values.put(TablaCheck.COLUMN_ID_CHECK, elemento.getIdCheckList());
        values.put(TablaCheck.COLUMN_TITLE, elemento.getTitulo());

        Long insertid = database.insert(TablaCheck.TABLE, null, values);
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
    public Check get(Context context, Long id) {

        Cursor cursor = database.query(TablaCheck.TABLE, TablaCheck.allColumns, TablaCheck.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        Check plan = null;

        if (cursor != null) {
            cursor.moveToFirst();
            plan = new Check(Long.parseLong(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getInt(2) == 1 ? Boolean.TRUE : Boolean.FALSE);
        }
        // return Element
        return plan;
    }

    /**
     * @return
     */
    @Override
    public List<Check> getAll(Context context) {
        Cursor cursor = database.query(TablaCheck.TABLE, TablaCheck.allColumns,
                null, null, null, null, null);

        List<Check> elementos = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Check elemento = new Check();
                elemento.setId(cursor.getLong(cursor.getColumnIndex(TablaCheck.COLUMN_ID)));
                elemento.setIdCheckList(cursor.getLong(cursor.getColumnIndex(TablaCheck.COLUMN_ID_CHECK)));
                //elemento.set(cursor.getString(cursor.getColumnIndex(TablaCheck.COLUMN_DESCRIPTION)));
                elemento.setSnMarcado(cursor.getInt(cursor.getColumnIndex(TablaCheck.COLUMN_MARCA)) == 1 ? Boolean.TRUE : Boolean.FALSE);
                elemento.setTitulo(cursor.getString(cursor.getColumnIndex(TablaCheck.COLUMN_TITLE)));
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
    @Override
    public int update(Context context, Check plan) {
        ContentValues values = new ContentValues();
        values.put(TablaCheck.COLUMN_TITLE, plan.getTitulo());
        values.put(TablaCheck.COLUMN_ID_CHECK, plan.getIdCheckList());
        values.put(TablaCheck.COLUMN_MARCA, plan.getSnMarcado() ? 1 : 0);
        values.put(TablaCheck.COLUMN_ITEM, plan.getItem().getId());

        // updating row
        return database.update(TablaCheck.TABLE, values,
                TablaCheck.COLUMN_ID + "=?", new String[]{String.valueOf(plan.getId())});
    }

    /**
     * Deleting Element
     *
     * @param plan
     */
    @Override
    public void remove(Context context, Check plan) {
        database.delete(TablaCheck.TABLE,
                TablaCheck.COLUMN_ID + "=" + plan.getId(), null);
    }
    //endregion

}
