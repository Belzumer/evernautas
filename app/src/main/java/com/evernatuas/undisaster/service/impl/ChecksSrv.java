package com.evernatuas.undisaster.service.impl;

import android.content.Context;

import com.evernatuas.undisaster.dao.ICheckDao;
import com.evernatuas.undisaster.dao.impl.CheckDao;
import com.evernatuas.undisaster.dto.Check;
import com.evernatuas.undisaster.service.IChecksSrv;

import java.util.List;

public class ChecksSrv implements IChecksSrv {

    ICheckDao dao;

    public ChecksSrv(Context context) {
        dao = new CheckDao(context);
    }

    /**
     * add element
     *
     * @param elemento the elemento accion
     * @return
     */
    @Override
    public Check add(Context context, Check elemento) {
        return dao.add(context, elemento);
    }

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    @Override
    public Check get(Context context, Long id) {
        return dao.get(context, id);
    }

    /**
     * return all elements
     *
     * @return
     */
    @Override
    public List<Check> getAll(Context context) {
        return dao.getAll(context);
    }

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    @Override
    public int update(Context context, Check elemento) {
        return dao.update(context, elemento);
    }

    /**
     * Deleting Element
     *
     * @param elemento
     */
    @Override
    public void remove(Context context, Check elemento) {
        dao.remove(context, elemento);
    }
}
