package com.evernatuas.undisaster.servicio;

import android.content.Context;
import android.util.Log;

import com.evernatuas.undisaster.dao.PlanAccionDaoTest;
import com.evernatuas.undisaster.dao.impl.PlanAccionDao;
import com.evernatuas.undisaster.dto.PlanAccion;
import com.evernatuas.undisaster.service.IPlanesSrv;
import com.evernatuas.undisaster.service.impl.PlanesSrv;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class PlanAccionSrvTest {

    private PlanAccion planAccion;
    private IPlanesSrv planAccionSrv;
    private Context context;

    private Context getTestContext() {
        try {
            Method getTestContext = PlanAccionDaoTest.class.getMethod("getTestContext");
            return (Context) getTestContext.invoke(this);
        } catch (final Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
    @Before
    public void init(Context context) {
        context = getTestContext();
        planAccionSrv = new PlanesSrv(context);
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