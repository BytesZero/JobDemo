package com.zhengsonglan.jobdemo.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;

import java.util.Timer;
import java.util.TimerTask;

/**
 * BaseActivityInterface
 * @author zsl
 * @version 2015年1月1日 20:25:47
 */
public class HandlerActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {
    private int[] ivs={R.drawable.img1,R.drawable.img2,R.drawable.img3};
    private Handler handler,handler1,handler2;
    private ImageView iv_show;
    private Button bt_one,bt_two,bt_three;
    private Runnable runnable;
    private int size,size1;
    private Timer timer;
    private TimerTask timerTask;
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
        bt_one= (Button) findViewById(R.id.hanlder_bt_noe);
        bt_two= (Button) findViewById(R.id.hanlder_bt_two);
        bt_three= (Button) findViewById(R.id.hanlder_bt_three);

    }

    @Override
    public void initEvent() {
        bt_one.setOnClickListener(this);
        bt_two.setOnClickListener(this);
        bt_three.setOnClickListener(this);
    }

    @Override
    public void initData() {
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                iv_show.setImageResource(ivs[msg.what%3]);
            }
        };
        handler1=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                size=++size;
                iv_show.setImageResource(ivs[size%3]);
                handler1.postDelayed(runnable,2000);
            }
        };

        timer=new Timer();

        timerTask=new TimerTask() {
            @Override
            public void run() {
                size1++;
                Message message=handler.obtainMessage();
                message.what=size1;
                handler.sendMessageDelayed(message,1000);
            }
        };
        handler2=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                iv_show.setImageResource(ivs[msg.what%3]);
            }
        };

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //handler和Thread的sleep()
            case R.id.hanlder_bt_noe:{
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
                break;
            }
            //handler的postDelayed()和Runnable
            case R.id.hanlder_bt_two:{
                handler1.postDelayed(runnable,1000);

                break;
            }
            //handler和timer、TimerTask的使用
            case R.id.hanlder_bt_three:{
                timer.schedule(timerTask,1000,1000);
                break;
            }
            default:{
                break;
            }
        }
    }
}
