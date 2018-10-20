package com.evernatuas.undisaster.dao.impl;

import android.content.Context;
import android.util.Log;

import com.evernatuas.undisaster.dto.PlanAccion;

import org.junit.Before;
import org.junit.Test;

public class PlanAccionDaoTest {

    private PlanAccion planAccion;
    private PlanAccionDao dao;

    @Before
    public void init(Context context) {
        dao = new PlanAccionDao(context);
        planAccion = new PlanAccion();
        planAccion.setId(1L);
        planAccion.setTitulo("Ejemplo");
        planAccion.setPosicion(1);
        planAccion.setDescripcion("Example");

    }

    @Test
    public void add() {
        Log.d(PlanAccionDao.class.getName(), dao.add(planAccion).toString());
    }

    @Test
    public void get() {
        Log.d(PlanAccionDao.class.getName(), dao.get(1L).toString());
    }

    @Test
    public void getAll() {
        Log.d(PlanAccionDao.class.getName(), dao.getAll().toString());
    }

    @Test
    public void update() {
        dao.update(planAccion);
    }

    @Test
    public void remove() {
        dao.remove(planAccion);
    }
}