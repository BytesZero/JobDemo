package com.zhengsonglan.jobdemo.strictmode;

import android.os.Bundle;
import android.view.View;

import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;
import com.zhengsonglan.jobdemo.config.AppConfig;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zsl on 2014/12/31.
 */
public class StrictModeActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppConfig.setDeveloperMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {
        String url="http://g.hiphotos.baidu.com/image/w%3D310/sign=7725d8ccd3a20cf44690f8de46084b0c/e1fe9925bc315c601a0f34a48eb1cb13485477e6.jpg";
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(10000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case 1:{
                break;
            }
            default:{
                break;
            }
        }
    }
}
