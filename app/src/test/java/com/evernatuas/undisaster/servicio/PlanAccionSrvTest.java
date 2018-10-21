package com.evernatuas.undisaster.servicio;

import android.content.Context;

import com.evernatuas.undisaster.dto.PlanAccion;
import com.evernatuas.undisaster.service.IPlanesSrv;
import com.evernatuas.undisaster.service.impl.PlanesSrv;

import org.junit.Before;
import org.junit.Test;

public class PlanAccionSrvTest {

    private PlanAccion planAccion;
    private IPlanesSrv planAccionSrv;

    @Before
    public void init(Context context) {
        planAccionSrv = new PlanesSrv(context);
        planAccion = new PlanAccion();
        planAccion.setId(1L);
        planAccion.setTitulo("Ejemplo");
        planAccion.setPosicion(1);
        planAccion.setDescripcion("Example");

    }

    @Test
    public void example() {
        // TODO
    }
}