package com.example.administrator.checkdevices.ui;

import android.content.Intent;
import android.os.Handler;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseCompatActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.functions.Action1;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class SplashActivity extends BaseCompatActivity {
    private Handler handler;
    private int SPLASH_DISPLAY_LENGHT=3000;

    @Override
    public void initContentView() {
        QMUIStatusBarHelper.translucent(this);
        setContentView(R.layout.splash_activity);
        getPermission();
    }

    @Override
    public void initView() {
        handler = new Handler();
        // 延迟SPLASH_DISPLAY_LENGHT时间然后跳转到MainActivity
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        LoginActivity.class);//游戏主Activity，Unity中是继承Unity Activity的那个Activity
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void finish() {
        super.finish();
    }

    public void getPermission() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(WRITE_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
//                            Toast.makeText(SplashActivity.this, "已授权", Toast.LENGTH_SHORT).show();
                        } else {
//                            Toast.makeText(SplashActivity.this, "未授权", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}
