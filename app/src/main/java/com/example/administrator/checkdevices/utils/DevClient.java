package com.example.administrator.checkdevices.utils;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import com.example.administrator.checkdevices.interfaces.OnReadThreadListener;
import com.example.administrator.checkdevices.model.Device;
import com.example.administrator.checkdevices.model.DeviceSnapshot;
import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.network.Network;
import com.example.administrator.checkdevices.network.ProgressSubscriber;
import com.example.administrator.checkdevices.network.SubscriberOnNextListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * guoguang device client 
 * @author weidong
 * add 2017.12.07
 *
 */
public class DevClient {
	private volatile static DevClient instance;
	private String LogTag = "DevClient";

	private List<Device_t> device_list=new ArrayList<>();//默认轮训的设备列表
	public static List<Device_t> device_info_list=new ArrayList<>();//手动执行的单个设备 单个指令设备列表
	private Context context;
	private static OnReadThreadListener onReadThreadListener;
	private Subscriber<Long> subscriber;
	private List<String> list_login=new ArrayList<>();

	private boolean tag=false;//true 设备详情  false 快照
	private String deviceNo="";

	private Uri notification=null;
	private Ringtone r=null;
	private int num=0;

	private DevClient(Context context){
		this.context=context;

     }
	public static DevClient getInstance(Context context){
		if(instance==null){
			synchronized (DevClient.class){
				if(instance==null){
					instance=new DevClient(context);
				}
			}
		}
		return instance;
	}
	public OnReadThreadListener getOnReadThreadListener() {
		return onReadThreadListener;
	}

