package com.chinabluedon.designmodedemo.UML.imageloader;

import android.graphics.Bitmap;

/**
 * @author ht
 * @time 2017/8/10  10:00
 * @desc ${TODD}
 */
public class DoubleCache implements ImageCache{

    private DiskCache mDiskCache = new DiskCache();

    /**
     * 图片缓存类
     */
    private MemoryCache mMemoryCache = new MemoryCache();

    /**
     * 取出图片
     *
     * @param url
     * @return
     */
    @Override
    public Bitmap get (String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put (String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
