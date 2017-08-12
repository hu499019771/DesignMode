package com.chinabluedon.designmodedemo.builder;

/**
 * @author ht
 * @time 2017/8/12  11:04
 * @desc 抽象builder类
 */
public abstract class Builder {

    /**
     * 设置主机
     *
     * @param board 主机
     */
    public abstract Builder board (String board);

    /**
     * 设置显示器
     *
     * @param display
     */
    public abstract Builder display (String display);

    /**
     * 设置系统
     */
    public abstract Builder os (String os);

    /**
     * 创建computer
     */
    public abstract Computer create ();

}
