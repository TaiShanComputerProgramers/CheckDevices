package com.example.administrator.checkdevices.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseFragment;
import com.example.administrator.checkdevices.base.BaseFragment2;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by wd on 2017/10/16.
 *
 * @author wd
 * @date 2017/10/16
 * @describe TODO
 * @package reli.kdzt.com.gongretong.view
 */

public class WarnFragment extends BaseFragment2 {
    private Context mContext;
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    public WarnFragment() {
        super();
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_warn;
    }

    @Override
    public void initView(View view) {
        mContext=getContext();
        initTopBar();
    }

    @Override
    protected void managerArguments() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected float getRandom(float range, float startsfrom) {
        return super.getRandom(range, startsfrom);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public String getUmengFragmentName() {
        return null;
    }

    /*  @Override
            public int getLayoutRes() {
                return R.layout.fragment_warn;
            }

            @Override
            public void initView(View view) {
                mContext=getContext();
                toolbar.setTitle("设备报警");
            }

            @Override
            protected void managerArguments() {

            }

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
            }

            @Override
            public void onDestroyView() {
                super.onDestroyView();
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                return super.onCreateView(inflater, container, savedInstanceState);
            }

            @Override
            public void onSaveInstanceState(Bundle outState) {
                super.onSaveInstanceState(outState);
            }

            @Override
            public Context getContext() {
                return super.getContext();
            }

            @Override
            public void onResume() {
                super.onResume();
            }

            @Override
            public void onPause() {
                super.onPause();
            }

            @Override
            public String getUmengFragmentName() {
                return null;
            }
            public static WarnFragment getInstance() {
                WarnFragment mf = new WarnFragment();
                return mf;
            }*/
    private void warn(){
        NotificationManager manager=(NotificationManager) getActivity().getSystemService(mContext.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setTicker("提示内容");//通知弹出时状态栏的提示文本
        builder.setContentInfo("补充内容");
        builder.setContentTitle("Title");//通知标题
        builder.setContentText("主内容区");
//        builder.setSmallIcon(R.drawable.ic_launcher);//通知小图标
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_SOUND);//设置声音/震动等
        builder.setWhen(System.currentTimeMillis());//设置时间，设置为系统当前的时间
        /*Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);*/
        Notification notification = builder.build();
        /**
         * vibrate属性是一个长整型的数组，用于设置手机静止和振动的时长，以毫秒为单位。
         * 参数中下标为0的值表示手机静止的时长，下标为1的值表示手机振动的时长， 下标为2的值又表示手机静止的时长，以此类推。
         */
       /* long[] vibrates = { 0, 1000, 1000, 1000 };
        notification.vibrate = vibrates;

        *//**
         * 手机处于锁屏状态时， LED灯就会不停地闪烁， 提醒用户去查看手机,下面是绿色的灯光一 闪一闪的效果
         *//*
        notification.ledARGB = Color.GREEN;// 控制 LED 灯的颜色，一般有红绿蓝三种颜色可选
        notification.ledOnMS = 1000;// 指定 LED 灯亮起的时长，以毫秒为单位
        notification.ledOffMS = 1000;// 指定 LED 灯暗去的时长，也是以毫秒为单位
        notification.flags = Notification.FLAG_SHOW_LIGHTS;// 指定通知的一些行为，其中就包括显示*/
        // LED 灯这一选项



//                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//                notification.sound = uri;
//                notification.defaults = Notification.DEFAULT_ALL;
        //通过NotificationManager发送通知
        manager.notify(1, notification);
    }

    private void initTopBar() {
       /* mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });*/
        mTopBar.setTitle("信息");
    }
    public static WarnFragment getInstance() {
        WarnFragment mf = new WarnFragment();
        return mf;
    }
}
