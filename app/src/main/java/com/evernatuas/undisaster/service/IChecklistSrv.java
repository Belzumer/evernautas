package com.evernatuas.undisaster.service;

import android.content.Context;

import com.evernatuas.undisaster.dto.Check;
import com.evernatuas.undisaster.dto.CheckList;

import java.util.List;

public interface IChecklistSrv {

    /**
     * add element
     *
     * @param elemento the elemento
     * @return
     */
    CheckList add(Context context, CheckList elemento);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    CheckList get(Context context, Long id);

    /**
     * return all elements
     *
     * @return
     */
    List<CheckList> getAll(Context context);

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    int update(Context context, CheckList elemento);

    /**
     * Deleting Element
     *
     * @param elemento
     */
    void remove(Context context, CheckList elemento);
}
