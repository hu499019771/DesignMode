package com.chinabluedon.designmodedemo.singleton;

/**
 * @author ht
 * @time 2017/8/10  16:36
 * @desc 静态内部类的单例模式, 推荐的模式
 */
public class Singleton {

    private Singleton () {
    }

    public Singleton getInstance () {
        return SingletonHolder.singleton;
    }

    static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }
}
