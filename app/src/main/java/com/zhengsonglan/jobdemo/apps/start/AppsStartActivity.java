package com.zhengsonglan.jobdemo.apps.start;

import android.os.Bundle;
import android.view.View;

import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;

/**
 * Created by zsl on 2014/12/31.
 */
public class AppsStartActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appsstart);
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
