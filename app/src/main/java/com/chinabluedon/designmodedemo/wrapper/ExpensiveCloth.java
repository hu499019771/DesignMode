package com.chinabluedon.designmodedemo.wrapper;

/**
 * @author ht
 * @time 2017/8/16  14:55
 * @desc ${TODD}
 */
public class ExpensiveCloth extends PersonCloth {


    public ExpensiveCloth (Person person) {
        super(person);
    }

    @Override
    public void dress () {
        dressJean();
        super.dress();
    }

    private void dressJean(){};
}
