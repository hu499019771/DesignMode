package com.chinabluedon.designmodedemo.simple_factory;

/**
 * @author ht
 * @time 2017/8/14  8:58
 * @desc 工厂抽象类
 */
public interface Factory {

    /**
     * 创建产品的方法
     *
     * @return
     */
    Product createProduct (Class cla);
}
