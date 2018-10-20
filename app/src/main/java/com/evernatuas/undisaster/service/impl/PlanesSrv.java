package com.evernatuas.undisaster.service.impl;

import android.content.Context;

import com.evernatuas.undisaster.dao.IPlanAccionDao;
import com.evernatuas.undisaster.dao.impl.PlanAccionDao;
import com.evernatuas.undisaster.dto.PlanAccion;
import com.evernatuas.undisaster.service.IPlanesSrv;

import java.util.List;

public class PlanesSrv implements IPlanesSrv {

    IPlanAccionDao dao;

    public PlanesSrv(Context context) {
        dao = new PlanAccionDao(context);
    }

    /**
     * add element
     *
     * @param planAccion the plan accion
     * @return
     */
    @Override
    public PlanAccion add(Context context, PlanAccion planAccion) {
        return dao.add(context, planAccion);
    }

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    @Override
    public PlanAccion get(Context context, Long id) {
        return dao.get(context, id);
    }

    /**
     * return all elements
     *
     * @return
     */
    @Override
    public List<PlanAccion> getAll(Context context) {
        return dao.getAll(context);
    }

    /**
     * Updating Element
     *
     * @param plan
     * @return
     */
    @Override
    public int update(Context context, PlanAccion plan) {
        return dao.update(context, plan);
    }

    /**
     * Deleting Element
     *
     * @param plan
     */
    @Override
    public void remove(Context context, PlanAccion plan) {
        dao.remove(context, plan);
    }
}
