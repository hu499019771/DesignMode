package com.chinabluedon.designmodedemo.UML.imageloader;

import android.graphics.Bitmap;
import android.os.Environment;

import com.blankj.utilcode.util.ImageUtils;

/**
 * @author ht
 * @time 2017/8/10  9:45
 * @desc ${TODD}
 */
public class DiskCache implements ImageCache {

    public static final String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache/";

    @Override
    public Bitmap get (String url) {
        return ImageUtils.getBitmap(PATH + url);
    }

    @Override
    public void put (String url, Bitmap bitmap) {
        ImageUtils.save(bitmap, PATH+ url, Bitmap.CompressFormat.PNG);
    }
}
