package com.evernatuas.undisaster.dao;

import android.content.Context;

import com.evernatuas.undisaster.dto.PlanListAccion;

import java.util.List;

/**
 * The interface Plan accion dao.
 */
public interface IPlanListAccionDao {
    /**
     * Add elemento accion.
     *
     * @param elemento the elemento accion
     * @return the elemento accion
     */
    PlanListAccion add(Context context, PlanListAccion elemento);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return elemento accion
     */
    PlanListAccion get(Context context, Long id);


    /**
     * Gets all.
     *
     * @return the all
     */
    List<PlanListAccion> getAll(Context context);

    /**
     * obtiene el plan con los pasos del plan
     *
     * @param context
     * @param id
     * @return
     */
    PlanListAccion getPlan(Context context, Long id);

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    int update(Context context, PlanListAccion elemento);

    /**
     * Deleting Element
     *
     * @param elemento
     */
    void remove(Context context, PlanListAccion elemento);
}
