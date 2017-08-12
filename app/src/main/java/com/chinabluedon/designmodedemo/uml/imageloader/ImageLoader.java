package com.chinabluedon.designmodedemo.uml.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chinabluedon.designmodedemo.R;
import com.chinabluedon.designmodedemo.utils.TaskRunUtils;

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

    //图片缓存
    private ImageCache mImageCache;

    //正在加载中图片id
    private int mLoadingImageId;

    //加载失败的图片id
    private int mLoadingFailedImageId;

    //图片加载策略
    private LoaderPolicy mLoaderPolicy;

    //线程数据
    private int mThreadCount;

    //线程池
    private ExecutorService mExecutorService;

    private ImageLoader (Builder builder) {
        this.mImageCache = builder.mImageCache;
        this.mLoadingImageId = builder.mLoadingImageId;
        this.mLoadingFailedImageId = builder.mLoadingFailedImageId;
        this.mLoaderPolicy = builder.mLoaderPolicy;
        this.mExecutorService = Executors.newFixedThreadPool(builder.mThreadCount);
    }

    public void disPlayBitmap (final @NonNull String url, final @NonNull ImageView imageView) {
        if (!TextUtils.isEmpty(url)) {
            Bitmap bitmap = null;
            bitmap = mImageCache.get(url);//从缓存获取图片
            if (bitmap != null) {
                //设置到imageview中
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
            }
            submitLoaderRequset(url, imageView);

        }
    }

    /**
     * 网络加载图片并且显示
     *
     * @param url
     * @param imageView
     */
    private void submitLoaderRequset (@NonNull final String url, @NonNull final ImageView imageView) {
        imageView.setImageResource(mLoadingImageId);
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
                    return;
                }
                imageView.setImageResource(mLoadingFailedImageId);
            }
        });
    }

    /**
     * 下载图片
     *
     * @param url
     * @return
     */
    private
    @Nullable
    Bitmap downloadBitmap (String url) {
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

    public static final class Builder {

        //图片缓存
        private ImageCache mImageCache;

        //正在加载中图片id
        private int mLoadingImageId;

        //加载失败的图片id
        private int mLoadingFailedImageId;

        //图片加载策略
        private LoaderPolicy mLoaderPolicy;

        //线程数据
        private int mThreadCount;

        public Builder imageCache (@NonNull ImageCache imageCache) {
            if (imageCache == null) throw new NullPointerException("imageCache==null");
            this.mImageCache = imageCache;
            return this;
        }

        public Builder loadingImageId (int loadingImageId) {
            if (loadingImageId == 0) throw new NullPointerException("loadingImageId==0");
            this.mLoadingImageId = loadingImageId;
            return this;
        }

        public Builder loadingFailedImageId (int loadingFailedImageId) {
            if (loadingFailedImageId == 0)
                throw new NullPointerException("loadingFailedImageId==0");
            this.mLoadingFailedImageId = loadingFailedImageId;
            return this;
        }

        public Builder loaderPolicy (@NonNull LoaderPolicy loaderPolicy) {
            if (loaderPolicy == null) throw new NullPointerException("loaderPolicy==null");
            this.mLoaderPolicy = loaderPolicy;
            return this;
        }

        public Builder threadCount (int threadCount) {
            if (threadCount == 0) throw new NullPointerException("threadCount==0");
            this.mThreadCount = threadCount;
            return this;
        }

        public ImageLoader build () {
            if (mImageCache == null) {
                mImageCache = new DoubleCache();
            }
            if (mLoadingImageId == 0) {
                mLoadingImageId = R.mipmap.ic_launcher;
            }
            if (mLoadingFailedImageId == 0) {
                mLoadingFailedImageId = R.mipmap.ic_launcher;
            }
            if (mLoaderPolicy == null) {
                mLoaderPolicy = new LoaderPolicy();
            }
            if (mThreadCount == 0) {
                mThreadCount = Runtime.getRuntime().availableProcessors() + 1;
            }
            return new ImageLoader(this);
        }

    }


}
