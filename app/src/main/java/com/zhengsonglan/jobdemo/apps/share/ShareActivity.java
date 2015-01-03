package com.zhengsonglan.jobdemo.apps.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhengsonglan.jobdemo.R;
import com.zhengsonglan.jobdemo.base.BaseActivity;
import com.zhengsonglan.jobdemo.base.BaseActivityInterface;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zsl on 2014/12/31.
 */
public class ShareActivity extends BaseActivity implements BaseActivityInterface,View.OnClickListener {

    private static final String SHARED_FILE_NAME = "shared.png";
    Button bt_share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        initView();
        initEvent();
        initData();
    }

    @Override
    public void initView() {
        bt_share= (Button) findViewById(R.id.share_bt_share);

    }

    @Override
    public void initEvent() {
        bt_share.setOnClickListener(this);
    }

    @Override
    public void initData() {
        copyPrivateRawResuorceToPubliclyAccessibleFile();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.share_bt_share:{
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
//                shareIntent.setType("image/*");
                /*Uri uri = Uri.fromFile(getFileStreamPath("shared.png"));
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                */
                shareIntent.putExtra(Intent.EXTRA_TEXT, "测试内容http://www.xun600.com/member/register/?s=YY1300326388");
//                shareIntent.putExtra(Intent.EXTRA_HTML_TEXT,"测试内容http://www.xun600.com/member/register/?s=YY1300326388");
//                shareIntent.putExtra(Intent.EXTRA_EMAIL,"测试内容http://www.xun600.com/member/register/?s=YY1300326388");
//                shareIntent.putExtra(Intent.EXTRA_TEMPLATE,"测试内容http://www.xun600.com/member/register/?s=YY1300326388");
                startActivity(shareIntent);
                break;
            }
            default:{
                break;
            }
        }
    }

    private void copyPrivateRawResuorceToPubliclyAccessibleFile() {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = getResources().openRawResource(R.raw.img1);
            outputStream = openFileOutput(SHARED_FILE_NAME,
                    Context.MODE_WORLD_READABLE | Context.MODE_APPEND);
            byte[] buffer = new byte[1024];
            int length = 0;
            try {
                while ((length = inputStream.read(buffer)) > 0){
                    outputStream.write(buffer, 0, length);
                }
            } catch (IOException ioe) {
                /* ignore */
            }
        } catch (FileNotFoundException fnfe) {
            /* ignore */
        } finally {
            try {
                inputStream.close();
            } catch (IOException ioe) {
               /* ignore */
            }
            try {
                outputStream.close();
            } catch (IOException ioe) {
               /* ignore */
            }
        }
    }
}
