package com.zhengsonglan.jobdemo.apps.start;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

/**
 * 自定义的广播监听程序的卸载与安装
 */
public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //
        PackageManager packageManager = context.getPackageManager();
        String action = intent.getAction();
        String packageName = intent.getData().getSchemeSpecificPart();
        String content="";
        if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
            content="安装";
        } else if(action.equals(Intent.ACTION_PACKAGE_REMOVED)){
            content="卸载";
        } else if(action.equals(Intent.ACTION_PACKAGE_REPLACED)){
            content="覆盖";
        }
        showToast(context,content+"了程序:"+packageName);
    }

    /**
     * 显示Toast
     */
    public void showToast(Context context,String s){
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
