package com.chinabluedon.designmodedemo.wrapper;

/**
 * @author ht
 * @time 2017/8/16  14:28
 * @desc ${TODD}
 */
public abstract class Decorator extends Component {

    private Component mComponent;

    public Decorator (Component component) {
        mComponent = component;
    }

    @Override
    public void operate () {
        mComponent.operate();
    }
}
