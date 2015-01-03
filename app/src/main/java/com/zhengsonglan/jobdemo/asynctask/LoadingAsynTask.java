package com.zhengsonglan.jobdemo.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * Created by zsl on 2014/12/30.
 */
public class LoadingAsynTask extends AsyncTask<String, Integer, Boolean> {

    ProgressDialog progressDialog;

    public LoadingAsynTask(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress(values[0]);
        progressDialog.setMessage("加载中 "+values[0]+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        progressDialog.setMessage("加载完成");
        progressDialog.dismiss();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        for (int i=0;i<101;i++){
            publishProgress(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
