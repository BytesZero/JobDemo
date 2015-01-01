package com.zhengsonglan.jobdemo.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;

/**
 * BaseActivityInterface
 * @author zsl
 * @version 2015年1月1日 20:25:47
 */
public class HandlerActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {
    private int[] ivs={R.drawable.img1,R.drawable.img2,R.drawable.img3};
    private Handler handler;
    private ImageView iv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        initView();
        initEvent();
        initData();
    }

    @Override
    public void initView() {
        iv_show= (ImageView) findViewById(R.id.handler_iv_show);

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                iv_show.setImageResource(ivs[msg.what%3]);
            }
        };
        new Thread(){
            @Override
            public void run() {

                for (int i=0;i>=0;i++) {
                    Message message=handler.obtainMessage();
                    message.what=i%3;
                    handler.sendMessageDelayed(message,1000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
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
