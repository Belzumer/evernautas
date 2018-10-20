package com.evernatuas.undisaster.service;

import android.content.Context;

import com.evernatuas.undisaster.dto.PlanAccion;

import java.util.List;

public interface IPlanAccionSrv {

    /**
     * add element
     *
     * @param planAccion the plan accion
     * @return
     */
    PlanAccion add(Context context, PlanAccion planAccion);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    PlanAccion get(Context context, Long id);

    /**
     * return all elements
     *
     * @return
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
