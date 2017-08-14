package com.chinabluedon.designmodedemo.simple_factory;

/**
 * @author ht
 * @time 2017/8/14  11:25
 * @desc ${TODD}
 */
public interface AudioFactory {

    /**
     * 生产奥迪车的抽象方法
     * @param cla 具体车型的字节码
     * @param <T> 根据字节码类型返回对应的车型
     * @return
     */
    <T extends AudioCar> T createAudioCar (Class<T> cla);
}
