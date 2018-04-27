package com.example.administrator.checkdevices.utils;


import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.model.entities.map.DevicePointMap;
import com.example.administrator.checkdevices.model.entities.meta.ByteField;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by jialiang on 2018/4/20.
 */

public class DeviceAdapterUtil {
    private static final int BYTE_LENGTH = 1024;

    public static List<Device_t> getDevicesByByte(byte[] bytes) {
        if (null == bytes || bytes.length < BYTE_LENGTH) {
            //数据不完整
            return null;
        }
        List<Device_t> list = null;
        if (BYTE_LENGTH == bytes.length) {
            list = new ArrayList<>(1);
            list.add(getDeviceByByte(bytes));
        } else {
            int count = bytes.length / BYTE_LENGTH;
            list = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                byte[] sub = new byte[BYTE_LENGTH];
                for (int j = 0; j < BYTE_LENGTH; j++) {
                    sub[j] = bytes[j + i * BYTE_LENGTH];
                }
                list.add(getDeviceByByte(sub));
            }
        }
        return list;
    }

    public static Device_t getDeviceByByte(byte[] bytes) {
        if (null == bytes || bytes.length < BYTE_LENGTH) {
            //数据不完整
            return null;
        }
        Device_t device = null;

        String s=new String (bytes,0,1024);


        String deviceNo = new String(bytes, 0, 20);
        String str = deviceNo.substring(4, 10);
        if (str.startsWith("00")) {
            str = str.substring(2, 6);
        } else if (str.startsWith("0")) {
            str = str.substring(1, 6);
        }
        try {
            Class clazz = Class.forName(String.format(Locale.CHINA, "com.example.administrator.checkdevices.model.entities.Device_t_%s", str));
            device = (Device_t) clazz.newInstance();
            device.setDeviceNo(deviceNo);
            clazz = Class.forName(String.format(Locale.CHINA, "com.example.administrator.checkdevices.model.entities.map.DevicePointMap_%s", str));
            DevicePointMap devicePointMap = (DevicePointMap) clazz.newInstance();

            for (String key : devicePointMap.getPointMap().keySet()) {
                ByteField f = devicePointMap.getPointMap().get(key);
                if (f.haveValue(bytes[f.getStartIndex() + 1], bytes[f.getStartIndex()])) {
                    device.AddField(f.getDeviceFieldForUI());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return device;
    }
}
