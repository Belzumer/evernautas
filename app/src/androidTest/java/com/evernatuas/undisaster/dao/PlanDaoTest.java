package com.evernatuas.undisaster.dao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.PlanAccionDao;
import com.evernatuas.undisaster.dto.PlanAccion;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PlanDaoTest {
    PlanAccion planAccion;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.evernatuas.undisaster", appContext.getPackageName());
    }

    private void setObject() {
        planAccion = new PlanAccion();
        planAccion.setId(1L);
        planAccion.setTitulo("Ejemplo");
        planAccion.setPosicion(1);
        planAccion.setDescripcion("Example");
    }

    @Test
    public void getAll() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanAccionDao dao = new PlanAccionDao(context);
        Log.d(PlanAccionDao.class.getName(), dao.getAll(context).toString());
    }

    @Test
    public void add() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanAccionDao dao = new PlanAccionDao(context);
        Log.d(PlanAccionDao.class.getName(), dao.add(context, planAccion).toString());
    }

    @Test
    public void get() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanAccionDao dao = new PlanAccionDao(context);
        Log.d(PlanAccionDao.class.getName(), dao.get(context, 1L).toString());
    }

    @Test
    public void update() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanAccionDao dao = new PlanAccionDao(context);
        dao.update(context, planAccion);
    }

    @Test
    public void remove() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanAccionDao dao = new PlanAccionDao(context);
        dao.remove(context, planAccion);
    }
}
