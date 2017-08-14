package com.chinabluedon.designmodedemo.simple_factory;

/**
 * @author ht
 * @time 2017/8/14  11:31
 * @desc ${TODD}
 */
public class AudioCarFactory implements AudioFactory {

    @Override
    public <T extends AudioCar> T createAudioCar (Class<T> cla) {
        AudioCar instance = null;
        try {
            instance = (AudioCar) Class.forName(cla.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)instance;
    }
}
