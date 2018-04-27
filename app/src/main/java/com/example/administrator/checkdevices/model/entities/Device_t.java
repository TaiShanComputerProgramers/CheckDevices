package com.example.administrator.checkdevices.model.entities;



import com.example.administrator.checkdevices.interfaces.LayoutItemType;
import com.example.administrator.checkdevices.model.entities.meta.DeviceFieldForUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by jialiang on 2018/4/19.
 */

public abstract class Device_t implements LayoutItemType,Serializable {
    public static final String KEY_BASE="baseInfo";
    public static final String KEY_RUN="runInfo";
    public static final String KEY_EXCEPTION="exceptionInfo";
    public static final String KEY_MOCK ="mockInfo";
    public static final String KEY_SETTING ="settingInfo";
    public static final String KEY_START_STOP ="startStopInfo";
    public static final String KEY_DEVICE ="deviceInfo";

    protected HashMap<String,ArrayList<DeviceFieldForUI>> fieldMap = new HashMap<>();
    private String deviceNo;
    private String NickName;
    private int runDays;
    private long ComeDate;
    private int runstatus;

    public HashMap<String, ArrayList<DeviceFieldForUI>> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(HashMap<String, ArrayList<DeviceFieldForUI>> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }



    public int getRunDays() {
        return runDays;
    }

    public void setRunDays(int runDays) {
        this.runDays = runDays;
    }



    public abstract int getExceptionCount();

    public abstract void AddField(DeviceFieldForUI field);

    public List<DeviceFieldForUI> getFieldsByGroupKey(String key) {
        if (fieldMap.containsKey(key))
            return fieldMap.get(key);
        return null;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public long getComeDate() {
        return ComeDate;
    }

    public void setComeDate(long comeDate) {
        ComeDate = comeDate;
    }

    public int getRunstatus() {
        return runstatus;
    }

    public void setRunstatus(int runstatus) {
        this.runstatus = runstatus;
    }

    /**
     * 获取设备基本信息
     * @return
     */
//    public abstract List<DeviceFieldForUI> getBaseDeviceInfo();

    public abstract HashMap<String,DeviceFieldForUI> getBaseDeviceInfo();


    /**
     * 获取设备信息
     */
    public abstract HashMap<String,DeviceFieldForUI> getDeviceFiled();
    /**
     * 获取异常信息
     */
    public abstract HashMap<String,DeviceFieldForUI> getExceptionFiled();

    /**
     * 获取mock
     */
    public abstract HashMap<String,DeviceFieldForUI> getMockFiled();

    /**
     * 获取运行信息
     */
    public abstract HashMap<String,DeviceFieldForUI> getRunDaysField();

    /**
     * 获取设置信息
     */
    public abstract HashMap<String,DeviceFieldForUI> getSettingFiled();

    /**
     * 获取启停信息
     */
    public abstract HashMap<String,DeviceFieldForUI> getStartStopField();

    public abstract void setValue(Device_t item1,Device_t item2);
    /**
     * 获取设备关注信息
     * @return
     *//*
    public abstract List<DeviceFieldForUI> getDeviceFocusInfo();

    *//**
     * 获取设备异常信息
     * @return
     *//*
    public  abstract List<DeviceFieldForUI> getExceptionInfo();*/
}
