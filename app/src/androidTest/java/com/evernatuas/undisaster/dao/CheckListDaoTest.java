package com.evernatuas.undisaster.dao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.CheckListDao;
import com.evernatuas.undisaster.dto.CheckList;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CheckListDaoTest {
    CheckList checkList;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.evernatuas.undisaster", appContext.getPackageName());
    }

    private void setObject() {
        checkList = new CheckList();
        checkList.setId(1L);
        checkList.setTitulo("Ejemplo");
        checkList.setIdDesastre(1L);
    }

    @Test
    public void getAll() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckListDao dao = new CheckListDao(context);
        Log.d(CheckListDao.class.getName(), dao.getAll(context).toString());
    }

    @Test
    public void add() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckListDao dao = new CheckListDao(context);
        Log.d(CheckListDao.class.getName(), dao.add(context, checkList).toString());
    }

    @Test
    public void get() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckListDao dao = new CheckListDao(context);
        Log.d(CheckListDao.class.getName(), dao.get(context, 1L).toString());
    }

    @Test
    public void update() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckListDao dao = new CheckListDao(context);
        dao.update(context, checkList);
    }

    @Test
    public void remove() {
        Context context = InstrumentationRegistry.getTargetContext();
        CheckListDao dao = new CheckListDao(context);
        dao.remove(context, checkList);
    }
}
