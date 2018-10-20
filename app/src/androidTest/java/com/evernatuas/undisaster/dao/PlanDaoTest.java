package com.evernatuas.undisaster.dao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.evernatuas.undisaster.dao.impl.PlanAccionDao;

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
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.evernatuas.undisaster", appContext.getPackageName());
    }

    @Test
    public void getAll() {
        Context context = InstrumentationRegistry.getTargetContext();
        PlanAccionDao dao = new PlanAccionDao(context);
        Log.d(PlanAccionDao.class.getName(), dao.getAll(context).toString());
    }
}
