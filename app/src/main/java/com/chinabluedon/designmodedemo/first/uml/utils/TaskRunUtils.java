package com.chinabluedon.designmodedemo.first.uml.utils;

import com.chinabluedon.designmodedemo.first.uml.MainHandler;

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
