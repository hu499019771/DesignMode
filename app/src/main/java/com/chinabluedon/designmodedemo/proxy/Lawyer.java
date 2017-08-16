package com.chinabluedon.designmodedemo.proxy;

/**
 * @author ht
 * @time 2017/8/16  9:25
 * @desc ${TODD}
 */
public class Lawyer implements ILawsuit {

    private XiaoMing mXiaoMing;

    public Lawyer (XiaoMing xiaoMing) {
        mXiaoMing = xiaoMing;
    }

    @Override
    public void submit () {
        mXiaoMing.submit();
    }
}
