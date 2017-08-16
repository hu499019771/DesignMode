package com.chinabluedon.designmodedemo.proxy;

/**
 * @author ht
 * @time 2017/8/16  9:17
 * @desc ${TODD}
 */
public class RealSubject implements Subject {

    @Override
    public void visit () {
        System.out.println("我是具体的对象");
    }
}
