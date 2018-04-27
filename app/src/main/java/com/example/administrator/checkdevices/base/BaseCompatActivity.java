package com.example.administrator.checkdevices.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.administrator.checkdevices.utils.StateBarTranslucentUtils;
import com.qmuiteam.qmui.alpha.QMUIAlphaViewHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.ButterKnife;

public abstract class BaseCompatActivity extends AppCompatActivity {
    /**
     * 初始化布局
     */
    public abstract void initContentView();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化控制中心
     */
    public abstract void initPresenter();

    private BaseCompatActivity oContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // 隐藏标题栏
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        QMUIStatusBarHelper.translucent(this);

        initContentView();
        oContext=this;
        // 初始化View注入
        ButterKnife.bind(this);
//        StateBarTranslucentUtils.setStateBarTranslucent(this);
        initView();
        initPresenter();
//        initNext();
    }

    @Override
    public void finish() {
        // 清除网络请求队列
//        AsyncHttpNetCenter.getInstance().clearRequestQueue(this);
        super.finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // 添加Activity方法
    public void show_Toast(String text) {
        Toast.makeText(oContext, text, Toast.LENGTH_SHORT).show();
    }
}
