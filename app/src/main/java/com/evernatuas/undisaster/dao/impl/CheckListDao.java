package com.evernatuas.undisaster.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.evernatuas.undisaster.dao.ICheckListDao;
import com.evernatuas.undisaster.dao.tables.TablaChecklist;
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
        dbhandler = new TablaChecklist(context);
    }

    /**
     * Open.
     */
    public void open() {
        Log.i(CheckList.class.getName(), "Database Opened");
        database = dbhandler.getWritableDatabase();
    }

    /**
     * Close.
     */
    public void close() {
        Log.i(CheckList.class.getName(), "Database Closed");
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
    public CheckList get(Context context, Long id) {
        open();
        Cursor cursor = database.query(TablaChecklist.TABLE, TablaChecklist.allColumns, TablaChecklist.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        CheckList elemento = null;

        if (cursor != null) {
            cursor.moveToFirst();
            elemento = new CheckList(Long.parseLong(cursor.getString(0)),
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
    public List<CheckList> getAll(Context context) {
        open();
        Cursor cursor = database.query(TablaChecklist.TABLE, TablaChecklist.allColumns,
                null, null, null, null, null);

        List<CheckList> elementos = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                CheckList elemento = new CheckList();
                elemento.setId(cursor.getLong(cursor.getColumnIndex(TablaChecklist.COLUMN_ID)));
                elemento.setIdDesastre(cursor.getLong(cursor.getColumnIndex(TablaChecklist.COLUMN_ID_DESASTRE)));
                elemento.setTitulo(cursor.getString(cursor.getColumnIndex(TablaChecklist.COLUMN_TITLE)));
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
    public int update(Context context, CheckList elemento) {
        ContentValues values = new ContentValues();
        values.put(TablaChecklist.COLUMN_TITLE, elemento.getTitulo());
        values.put(TablaChecklist.COLUMN_ID_DESASTRE, elemento.getIdDesastre());

        // updating row
        open();
        int numRow = database.update(TablaChecklist.TABLE, values,
                TablaChecklist.COLUMN_ID + "=?", new String[]{String.valueOf(elemento.getId())});
        close();
        return numRow;
    }

    /**
     * Deleting Element
     *
     * @param elemento
     */
    @Override
    public void remove(Context context, CheckList elemento) {
        open();
        database.delete(TablaChecklist.TABLE,
                TablaChecklist.COLUMN_ID + "=" + elemento.getId(), null);
        close();
    }
    //endregion

}
