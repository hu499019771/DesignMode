package com.chinabluedon.designmodedemo.UML;

import android.os.Handler;
import android.os.Looper;

/**
 * @author ht
 * @time 2017/8/10  9:07
 * @desc ${TODD}
 */
public class MainHandler extends Handler {
    private static volatile MainHandler instance;

    public static MainHandler getInstance() {
        if (null == instance) {
            synchronized (MainHandler.class) {
                if (null == instance) {
                    instance = new MainHandler();
                }
            }
        }
        return instance;
    }
    private MainHandler() {
        super(Looper.getMainLooper());
    }
}
