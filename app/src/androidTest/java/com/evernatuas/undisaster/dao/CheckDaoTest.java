package com.evernatuas.undisaster.dao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.CheckDao;
import com.evernatuas.undisaster.dto.Check;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CheckDaoTest {
    Check check;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.evernatuas.undisaster", appContext.getPackageName());
    }

    private void setObject() {
        check = new Check();
        check.setId(1L);
        check.setTitulo("Ejemplo");
        check.setSnMarcado(true);
        check.setId(1L);
    }

    @Test
    public void getAll() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckDao dao = new CheckDao(context);
        Log.d(CheckDao.class.getName(), dao.getAll(context).toString());
    }

    @Test
    public void add() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckDao dao = new CheckDao(context);
        Log.d(CheckDao.class.getName(), dao.add(context, check).toString());
    }

    @Test
    public void get() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckDao dao = new CheckDao(context);
        Log.d(CheckDao.class.getName(), dao.get(context, 1L).toString());
    }

    @Test
    public void update() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckDao dao = new CheckDao(context);
        dao.update(context, check);
    }

    @Test
    public void remove() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckDao dao = new CheckDao(context);
        dao.remove(context, check);
    }
}
