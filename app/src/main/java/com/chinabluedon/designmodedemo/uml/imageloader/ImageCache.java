package com.chinabluedon.designmodedemo.uml.imageloader;

import android.graphics.Bitmap;

/**
 * @author ht
 * @time 2017/8/10  11:05
 * @desc 图片缓存接口
 */
public interface ImageCache {

    /**
     * 将图片存进缓存
     * @param url 图片地址
     * @param bitmap 图片的bitmap对象
     */
    void put (String url, Bitmap bitmap);

    /**
     * 将图片从缓存取出来
     * @param url  图片地址
     * @return 返回图片的bitmap对象
     */
    Bitmap get (String url);
}
