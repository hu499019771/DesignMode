package com.chinabluedon.designmodedemo.UML.imageloader;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

/**
 * @author 胡腾
 * @time 2017/8/9  21:03
 * @desc 图片缓存管理类
 */
public class ImageCache {

    private LruCache<String, Bitmap> mLruCache;

    public ImageCache() {

        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheMemory = maxMemory / 4;
        mLruCache = new LruCache<String, Bitmap>(cacheMemory) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    /**
     * 通过图片地址提取其bitmap方法
     *
     * @param url
     * @return
     */
    public Bitmap getCache(String url) {
        if (!TextUtils.isEmpty(url)) {
            return mLruCache.get(url);
        }
        return null;
    }

    /**
     * 将url和bitmap存起来
     * @param url
     * @param bitmap
     */
    public void putCache(String url, Bitmap bitmap) {
        if (!TextUtils.isEmpty(url) && bitmap != null) {
            mLruCache.put(url, bitmap);
        }

    }
}
