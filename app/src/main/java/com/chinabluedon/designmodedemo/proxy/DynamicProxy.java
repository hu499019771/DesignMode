package com.chinabluedon.designmodedemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ht
 * @time 2017/8/16  10:03
 * @desc ${TODD}
 */
public class DynamicProxy implements InvocationHandler {

    private ILawsuit mLawsuit;

    public DynamicProxy (ILawsuit lawsuit) {
        mLawsuit = lawsuit;
    }

    @Override
    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(mLawsuit, args);
    }
}
