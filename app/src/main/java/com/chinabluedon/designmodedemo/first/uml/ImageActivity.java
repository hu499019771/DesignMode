package com.chinabluedon.designmodedemo.first.uml;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chinabluedon.designmodedemo.R;
import com.chinabluedon.designmodedemo.first.uml.imageloader.ImageLoader;

/**
 * @author ht
 * @time 2017/8/10  10:09
 * @desc ${TODD}
 */
public class ImageActivity extends Activity {

    private ImageView mImageView;
    public static final String imageUrl="http://imgsrc.baidu.com/image/c0%3Dshijue1%2C0%2C0%2C294%2C40/sign=60aeee5da74bd11310c0bf7132c6ce7a/72f082025aafa40fe3c0c4f3a164034f78f0199d.jpg";

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        mImageView = (ImageView) findViewById(R.id.button);
        ImageLoader loader = new ImageLoader();
        loader.disPlayBitmap(imageUrl,mImageView);

    }
}
