package com.zhengsonglan.jobdemo.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.zhengsonglan.jobdemo.asynctask.AsynTaskActivity;
import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;
import com.zhengsonglan.jobdemo.handler.HandlerActivity;

/**
 * Created by zsl on 2014/12/31.
 */
public class MainActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {

    Button bt_syncTask,bt_handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        initData();
    }

    @Override
    public void initView() {
        bt_syncTask= (Button) findViewById(R.id.main_bt_synctask);
        bt_handler= (Button) findViewById(R.id.main_bt_handler);

    }

    @Override
    public void initEvent() {
        bt_syncTask.setOnClickListener(this);
        bt_handler.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_bt_synctask:{
                Intent intent=new Intent(this, AsynTaskActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.main_bt_handler:{
                Intent intent=new Intent(this, HandlerActivity.class);
                startActivity(intent);
                break;
            }
            default:{
                break;
            }
        }
    }
}
