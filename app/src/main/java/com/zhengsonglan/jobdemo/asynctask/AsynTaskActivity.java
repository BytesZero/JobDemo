package com.zhengsonglan.jobdemo.asynctask;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;
import com.zhengsonglan.jobdemo.config.AppConfig;

/**
 * Created by zsl on 2014/12/30.
 */
public class AsynTaskActivity extends BaseActivity implements BaseActivityInterface {
    private ProgressDialog progressDialog;
    private ImageView imageView;
    private Button bt_iv,bt_dialog;
    private String url="http://g.hiphotos.baidu.com/image/w%3D310/sign=7725d8ccd3a20cf44690f8de46084b0c/e1fe9925bc315c601a0f34a48eb1cb13485477e6.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppConfig.setDeveloperMode();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyntask);
        initView();
        initEvent();
        initData();
    }

    @Override
    public void initView() {
        progressDialog=new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        progressDialog.setMax(100);
        progressDialog.setTitle("加载进度");
        progressDialog.setMessage("加载中");
        progressDialog.setCanceledOnTouchOutside(false);

        imageView= (ImageView) findViewById(R.id.asyntask_imageview);
        bt_iv= (Button) findViewById(R.id.asyntask_bt_img);
        bt_dialog= (Button) findViewById(R.id.asyntask_bt_dialog);


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
        bt_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                LoadingAsynTask loadingAsynTask=new LoadingAsynTask(progressDialog);
                loadingAsynTask.execute("");
            }
        });
    }

    @Override
    public void initData() {

    }
}
