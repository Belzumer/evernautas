package com.evernatuas.undisaster.service;

import android.content.Context;

import com.evernatuas.undisaster.dto.Check;

import java.util.List;

public interface IChecksSrv {

    /**
     * add element
     *
     * @param elemento the elemento
     * @return
     */
    Check add(Context context, Check elemento);

    /**
     * Getting single Element
     *
     * @param id the id
     * @return
     */
    Check get(Context context, Long id);

    /**
     * return all elements
     *
     * @return
     */
    List<Check> getAll(Context context);

    /**
     * Updating Element
     *
     * @param elemento
     * @return
     */
    int update(Context context, Check elemento);

    /**
     * Deleting Element
     *
     * @param elemento
     */
    void remove(Context context, Check elemento);
}