	public   void setOnReadThreadListener(OnReadThreadListener onReadThreadListener,boolean tag,String deviceNo) {
		this.onReadThreadListener = onReadThreadListener;
		this.tag=tag;
		this.deviceNo=deviceNo;
	}
	/**
	 * 发送（全app只有一个发送入口，随时添加、删除（根据次数、有返回数据删除）、暂停）
	 */
	public  void startSendMessageThread(List<String> list){
		Log.e("devclient","startSendMessageThread");
		if(subscriber==null||(subscriber!=null&&subscriber.isUnsubscribed()))subscriber=new Subscriber<Long>() {
			@Override
			public void onCompleted() {
			}
			@Override
			public void onError(Throwable e) {
			}
			@Override
			public void onNext(Long o) {
				Long along = 0L;
				int i = 0;
				if (o instanceof Long) along = (Long) o;
				i = along.intValue();
				Log.e("send_l", "i=" + i);
				if(device_list.size()>0&&!tag){
					num=0;
					getDeviceSnapshot(device_list.get(0).getDeviceNo());
				}else if(tag&&!deviceNo.equals("")){
					getDeviceInfo(deviceNo);
				}
				/*else if(tag){
					reshResult(null);
				}*/
				/*for(int a=0;a<device_list.size();a++){
					getDeviceSnapshot(device_list.get(a).getDeviceNo());
				}*/

			/*	DeviceSnapshot deviceItem=device_list.get(i%device_list.size());
//				deviceItem.setCurrentTime(NetUtils.getCurrentTime());
				if(onReadThreadListener!=null)getResult(deviceItem);*/
			}
		};
		 Observable observable=Observable.interval(0,Constant.fasong_jiange, TimeUnit.SECONDS);
		observable.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(subscriber);
	}
	public void stopSendMessageThread(){
		Log.e("devclient","stopSendMessageThread");
		if(subscriber!=null) Log.e("subscriber",subscriber.isUnsubscribed()+"");
		if(subscriber!=null&&!subscriber.isUnsubscribed()){
			subscriber.unsubscribe();
		}
		if(subscriber!=null) Log.e("subscriber2",subscriber.isUnsubscribed()+"");
	}
	/**
	 * 获取设备快照
	 */
	private void getDeviceSnapshot(final String deviceNo){
			Network.getInstance().getDevices(new ProgressSubscriber<ResponseBody>(new SubscriberOnNextListener(){
				@Override
				public void onNext(Object o) {
					num++;
					if(num<device_list.size()){
						getDeviceSnapshot(device_list.get(num).getDeviceNo());
					}else {
						num=0;
					}
					if(o instanceof DeviceSnapshot){
						DeviceSnapshot res=(DeviceSnapshot) o;
						res.setComeDate(NetUtils.getCurrentLongTime());
//						if(res.getRunstatus()==0)res.setRunstatus(2);
						if(onReadThreadListener!=null)getResult(res);
                   /* if(res.getCode().equals("1")){

                    }else{
                        ToastUtil.showToast(MainFragmentActivity.this,R.string.response_error);
                    }*/
					}else if(o instanceof ArrayList){
						ArrayList<DeviceSnapshot> list=(ArrayList)o;
						if(list.size()>0){
							DeviceSnapshot res=(DeviceSnapshot) list.get(0);
							res.setComeDate(NetUtils.getCurrentLongTime());
//							if(res.getRunstatus()==0)res.setRunstatus(2);
							if(onReadThreadListener!=null)getResult(res);
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
							res.setComeDate(NetUtils.getCurrentLongTime());
//							if(res.getRunstatus()==0)res.setRunstatus(2);
							if(onReadThreadListener!=null)getResult(res);
						}
					}

				}

				@Override
				public void onComplete(Object o) {

				}
			},context,false),deviceNo);
	}
	/**
	 * 获取设备详情
	 */
	private void getDeviceInfo(final String deviceNo){
		Network.getInstance().getDeviceInfo(new ProgressSubscriber<ResponseBody>(new SubscriberOnNextListener(){
			@Override
			public void onNext(Object o) {

				if(o instanceof Device) {
					Device res = (Device) o;
//                    if(res.getRunstatus()==0)res.setRunstatus(2);
					res.setComeDate(NetUtils.getCurrentLongTime());
					if(onReadThreadListener!=null)reshResult(res);

				}else if(o instanceof ResponseBody){
					ResponseBody responseBody=(ResponseBody)o;
					Device_t device=null;
					try {
						byte[] bs = responseBody.bytes();
						device = DeviceAdapterUtil.getDeviceByByte(bs);
					} catch (IOException e) {
						e.printStackTrace();
					}
					device.setComeDate(NetUtils.getCurrentLongTime());
					if(onReadThreadListener!=null)reshResult(device);

				}
			}

			@Override
			public void onComplete(Object o) {

			}
		},context,false),deviceNo);
	}
	/**
	 * 收到结果处理
	 */
	private void getResult(Object deviceItem){
		onReadThreadListener.onReadData(deviceItem);
	}
	/**
	 * 收到结果处理  设备详情
	 */
	private void reshResult(Object deviceItem){
		onReadThreadListener.onReadData(deviceItem);
	}
	public  void setOnReadThread(OnReadThreadListener onReadThreadListener){
		this.onReadThreadListener=onReadThreadListener;
	}
	//获取系统提示音
    private void startAlarm(Context context){
		Log.e("devclient","startalar2m"+"---r="+r);
		if(r!=null)r.stop();
        if(notification==null)notification= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		Log.e("devclient","notification="+notification);
        if(notification==null)return;
        if(r==null)r= RingtoneManager.getRingtone(context,notification);
		Log.e("devclient","startalarm1"+"---r="+r.isPlaying()+"---r1=");
       if(r!=null&&!r.isPlaying()) r.play();
		Log.e("devclient","startalar2m"+"---r="+r.isPlaying());
    }

	/*public void addDeviceToList(List<DeviceSnapshot> list, String tag){
		for(int i=0;i<list.size();i++){
			if(!device_list.contains(list.get(i)))device_list.add(list.get(i));
		}
	}*/
	public void addDeviceToList(List<Device_t> list, String tag){
		for(int i=0;i<list.size();i++){
			if(!device_list.contains(list.get(i)))device_list.add(list.get(i));
		}
	}

	public void clearDeviceToList(List<Device_t> list, String tag){
			device_list.clear();

			for(int i=0;i<list.size();i++){
				device_list.add(list.get(i));
			}
	}
}
