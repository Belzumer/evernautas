package com.evernatuas.undisaster.service;

import android.content.Context;

import com.evernatuas.undisaster.dto.PlanAccion;

import java.util.List;

public interface IPlanesSrv {

    /**
     * add element
     *
     * @param elemento the elemento accion
     * @return
     */
    PlanAccion add(Context context, PlanAccion elemento);

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
