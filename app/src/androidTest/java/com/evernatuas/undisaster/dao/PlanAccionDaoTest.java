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

@RunWith(AndroidJUnit4.class)
public class PlanAccionDaoTest {

    private PlanAccion planAccion;
    private IPlanAccionDao dao;
    //private Context context;

    /**
     * @Before public void setUp() {
     * context = InstrumentationRegistry.getTargetContext();
     * dao = new PlanAccionDao(context);
     * planAccion = new PlanAccion();
     * planAccion.setId(1L);
     * planAccion.setTitulo("Ejemplo");
     * planAccion.setPosicion(1);
     * planAccion.setDescripcion("Example");
     * <p>
     * }
     * /
     **/
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.evernatuas.undisaster", appContext.getPackageName());
    }

    @Test
    public void add() {
        Context context = InstrumentationRegistry.getTargetContext();
        dao = new PlanAccionDao(context);
        Log.d(PlanAccionDao.class.getName(), dao.add(context, planAccion).toString());
    }

    @Test
    public void get() {
        Context context = InstrumentationRegistry.getTargetContext();
        dao = new PlanAccionDao(context);
        Log.d(PlanAccionDao.class.getName(), dao.get(context, 1L).toString());
    }

    @Test
    public void getAll() {
        Context context = InstrumentationRegistry.getTargetContext();
        dao = new PlanAccionDao(context);
        Log.d(PlanAccionDao.class.getName(), dao.getAll(context).toString());
    }

    @Test
    public void update() {
        Context context = InstrumentationRegistry.getTargetContext();
        dao = new PlanAccionDao(context);
        dao.update(context, planAccion);
    }

    @Test
    public void remove() {
        Context context = InstrumentationRegistry.getTargetContext();
        dao = new PlanAccionDao(context);
        dao.remove(context, planAccion);
    }
}