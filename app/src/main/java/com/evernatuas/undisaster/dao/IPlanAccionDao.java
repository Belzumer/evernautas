package com.evernatuas.undisaster.dao;

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
    PlanAccion add(PlanAccion planAccion);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return plan accion
     */
    PlanAccion get(Long id);


    /**
     * Gets all.
     *
     * @return the all
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
