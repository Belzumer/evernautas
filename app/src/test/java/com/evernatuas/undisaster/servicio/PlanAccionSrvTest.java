package com.evernatuas.undisaster.servicio;

import android.content.Context;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.PlanAccionDao;
import com.evernatuas.undisaster.dto.PlanAccion;
import com.evernatuas.undisaster.service.IPlanAccionSrv;
import com.evernatuas.undisaster.service.impl.PlanAccionSrv;

import org.junit.Before;
import org.junit.Test;

public class PlanAccionSrvTest {

    private PlanAccion planAccion;
    private IPlanAccionSrv planAccionSrv;

    @Before
    public void init(Context context) {
        planAccionSrv = new PlanAccionSrv(context);
        planAccion = new PlanAccion();
        planAccion.setId(1L);
        planAccion.setTitulo("Ejemplo");
        planAccion.setPosicion(1);
        planAccion.setDescripcion("Example");

    }

    @Test
    public void add() {
        Log.d(PlanAccionDao.class.getName(), planAccionSrv.add(planAccion).toString());
    }

    @Test
    public void get() {
        Log.d(PlanAccionDao.class.getName(), planAccionSrv.get(1L).toString());
    }

    @Test
    public void getAll() {
        Log.d(PlanAccionDao.class.getName(), planAccionSrv.getAll().toString());
    }

    @Test
    public void update() {
        planAccionSrv.update(planAccion);
    }

    @Test
    public void remove() {
        planAccionSrv.remove(planAccion);
    }
}