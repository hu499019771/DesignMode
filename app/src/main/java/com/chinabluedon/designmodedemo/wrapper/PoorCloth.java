package com.chinabluedon.designmodedemo.wrapper;

/**
 * @author ht
 * @time 2017/8/16  14:57
 * @desc ${TODD}
 */
public class PoorCloth extends PersonCloth {

    public PoorCloth (Person person) {
        super(person);
    }

    @Override
    public void dress () {
        dressShort();
        super.dress();
    }

    private void dressShort(){}
}
