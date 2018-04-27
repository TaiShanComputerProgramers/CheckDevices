package com.example.administrator.checkdevices.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.adapter.TreeNode;
import com.example.administrator.checkdevices.adapter.TreeViewAdapter;
import com.example.administrator.checkdevices.base.BaseFragment2;
import com.example.administrator.checkdevices.interfaces.OnDeviceChangeListener;
import com.example.administrator.checkdevices.interfaces.OnItemClickListener;
import com.example.administrator.checkdevices.model.Device;
import com.example.administrator.checkdevices.model.DeviceSnapshot;
import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.model.entities.Device_t_NJZJ;
import com.example.administrator.checkdevices.network.Network;
import com.example.administrator.checkdevices.network.ProgressSubscriber;
import com.example.administrator.checkdevices.network.SubscriberOnNextListener;
import com.example.administrator.checkdevices.utils.Constant;
import com.example.administrator.checkdevices.utils.DeviceAdapterUtil;
import com.example.administrator.checkdevices.utils.NetUtils;
import com.example.administrator.checkdevices.utils.ToastUtil;
import com.example.administrator.checkdevices.viewbinder.DeviceItemBinder;
import com.example.administrator.checkdevices.viewbinder.DirectoryNodeBinder;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import okhttp3.ResponseBody;

/**
 * Created by wd on 2017/10/16.
 *
 * @author wd
 * @date 2017/11/11
 * @describe TODO
 * @package reli.kdzt.com.gongretong.view
 */
