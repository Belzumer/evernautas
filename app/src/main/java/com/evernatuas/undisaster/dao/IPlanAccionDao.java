package com.evernatuas.undisaster.dao;

import android.content.Context;

import com.evernatuas.undisaster.dto.PlanAccion;

import java.util.List;

/**
 * The interface Plan accion dao.
 */
public interface IPlanAccionDao {
    /**
     * Add plan accion.
     *
     * @param planAccion the plan accion
     * @return the plan accion
     */
    PlanAccion add(Context context, PlanAccion planAccion);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return plan accion
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
     * @param plan
     * @return
     */
    int update(Context context, PlanAccion plan);

    /**
     * Deleting Element
     *
     * @param plan
     */
    void remove(Context context, PlanAccion plan);
}
