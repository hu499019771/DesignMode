package com.chinabluedon.designmodedemo.proxy;



/**
 * @author ht
 * @time 2017/8/16  9:17
 * @desc ${TODD}
 */
public class ProxySubject implements Subject {

    private Subject mSubject;

    public ProxySubject (Subject subject) {
        mSubject = subject;
    }

    @Override
    public void visit () {
        mSubject.visit();
    }
}
