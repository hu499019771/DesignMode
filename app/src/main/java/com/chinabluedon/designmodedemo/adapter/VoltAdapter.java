package com.chinabluedon.designmodedemo.adapter;

/**
 * @author ht
 * @time 2017/8/16  17:08
 * @desc ${TODD}
 */
public class VoltAdapter implements FiveVolt {

    private Volt220 mVolt220;

    public VoltAdapter (Volt220 volt220) {
        mVolt220 = volt220;
    }

    public int getVolt220 () {
        return mVolt220.getVolt220();
    }

    @Override
    public int getVolt5 () {
        return 5;
    }
}
