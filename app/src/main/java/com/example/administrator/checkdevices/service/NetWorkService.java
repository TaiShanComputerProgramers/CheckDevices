package com.example.administrator.checkdevices.service;


import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.utils.DeviceAdapterUtil;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * Created by jialiang on 2018/4/19.
 */

public class NetWorkService {


    private String url;
    private HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
    private OkHttpClient client;

    public NetWorkService() {
        client = okHttpClient.build();
        url = "http://39.106.168.77:8082";
    }

    public Device_t getDevice(final String id) {
        FormBody fb = new FormBody.Builder().add("id", id).build();
        Request request = new Request.Builder().url(url + "/device2/get").post(fb).build();
        Device_t device = null;
        try {
            Response response = client.newCall(request).execute();
            byte[] bs = response.body().bytes();
            device = DeviceAdapterUtil.getDeviceByByte(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return device;
    }

    public List<Device_t> getDevices(final String ids) {
        FormBody fb = new FormBody.Builder().add("ids", ids).build();
        Request request = new Request.Builder().url(url + "/device2/find").post(fb).build();
        List<Device_t> devices = null;
        try {
            Response response = client.newCall(request).execute();
            byte[] bs = response.body().bytes();
            devices = DeviceAdapterUtil.getDevicesByByte(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return devices;
    }
}
