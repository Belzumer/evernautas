package com.evernatuas.undisaster.dao;

import android.content.Context;

import com.evernatuas.undisaster.dto.PlanAccion;

import java.util.List;

/**
 * The interface Plan accion dao.
 */
public interface IPlanAccionDao {
    /**
     * Add elemento accion.
     *
     * @param elemento the elemento accion
     * @return the elemento accion
     */
    PlanAccion add(Context context, PlanAccion elemento);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return elemento accion
     */
    PlanAccion get(Context context, Long id);


    /**
     * Gets all.
     *
     * @return the all
     */
    List<PlanAccion> getAll(Context context);

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    int update(Context context, PlanAccion elemento);

    /**
     * Deleting Element
     *
     * @param elemento
     */
    void remove(Context context, PlanAccion elemento);
}
