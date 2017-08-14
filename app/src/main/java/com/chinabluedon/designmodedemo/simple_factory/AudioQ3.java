package com.chinabluedon.designmodedemo.simple_factory;

/**
 * @author ht
 * @time 2017/8/14  11:32
 * @desc ${TODD}
 */
public class AudioQ3 implements AudioCar {

    @Override
    public String drive () {
        return "Q3开车啦";

    }

    @Override
    public String selfNavigation () {
        return "Q3自动巡航了";
    }
}
