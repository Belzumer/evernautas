package com.evernatuas.undisaster.service;

import com.evernatuas.undisaster.dto.PlanAccion;

import java.util.List;

public interface IPlanAccionSrv {

    /**
     * add element
     *
     * @param planAccion the plan accion
     * @return
     */
    PlanAccion add(PlanAccion planAccion);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    PlanAccion get(Long id);

    /**
     * return all elements
     *
     * @return
     */
    List<PlanAccion> getAll();

    /**
     * Updating Element
     *
     * @param plan
     * @return
     */
    int update(PlanAccion plan);

    /**
     * Deleting Element
     *
     * @param plan
     */
    void remove(PlanAccion plan);
}
