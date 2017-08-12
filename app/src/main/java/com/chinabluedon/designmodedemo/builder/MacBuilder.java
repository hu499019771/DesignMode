package com.chinabluedon.designmodedemo.builder;

/**
 * @author ht
 * @time 2017/8/12  11:09
 * @desc 具体的macbuilder类
 */
public class MacBuilder extends Builder {

    private Computer mComputer = new MacComputer();

    @Override
    public Builder board (String board) {
        mComputer.setBoard(board);
        return this;
    }

    @Override
    public Builder display (String display) {
        mComputer.setDisplay(display);
        return this;
    }

    @Override
    public Builder os (String os) {
        mComputer.setOs(os);
        return this;
    }

    @Override
    public Computer create () {
        return mComputer;
    }
}
