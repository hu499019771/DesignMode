package com.chinabluedon.designmodedemo.UML.utils;

import com.chinabluedon.designmodedemo.UML.MainHandler;

/**
 * @author ht
 * @time 2017/8/10  9:09
 * @desc ${TODD}
 */
public class TaskRunUtils {

    public static void runOnMainThread (Runnable runnable) {
        MainHandler.getInstance().post(runnable);
    }
}
