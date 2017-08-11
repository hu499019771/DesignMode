package com.chinabluedon.designmodedemo.uml.imageloader;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

/**
 * @author 胡腾
 * @time 2017/8/9  21:03
 * @desc 图片缓存管理类
 */
public class MemoryCache implements ImageCache{

    private LruCache<String, Bitmap> mLruCache;

    public MemoryCache () {

        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheMemory = maxMemory / 4;
        mLruCache = new LruCache<String, Bitmap>(cacheMemory) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public void put (String url, Bitmap bitmap) {
        if (!TextUtils.isEmpty(url) && bitmap != null) {
            mLruCache.put(url, bitmap);
        }
    }

    @Override
    public Bitmap get (String url) {
        if(!TextUtils.isEmpty(url)) {
            return mLruCache.get(url);
        }
        return null;
    }
}