public class DeviceListFragment extends BaseFragment2{
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recycler_list)
    RecyclerView recyclerView;
    private static TreeViewAdapter adapter;
    private static   List<TreeNode> nodes=new ArrayList<>();
    public  static OnDeviceChangeListener onDeviceChangeListener=null;
    private SubscriberOnNextListener getDeviceList;
    private SubscriberOnNextListener getDeviceInfo;
    private List<Device_t> device_list=new ArrayList<>();

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_device;
    }

    @Override
    public void initView(View view) {
        initTopBar();
        assert recyclerView!=null;
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        DeviceItemBinder deviceItemBinder=new DeviceItemBinder();
        deviceItemBinder.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(final Object o, int position) {
               Device_t device_t=new Device_t_NJZJ();
              if(o instanceof Device_t) {
                  device_t = (Device_t) o;
                  if (position == 0) {
                    if(device_t.getRunstatus()==0||device_t.getRunstatus()==-1){
                        ToastUtil.showToast(getActivity(),"设备未开机！");
                    }else if (NetUtils.isNetworkConnected(getActivity().getApplicationContext()))
//                          Network.getInstance().getDeviceInfo(new ProgressSubscriber<ResponseBody>(getDeviceInfo, getActivity(), true), device_t.getDeviceNo());
                      Network.getInstance().getDeviceInfo(new ProgressSubscriber<ResponseBody>(new SubscriberOnNextListener() {
                          @Override
                          public void onNext(Object o1) {
                              if (o1 instanceof Device) {
                                  Device res = (Device) o1;
                                  Intent intent = new Intent();
                                  res.setComeDate(NetUtils.getCurrentLongTime());
                                  intent.putExtra("item", res);
                                  intent.setClass(getActivity(), DeviceInfoActivity2.class);
                                  startActivity(intent);

                              } else if (o1 instanceof ResponseBody) {

                                  ResponseBody responseBody = (ResponseBody) o1;
                                  Device_t device = null;
                                  try {
                                      byte[] bs = responseBody.bytes();
                                      device = DeviceAdapterUtil.getDeviceByByte(bs);
                                  } catch (IOException e) {
                                      e.printStackTrace();
                                  }
                                  if(device!=null){
                                      device.setComeDate(NetUtils.getCurrentLongTime());
                                      Intent intent = new Intent();
                                      device.setComeDate(NetUtils.getCurrentLongTime());
                                      device.setNickName(((Device_t) o).getNickName());
                                      intent.putExtra("item", device);
                                      intent.setClass(getActivity(), DeviceInfoActivity2.class);
                                      startActivity(intent);
                                  }

                              }
                          }

                          @Override
                          public void onComplete(Object o) {
                          }
                      }, getActivity(), true), device_t.getDeviceNo());
                  } else if (position == 1) {
                      if (o instanceof String) {
                          warn((String) o);
                      }
                  }
              }
            }
        });

        adapter=new TreeViewAdapter(nodes, Arrays.asList(deviceItemBinder));
        adapter.setOnTreeNodeListener(new TreeViewAdapter.OnTreeNodeListener() {
            @Override
            public boolean onClick(TreeNode node, RecyclerView.ViewHolder holder) {
                if(!node.isLeaf()){
                    onToggle(!node.isExpand(),holder);
                }
                return false;
            }

            @Override
            public void onToggle(boolean isExpand, RecyclerView.ViewHolder holder) {
                DirectoryNodeBinder.ViewHolder dirViewHolder=(DirectoryNodeBinder.ViewHolder)holder;
                final ImageView isArrow=dirViewHolder.getIvArrow();
                int rotateDegree=isExpand ? 90 : -90;
                isArrow.animate().rotationBy(rotateDegree).start();
            }
        });

        recyclerView.setAdapter(adapter);

        onDeviceChangeListener=new OnDeviceChangeListener() {
            @Override
            public void onDeviceResh(Device_t deviceItem) {

                reshList(deviceItem);

            }

            @Override
            public void onDeviceResh(DeviceSnapshot deviceItem) {

            }
        };
        getDeviceList=new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                if(o instanceof Device){
                    Device res=(Device) o;
                    Intent intent=new Intent();
                    res.setComeDate(NetUtils.getCurrentLongTime());
                    intent.putExtra("item",res);
                    intent.setClass(getActivity(),DeviceInfoActivity2.class);
                    startActivity(intent);

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
                        res.setComeDate(NetUtils.getCurrentLongTime());
                        reshList(res);
                    }
                }
            }
            @Override
            public void onComplete(Object o) {
            }
        };
        loadItems();

    }
    private static   void reshList(Device_t deviceItem){
        if(adapter==null)return;
        if(deviceItem==null){
            if(adapter!=null){
                adapter.refresh(nodes);
            }
        }else{
            if(adapter!=null){
                adapter.refresh(deviceItem);
            }
        }
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

    private void initTopBar() {
        mTopBar.setTitle("设备列表");
    }

    private void loadItems(List<Device_t> list) {
        if(list!=null){
            if(device_list!=null)device_list.clear();
            device_list=list;
        }
        nodes.clear();
        for(int i=0;i<list.size();i++){
            Device_t deviceItem=list.get(i);
            TreeNode<Device_t>node=new TreeNode<>(deviceItem);
            nodes.add(node);
        }
    }
    public static DeviceListFragment getInstance(List<Device_t> device_list) {
        DeviceListFragment mf = new DeviceListFragment();
        mf.loadItems(device_list);
        return mf;
    }

    public static OnDeviceChangeListener getOnDeviceChangeListener() {
        if(onDeviceChangeListener!=null)return onDeviceChangeListener;
        else return new OnDeviceChangeListener() {
            @Override
            public void onDeviceResh(DeviceSnapshot deviceItem) {
            }

            @Override
            public void onDeviceResh(Device_t deviceItem) {
                reshList(deviceItem);
            }
        };
    }
    /**
     * 通知
     */
    private void warn(String message){
        if(Constant.warn_type==0){
            return;
        }
        NotificationManager manager=(NotificationManager) this.getActivity().getApplicationContext().getSystemService(this.getActivity().getApplicationContext().NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.getActivity().getApplicationContext());
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
    private void loadItems() {
        for(int i=0;i<device_list.size();i++){
            if(NetUtils.isNetworkConnected(getActivity().getApplicationContext()))
//                Network.getInstance().getDevices(new ProgressSubscriber<ArrayList<DeviceSnapshot>>(getLoginOnNext,getActivity(),true),device_list.get(i).getDeviceNo());
                Network.getInstance().getDevices(new ProgressSubscriber<ResponseBody>(getDeviceList,getActivity(),true),device_list.get(i).getDeviceNo());
        }
    }
}
