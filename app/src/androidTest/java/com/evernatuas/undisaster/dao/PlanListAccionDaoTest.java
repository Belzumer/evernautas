package com.evernatuas.undisaster.dao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.PlanListAccionDao;
import com.evernatuas.undisaster.dto.PlanListAccion;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PlanListAccionDaoTest {
    PlanListAccion plan;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.evernatuas.undisaster", appContext.getPackageName());
    }

    private void setObject() {
        plan = new PlanListAccion();
        plan.setId(1L);
        plan.setTitulo("Ejemplo");
        plan.setIdDesastre(1L);
    }

    @Test
    public void getAll() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanListAccionDao dao = new PlanListAccionDao(context);
        Log.d(PlanListAccionDao.class.getName(), dao.getAll(context).toString());
    }

    @Test
    public void add() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanListAccionDao dao = new PlanListAccionDao(context);
        Log.d(PlanListAccionDao.class.getName(), dao.add(context, plan).toString());
    }

    @Test
    public void get() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanListAccionDao dao = new PlanListAccionDao(context);
        Log.d(PlanListAccionDao.class.getName(), dao.get(context, 1L).toString());
    }

    @Test
    public void update() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanListAccionDao dao = new PlanListAccionDao(context);
        dao.update(context, plan);
    }

    @Test
    public void remove() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanListAccionDao dao = new PlanListAccionDao(context);
        dao.remove(context, plan);
    }
}
