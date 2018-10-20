package com.evernatuas.undisaster.dao;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.PlanAccionDao;
import com.evernatuas.undisaster.dto.PlanAccion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PlanAccionDaoTest extends Application {

    private PlanAccion planAccion;
    private IPlanAccionDao dao;
    private Context context;

    @Before
    public void setUp() {
        Context context = this.getApplicationContext();
        dao = new PlanAccionDao(context);
        planAccion = new PlanAccion();
        planAccion.setId(1L);
        planAccion.setTitulo("Ejemplo");
        planAccion.setPosicion(1);
        planAccion.setDescripcion("Example");

    }

    @Test
    public void add() {
        Log.d(PlanAccionDao.class.getName(), dao.add(context, planAccion).toString());
    }

    @Test
    public void get() {
        Log.d(PlanAccionDao.class.getName(), dao.get(context, 1L).toString());
    }

    @Test
    public void getAll() {
        Log.d(PlanAccionDao.class.getName(), dao.getAll(context).toString());
    }

    @Test
    public void update() {
        dao.update(context, planAccion);
    }

    @Test
    public void remove() {
        dao.remove(context, planAccion);
    }
}