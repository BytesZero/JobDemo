package com.zhengsonglan.jobdemo.AsynTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.widget.ImageView;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/**
 * Created by zsl on 2014/12/30.
 */
public class MyAsynTask extends AsyncTask<String, Void, Bitmap> {

    private final WeakReference<ImageView> bitmapWeakReference;

    public MyAsynTask(ImageView imageView) {
        bitmapWeakReference = new WeakReference<ImageView>(imageView);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmapWeakReference!=null){
            ImageView imageView=bitmapWeakReference.get();
            if (imageView!=null){
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        HttpGet httpGet = new HttpGet(params[0]);
        AndroidHttpClient httpClient = AndroidHttpClient.newInstance("android");
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            InputStream inputStream = httpResponse.getEntity().getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;



        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
