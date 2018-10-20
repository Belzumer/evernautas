package com.evernatuas.undisaster.dao;

import android.content.Context;

import com.evernatuas.undisaster.dto.CheckList;

import java.util.List;

/**
 * The interface Plan accion dao.
 */
public interface ICheckListDao {
    /**
     * Add elemento accion.
     *
     * @param elemento the elemento accion
     * @return the elemento accion
     */
    CheckList add(Context context, CheckList elemento);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return elemento accion
     */
    CheckList get(Context context, Long id);


    /**
     * Gets all.
     *
     * @return the all
     */
    List<CheckList> getAll(Context context);

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    int update(Context context, CheckList elemento);

    /**
     * Deleting Element
     *
     * @param elemento
     */
    void remove(Context context, CheckList elemento);
}
