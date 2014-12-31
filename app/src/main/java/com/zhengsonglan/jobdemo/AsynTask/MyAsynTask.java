package com.zhengsonglan.jobdemo.AsynTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zsl on 2014/12/30.
 */
public class MyAsynTask extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;

    public MyAsynTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String img_url = params[0];
        return BitmapFactory.decodeStream(DownLoadImage(img_url));
    }

    /**
     * 下载图片
     * @param img_url
     * @return
     */
    private InputStream DownLoadImage(String img_url) {
        try {
            URL url = new URL(img_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(10000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            return connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
