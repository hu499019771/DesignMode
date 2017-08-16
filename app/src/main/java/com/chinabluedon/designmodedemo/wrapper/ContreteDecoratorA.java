package com.chinabluedon.designmodedemo.wrapper;

/**
 * @author ht
 * @time 2017/8/16  14:31
 * @desc ${TODD}
 */
public class ContreteDecoratorA extends Decorator {

    public ContreteDecoratorA (Component component) {
        super(component);
    }

    @Override
    public void operate () {
        operareA();
        super.operate();
        operareB();
    }

    private void operareA(){}

    private void operareB(){}
}
