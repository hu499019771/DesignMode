package com.chinabluedon.designmodedemo.builder;

/**
 * @author ht
 * @time 2017/8/12  11:00
 * @desc 计算机抽象类
 */
public abstract class Computer {
    protected String mBoard;

    protected String mDisplay;

    protected String mOs;

    public Computer () {
    }

    public void setBoard (String board) {
        mBoard = board;
    }

    public void setDisplay (String display) {
        mDisplay = display;
    }

    public void setOs (String os) {
         mOs=os;
    }

    @Override
    public String toString () {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
