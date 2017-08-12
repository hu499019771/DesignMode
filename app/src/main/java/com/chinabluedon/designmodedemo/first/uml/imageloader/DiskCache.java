package com.chinabluedon.designmodedemo.first.uml.imageloader;

import android.graphics.Bitmap;
import android.os.Environment;

import com.blankj.utilcode.util.CloseUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author ht
 * @time 2017/8/10  9:45
 * @desc ${TODD}
 */
public class DiskCache implements ImageCache {

    public static final String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/cache/";

    @Override
    public Bitmap get (String url) {
        return ImageUtils.getBitmap(PATH + EncryptUtils.encryptMD5ToString(url)+".png");
    }

    @Override
    public void put (String url, Bitmap bitmap) {
        FileOutputStream outputStream=null;
        try {
            File file=new File(PATH+ EncryptUtils.encryptMD5ToString(url)+".png");
            FileUtils.createOrExistsFile(file);
            outputStream=new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            CloseUtils.closeIO(outputStream);
        }
    }
}
