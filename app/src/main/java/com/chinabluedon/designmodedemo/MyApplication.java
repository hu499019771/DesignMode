package com.chinabluedon.designmodedemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * @author ht
 * @time 2017/8/10  11:15
 * @desc ${TODD}
 */
public class MyApplication extends Application {

    @Override
    public void onCreate () {
        super.onCreate();
        Utils.init(this);
    }
}
