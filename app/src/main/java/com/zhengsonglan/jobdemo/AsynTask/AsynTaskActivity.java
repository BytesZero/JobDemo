package com.zhengsonglan.jobdemo.AsynTask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;
import com.zhengsonglan.jobdemo.R;

/**
 * Created by zsl on 2014/12/30.
 */
public class AsynTaskActivity extends BaseActivity implements BaseActivityInterface {

    private ImageView imageView;
    private Button bt_iv;
    private String url="http://image.baidu.com/i?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E5%BC%82%E6%AD%A5%E4%B8%8B%E8%BD%BD%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=4663&cl=&lm=&st=&cs=1448543225,1088825859&os=2112771832,482562585&pn=24&rn=1&di=98160235910&ln=1978&fr=&&fmq=1419935676206_R&ic=&s=&se=&sme=0&tab=&width=&height=&face=&is=&istype=&ist=&jit=&objurl=http%3A%2F%2Fres.co188.com%2Fdata%2Fdrawing%2Fimg640%2F1550883351750.jpg&adpicid=0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask);
    }

    @Override
    public void initView() {
        imageView= (ImageView) findViewById(R.id.asyntask_imageview);
        bt_iv= (Button) findViewById(R.id.asyntask_bt);
    }

    @Override
    public void initEvent() {
        bt_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsynTask myAsynTask=new MyAsynTask(imageView);
                myAsynTask.execute(url);
            }
        });
    }

    @Override
    public void initData() {

    }
}
