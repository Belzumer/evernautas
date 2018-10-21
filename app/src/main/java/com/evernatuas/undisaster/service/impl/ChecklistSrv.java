package com.evernatuas.undisaster.service.impl;

import android.content.Context;

import com.evernatuas.undisaster.dao.ICheckDao;
import com.evernatuas.undisaster.dao.ICheckListDao;
import com.evernatuas.undisaster.dao.impl.CheckDao;
import com.evernatuas.undisaster.dao.impl.CheckListDao;
import com.evernatuas.undisaster.dto.Check;
import com.evernatuas.undisaster.dto.CheckList;
import com.evernatuas.undisaster.service.IChecklistSrv;
import com.evernatuas.undisaster.service.IChecksSrv;

import java.util.List;

public class ChecklistSrv implements IChecklistSrv {

    ICheckListDao dao;

    public ChecklistSrv(Context context) {
        dao = new CheckListDao(context);
    }


    @Override
    public CheckList add(Context context, CheckList elemento) {
        return dao.add(context, elemento);
    }

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    @Override
    public CheckList get(Context context, Long id) {
        return dao.get(context, id);
    }

    /**
     * return all elements
     *
     * @return
     */
    @Override
    public List<CheckList> getAll(Context context) {
        return dao.getAll(context);
    }

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    @Override
    public int update(Context context, CheckList elemento) {
        return dao.update(context, elemento);
    }

    /**
     * Deleting Element
     *
     * @param elemento
     */
    @Override
    public void remove(Context context, CheckList elemento) {
        dao.remove(context, elemento);
    }
}
