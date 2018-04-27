package com.example.administrator.checkdevices.network.api;


import com.example.administrator.checkdevices.model.entities.Res_login2;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wd on 2017/11/20.
 *
 * @author wd
 * @date 2017/11/20
 * @describe TODO
 * @package com.example.administrator.checkdevices.network
 */



public interface NetServiceApi {
    @FormUrlEncoded
    @POST("account/login")
    Observable<Res_login2> postlogin(@Field("loginId") String  loginid, @Field("password") String password);

   /* @FormUrlEncoded
    @POST("dataoutput/device/snapshots")
    Observable<ArrayList<DeviceSnapshot>> getDevices(@Field("ids") String  ids);*/

    @FormUrlEncoded
    @POST("device2/find")
    Observable<ResponseBody> getDevices(@Field("ids") String  ids);

   /* @FormUrlEncoded
    @POST("dataoutput/device/snapshots")
    Observable<ResponseBody> getDevices(@Field("ids") String  ids);*/

    @FormUrlEncoded
    @POST("device2/get")
    Observable<ResponseBody> getDeviceInfo(@Field("id") String device_no);


   /* @FormUrlEncoded
    @POST("dataoutput/device/snapshots")
    Observable<ArrayList<DeviceSnapshot>> getDevices(@Field("ids") String  ids);

   *//* @FormUrlEncoded
    @POST("dataoutput/device/snapshots")
    Observable<ResponseBody> getDevices(@Field("ids") String  ids);*//*

    @FormUrlEncoded
    @POST("dataoutput/device/get")
    Observable<Device> getDeviceInfo(@Field("id") String device_no);*/
}
