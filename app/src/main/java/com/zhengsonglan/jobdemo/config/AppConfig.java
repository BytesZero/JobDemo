package com.zhengsonglan.jobdemo.config;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;

/**
 * Created by Administrator on 2015/1/3.
 */
public class AppConfig {
    //开启检测模式
    public static final boolean DEVELOPER_MODE=true;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void setDeveloperMode(){
        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }
}
