package com.example.administrator.checkdevices.network;

import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.checkdevices.model.entities.Res_login2;
import com.example.administrator.checkdevices.network.api.NetServiceApi;
import com.example.administrator.checkdevices.utils.Constant;
import com.example.administrator.checkdevices.utils.NullOnEmptyConverterFactory;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wd on 2017/11/20.
 *
 * @author wd
 * @date 2017/11/20
 * @describe TODO
 * @package com.example.administrator.checkdevices.network
 */



public class Network {

    private static Network instance;

    private static NetServiceApi netServiceApi;


//    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public Network() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client=new OkHttpClient().newBuilder();
        client.addInterceptor(httpLoggingInterceptor).build();
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取cookie
                Response response=chain.proceed(chain.request());
                List<String> cookies=response.headers("Set-Cookie");
                String cookieStr = "";
                if (cookies != null && cookies.size() > 0) {
                    for (int i = 0; i < cookies.size(); i++) {
                        cookieStr += cookies.get(i);
                    }
//                    SPUtils.put().saveUserCookieId(cookieStr);
                    Constant.cookie=cookieStr;
                }
                Log.e("network-cookie",cookieStr);
                return response;
            }
        });
        client.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
//                return null;
                //设置cookie
                String cookieStr=Constant.cookie;
                if(!TextUtils.isEmpty(cookieStr)){
                    return chain.proceed(chain.request().newBuilder().header("Cookie",cookieStr).build());
                }
                return chain.proceed(chain.request());

            }
        });
        Retrofit retrofit=new Retrofit.Builder()
                .client(client.build())
                .baseUrl(Constant.sql_url)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(new ToByteConvertFactory())
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        netServiceApi=retrofit.create(NetServiceApi.class);
    }
    public static Network getInstance() {

        if (instance == null) {
            synchronized (Network.class) {
                if (instance == null) {
                    instance = new Network();
                }
            }
        }
        return instance;
    }

    /**
     * 登陆
     */
    public void login(Subscriber<Res_login2> subscriber, String account, String password){
        Observable<Res_login2> observable=netServiceApi.postlogin( account,password);
        toSubscriber(observable,subscriber);
    }
    /**
     * 获取设备快照信息
     */
   /* public void getDevices(Subscriber<ArrayList<DeviceSnapshot>> subscriber,String ids){
        Observable<ArrayList<DeviceSnapshot>> observable=netServiceApi.getDevices(ids);
        toSubscriber(observable,subscriber);
    }*/
    public void getDevices(Subscriber<ResponseBody> subscriber,String ids){
        Observable<ResponseBody> observable=netServiceApi.getDevices(ids);
        toSubscriber(observable,subscriber);
    }

    /**
     * 获取设备信息  device_no 设备编号
     */
  /*  public void getDeviceInfo(Subscriber<Device> subscriber,String device_no){
        Observable<Device> observable=netServiceApi.getDeviceInfo(device_no);
        toSubscriber(observable,subscriber);
    }*/

    /**
     * 获取设备信息  device_no 设备编号
     */
    public void getDeviceInfo(Subscriber<ResponseBody> subscriber, String device_no){
        Observable<ResponseBody> observable=netServiceApi.getDeviceInfo(device_no);
        toSubscriber(observable,subscriber);
    }
    private <T> void toSubscriber(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}
