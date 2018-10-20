package com.evernatuas.undisaster.dao;

import android.content.Context;

import com.evernatuas.undisaster.dto.Check;

import java.util.List;

/**
 * The interface elemento accion dao.
 */
public interface ICheckDao {
    /**
     * Add elemento accion.
     *
     * @param elemento the elemento accion
     * @return the elemento accion
     */
    Check add(Context context, Check elemento);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return elemento accion
     */
    Check get(Context context, Long id);


    /**
     * Gets all.
     *
     * @return the all
     */
    List<Check> getAll(Context context);

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    int update(Context context, Check elemento);

    /**
     * Deleting Element
     *
     * @param elemento
     */
    void remove(Context context, Check elemento);
}
