package com.zhengsonglan.jobdemo.asynctask;

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
    private String url="http://g.hiphotos.baidu.com/image/w%3D310/sign=7725d8ccd3a20cf44690f8de46084b0c/e1fe9925bc315c601a0f34a48eb1cb13485477e6.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask);
        initView();
        initEvent();
        initData();
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
                /**
                 * 执行Execute方法
                 */
                MyAsynTask myAsynTask=new MyAsynTask(imageView);
                myAsynTask.execute(url);
            }
        });
    }

    @Override
    public void initData() {

    }
}
