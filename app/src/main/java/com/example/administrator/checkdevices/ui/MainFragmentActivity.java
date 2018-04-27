package com.example.administrator.checkdevices.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseCompatActivity;
import com.example.administrator.checkdevices.interfaces.OnReadThreadListener;
import com.example.administrator.checkdevices.model.DeviceSnapshot;
import com.example.administrator.checkdevices.model.TabEntity;
import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.model.entities.Device_t_NJZJ;
import com.example.administrator.checkdevices.model.entities.Res_login2;
import com.example.administrator.checkdevices.model.login_devices;
import com.example.administrator.checkdevices.network.SubscriberOnNextListener;
import com.example.administrator.checkdevices.utils.Constant;
import com.example.administrator.checkdevices.utils.DevClient;
import com.example.administrator.checkdevices.utils.DeviceAdapterUtil;
import com.example.administrator.checkdevices.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

public class MainFragmentActivity extends BaseCompatActivity {
    private ArrayList<Fragment> mFragment=new ArrayList<>();
    private String[] mTitles = {"主页", "我的"};
    private int[] mIconUnselectIds = {R.mipmap.e_hhp_unchoosed,
            R.mipmap.my_unchoosed};
    private int[] mIconSelectIds = {R.mipmap.e_hhp_choosed,
            R.mipmap.my_choosed};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;
    private CommonTabLayout mTabLayout;
    private List<Device_t> device_list=new ArrayList<>();
    private OnReadThreadListener onReadThreadListener;
    private SubscriberOnNextListener getLoginOnNext;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_common_tab);
    }

    @Override
    public void initView() {
        initNext();
        initView2();
    }

    @Override
    public void initPresenter() {

    }
    private void reshDeviceList(Device_t deviceSnapshot){
        if(!device_list.contains(deviceSnapshot))device_list.add(deviceSnapshot);
        DeviceListFragment.getOnDeviceChangeListener().onDeviceResh(deviceSnapshot);
    }
    private void initView2(){
        Res_login2 res_login2=(Res_login2)getIntent().getSerializableExtra("res");
        if(res_login2!=null){
            device_list.clear();
            List<login_devices> list=res_login2.getDevices();
            for(int i=0;i<list.size();i++){
                Device_t deviceSnapshot=new Device_t_NJZJ();
                login_devices login_devices=list.get(i);
                deviceSnapshot.setComeDate(login_devices.getImporDatetime());
                deviceSnapshot.setDeviceNo(login_devices.getDeviceNo());
                deviceSnapshot.setNickName(login_devices.getNickName());
                deviceSnapshot.setRunstatus(0);
                device_list.add(deviceSnapshot);
            }

        }
        DeviceListFragment mainFragment=DeviceListFragment.getInstance(device_list);
        SetFragment setFragment=SetFragment.getInstance();
        mFragment.add(mainFragment);
        mFragment.add(setFragment);
        for(int i=0;i<mTitles.length;i++){
            mTabEntities.add(new TabEntity(mTitles[i],mIconSelectIds[i],mIconUnselectIds[i]));
        }
        mDecorView=getWindow().getDecorView();
        mTabLayout= ViewFindUtils.find(mDecorView,R.id.tl_3);
        mTabLayout.setTabData(mTabEntities,MainFragmentActivity.this,R.id.fl_change,mFragment);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener(){
            @Override
            public void onTabSelect(int position) {

            }
            @Override
            public void onTabReselect(int position) {

            }
        });
        mTabLayout.setCurrentTab(0);


    }
    private boolean mIsExit;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(mIsExit){
                exitDialog();
            }else{
                Toast.makeText(this,"再按一次退出应用",Toast.LENGTH_LONG).show();
                mIsExit=true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit=false;
                    }
                },2000);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(MainFragmentActivity.this,"main destroy",Toast.LENGTH_LONG);
        super.onDestroy();
    }
    private void exitDialog(){
        new QMUIDialog.MessageDialogBuilder(this)
                .setTitle("提示")
                .setMessage("确定要退出吗？")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        System.exit(0);
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void initNext() {
        onReadThreadListener=new OnReadThreadListener() {
            @Override
            public void onReadData(Object o) {
                if(o instanceof  DeviceSnapshot){
                    DeviceSnapshot deviceItem=(DeviceSnapshot)o;
                    if(deviceItem.getError()>0||deviceItem.getAlarm()>0){
                        warn("收到"+deviceItem.getAlarm()+deviceItem.getError()+"条报警信息！");
                    }
                    DeviceListFragment.getOnDeviceChangeListener().onDeviceResh(deviceItem);

                }else if(o instanceof Device_t){
                    Device_t deviceItem=(Device_t)o;
                    if(deviceItem.getExceptionCount()>0){
                        warn("收到"+deviceItem.getExceptionCount()+"条报警信息！");
                    }
                    DeviceListFragment.getOnDeviceChangeListener().onDeviceResh(deviceItem);
                }

            }
        };
        getLoginOnNext=new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                if(o instanceof Device_t){
                    Device_t res=(Device_t) o;
                    reshDeviceList(res);
                }else if(o instanceof ArrayList){
                    ArrayList<Device_t> list=(ArrayList)o;

                    if(list.size()>0){
                        Device_t res=(Device_t) list.get(0);
                        reshDeviceList(res);
                    }

                }else if(o instanceof ResponseBody){
                    ResponseBody responseBody=(ResponseBody)o;
                    List<Device_t> list=null;
                    try {
                        byte[] bs = responseBody.bytes();
                        list = DeviceAdapterUtil.getDevicesByByte(bs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(list!=null&&list.size()>0){
                        Device_t res=(Device_t) list.get(0);
                        reshDeviceList(res);
                    }
                }
            }
            @Override
            public void onComplete(Object o) {
            }
        };
    }
    @Override
    protected void onResume() {
        super.onResume();
        DevClient devClient=DevClient.getInstance(getApplicationContext());
        if(devClient.getOnReadThreadListener()==null||!devClient.getOnReadThreadListener().equals(onReadThreadListener)){
            devClient.setOnReadThreadListener(onReadThreadListener,false,"");
        }
        devClient.addDeviceToList(device_list,null);
        devClient.startSendMessageThread(Constant.devices);
    }
    /**
     * 通知
     */
    private void warn(String message){
        if(Constant.warn_type==0)return;
        NotificationManager manager=(NotificationManager)getApplicationContext().getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setTicker("报警");//通知弹出时状态栏的提示文本
//        builder.setContentInfo("补充内容");
//        builder.setContentTitle("Title");//通知标题
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.qmui_icon_notify_info);//通知小图标
        builder.setAutoCancel(true);
//        builder.setDefaults(Notification.DEFAULT_SOUND);//设置声音/震动等
//        builder.setDefaults(Notification.DEFAULT_ALL);
        if(Constant.warn_type==1){
            builder.setDefaults(Notification.DEFAULT_SOUND);
        }else if(Constant.warn_type==2){
            builder.setDefaults(Notification.DEFAULT_VIBRATE);
        }else if(Constant.warn_type==3){
            builder.setDefaults(Notification.DEFAULT_ALL);
        }
        builder.setWhen(System.currentTimeMillis());//设置时间，设置为系统当前的时间
     /*   Intent intent = new Intent(this.getActivity(), MainFragmentActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this.getActivity(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
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

    @Override
    protected void onPause() {
        super.onPause();
        DevClient devClient=DevClient.getInstance(MainFragmentActivity.this);
        devClient.addDeviceToList(device_list,null);
        devClient.stopSendMessageThread();

    }

}
