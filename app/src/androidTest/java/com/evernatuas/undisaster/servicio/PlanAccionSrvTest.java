package com.evernatuas.undisaster.servicio;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.PlanAccionDao;
import com.evernatuas.undisaster.dto.PlanAccion;
import com.evernatuas.undisaster.dto.PlanListAccion;
import com.evernatuas.undisaster.service.IPlanesSrv;
import com.evernatuas.undisaster.service.impl.PlanesSrv;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PlanAccionSrvTest {

    private PlanAccion planAccion;
    private PlanListAccion plan;
    private IPlanesSrv planAccionSrv;
    private Context context;

    @Before
    public void init(Context context) {
        context = InstrumentationRegistry.getTargetContext();
        planAccionSrv = new PlanesSrv(context);
        plan = new PlanListAccion();
        plan.setIdDesastre(1L);
        plan.setId(1L);
        plan.setTitulo("Plan 1");
        planAccion = new PlanAccion();
        planAccion.setId(1L);
        planAccion.setTitulo("Ejemplo");
        planAccion.setPosicion(1);
        planAccion.setDescripcion("Example");

    }

    @Test
    public void add() {
        Log.d(PlanAccionDao.class.getName(), planAccionSrv.add(context, planAccion).toString());
    }

    @Test
    public void get() {
        Log.d(PlanAccionDao.class.getName(), planAccionSrv.get(context, 1L).toString());
    }

    @Test
    public void getAll() {
        Log.d(PlanAccionDao.class.getName(), planAccionSrv.getAll(context).toString());
    }

    @Test
    public void update() {
        planAccionSrv.update(context, planAccion);
    }

    @Test
    public void remove() {
        planAccionSrv.remove(context, planAccion);
    }
}