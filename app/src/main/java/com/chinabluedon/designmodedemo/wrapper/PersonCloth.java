package com.chinabluedon.designmodedemo.wrapper;

/**
 * @author ht
 * @time 2017/8/16  14:49
 * @desc 装饰者一是可以修改对象原有的方法,二是可以添加自己的方法
 */
public abstract class PersonCloth implements Person{

    private Person mPerson;

    public PersonCloth (Person person) {
        mPerson = person;
    }

    @Override
    public void dress () {
        mPerson.dress();
    }
}
