package com.chinabluedon.designmodedemo.builder;

/**
 * @author ht
 * @time 2017/8/12  11:08
 * @desc Director类,复杂构建computer
 */
public class Director {
    private Builder mBuilder;

    public Director (Builder builder) {
        mBuilder = builder;
    }

    public void construct(String board,String display){

        mBuilder.board(board);
        mBuilder.display(display);
//        mBuilder.os();
    }
}
