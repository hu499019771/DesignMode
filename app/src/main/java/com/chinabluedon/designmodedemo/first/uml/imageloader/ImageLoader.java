package com.chinabluedon.designmodedemo.first.uml.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chinabluedon.designmodedemo.first.uml.utils.TaskRunUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 胡腾
 * @time 2017/8/9  21:03
 * @desc 图片加载类
 */
public class ImageLoader {

    private ImageCache mImageCache = new DoubleCache();

    /**
     * 线程池
     */
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void setImageCache (ImageCache imageCache) {
        this.mImageCache = imageCache;
    }

    public void disPlayBitmap (final String url, final ImageView imageView) {
        if (!TextUtils.isEmpty(url)) {
            Bitmap bitmap = null;
            bitmap = mImageCache.get(url);
            if (bitmap != null) {
                //设置到imageview中
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
            }
            //获取网络bitmap
            mExecutorService.execute(new Runnable() {
                @Override
                public void run () {
                    final Bitmap bitmap = downloadBitmap(url);
                    if (bitmap != null) {
                        //设置到imageView
                        TaskRunUtils.runOnMainThread(new Runnable() {
                            @Override
                            public void run () {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                        //存到缓存中
                        mImageCache.put(url, bitmap);
                    }
                }
            });


        }
    }

    private Bitmap downloadBitmap (String url) {
        Bitmap bitmap = null;
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}
