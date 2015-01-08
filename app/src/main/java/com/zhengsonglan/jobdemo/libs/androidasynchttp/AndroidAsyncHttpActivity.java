package com.zhengsonglan.jobdemo.libs.androidasynchttp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;

import org.apache.http.Header;

/**
 * Created by zsl on 2014/12/31.
 */
public class AndroidAsyncHttpActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {

    Button bt_basehttp,bt_basehttp2;

    String url="http://www.baidu.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidasynchttp);
        initView();
        initEvent();
        initData();
    }

    @Override
    public void initView() {
        bt_basehttp= (Button) findViewById(R.id.androidasynchttp_bt_basehttp);
        bt_basehttp2= (Button) findViewById(R.id.androidasynchttp_bt_basehttp2);
    }

    @Override
    public void initEvent() {
        bt_basehttp.setOnClickListener(this);
        bt_basehttp2.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.androidasynchttp_bt_basehttp:{
                baseAsyncHttp();
                break;
            }

            case R.id.androidasynchttp_bt_basehttp2:{
                baseAsyncHttp2();
                break;
            }
            default:{
                break;
            }
        }
    }

    /**
     * 简单请求2
     */
    private void baseAsyncHttp2() {
        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        asyncHttpClient.get(this,url,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                showToast("success");
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                showToast("failure");
            }

            @Override
            public void onStart() {
                showToast("start");
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
            }
        });
    }

    /**
     * 基本的异步请求
     */
    private void baseAsyncHttp() {
        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        asyncHttpClient.get(this,url,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                showToast(bytes.toString()+i+"success");
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                showToast(bytes.toString()+i+"failure");
            }
        });
    }
}
