package com.evernatuas.undisaster.service.impl;

import android.content.Context;

import com.evernatuas.undisaster.dao.IPlanAccionDao;
import com.evernatuas.undisaster.dao.impl.PlanAccionDao;
import com.evernatuas.undisaster.dto.PlanAccion;
import com.evernatuas.undisaster.service.IPlanAccionSrv;

import java.util.List;

public class PlanAccionSrv implements IPlanAccionSrv {

    IPlanAccionDao dao;

    public PlanAccionSrv(Context context) {
        dao = new PlanAccionDao(context);
    }

    /**
     * add element
     *
     * @param planAccion the plan accion
     * @return
     */
    @Override
    public PlanAccion add(PlanAccion planAccion) {
        return dao.add(planAccion);
    }

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    @Override
    public PlanAccion get(Long id) {
        return dao.get(id);
    }

    /**
     * return all elements
     *
     * @return
     */
    @Override
    public List<PlanAccion> getAll() {
        return dao.getAll();
    }

    /**
     * Updating Element
     *
     * @param plan
     * @return
     */
    @Override
    public int update(PlanAccion plan) {
        return dao.update(plan);
    }

    /**
     * Deleting Element
     *
     * @param plan
     */
    @Override
    public void remove(PlanAccion plan) {
        dao.remove(plan);
    }
}
