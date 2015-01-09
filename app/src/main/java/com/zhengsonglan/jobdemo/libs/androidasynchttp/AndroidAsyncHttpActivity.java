package com.zhengsonglan.jobdemo.libs.androidasynchttp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;

import org.apache.http.Header;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by zsl on 2014/12/31.
 */
public class AndroidAsyncHttpActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {

    Button bt_basehttp,bt_basehttp2,bt_basehttp3,bt_basehttp4;

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
        bt_basehttp3= (Button) findViewById(R.id.androidasynchttp_bt_basehttp3);
        bt_basehttp4= (Button) findViewById(R.id.androidasynchttp_bt_basehttp4);


    }

    @Override
    public void initEvent() {
        bt_basehttp.setOnClickListener(this);
        bt_basehttp2.setOnClickListener(this);
        bt_basehttp3.setOnClickListener(this);
        bt_basehttp4.setOnClickListener(this);
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
            case R.id.androidasynchttp_bt_basehttp3:{
                PostRequest();
                break;
            }
            case R.id.androidasynchttp_bt_basehttp4:{
                uploadFile();


                break;
            }


            default:{
                break;
            }
        }
    }

    /**
     * 上传文件
     */
    private void uploadFile() {
        try {
            RequestParams params=new RequestParams();
            params.put("name","test");
            params.put("name",new File("test/aa.jpg"));
            AsyncHttpClient httpClient=new AsyncHttpClient();
            httpClient.post(this,url,params,new FileAsyncHttpResponseHandler(this) {

                @Override
                public void onFailure(int i, Header[] headers, Throwable throwable, File file) {
                    showToast("failure");
                }

                @Override
                public void onSuccess(int i, Header[] headers, File file) {
                    showToast("success");
                }

            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            showToast("file not selected");
        }
    }

    /**
     * post请求
     */
    private void PostRequest() {
        RequestParams requestParams=new RequestParams();
        requestParams.put("name","test");
        requestParams.put("pwd","123");
        AsyncHttpClient client=new AsyncHttpClient();
        client.post(this,url,requestParams,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                showToast("成功");
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                showToast("失败");
            }
        });
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
