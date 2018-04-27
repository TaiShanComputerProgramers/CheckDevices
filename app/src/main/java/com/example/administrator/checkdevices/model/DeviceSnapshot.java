package com.example.administrator.checkdevices.model;

/**
 * Created by wd on 2018/1/23.
 *
 * @author wd
 * @date 2018/1/23
 * @describe TODO
 * @package com.example.administrator.checkdevices.model
 */

import com.example.administrator.checkdevices.interfaces.LayoutItemType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 设备信息快照实体
 */
public class DeviceSnapshot implements LayoutItemType ,Serializable{
    private String deviceNo;

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private String nickName;
    private float focusItem1, focusItem2, focusItem3;
    private long comeDate;
    //燃料类型
    private int power;

    //
    private String focusItem1Text,focusItem2Text,focusItem3Text;

    public String getFocusItem1Text() {
        return focusItem1Text;
    }

    public void setFocusItem1Text(String focusItem1Text) {
        this.focusItem1Text = focusItem1Text;
    }

    public String getFocusItem2Text() {
        return focusItem2Text;
    }

    public void setFocusItem2Text(String focusItem2Text) {
        this.focusItem2Text = focusItem2Text;
    }

    public String getFocusItem3Text() {
        return focusItem3Text;
    }

    public void setFocusItem3Text(String focusItem3Text) {
        this.focusItem3Text = focusItem3Text;
    }

    /**
     * 获取燃料类型
     *
     * @return power
     */
    public int getPower() {
        return power;
    }

    /**
     * 设置燃料类型
     *
     * @param data
     */
    public void setPower(int data) {
        power = data;
    }

    //介质类型
    private int media;

    /**
     * 获取介质类型
     *
     * @return power
     */
    public int getMedia() {
        return media;
    }

    /**
     * 设置介质类型
     *
     * @param data
     */
    public void setMedia(int data) {
        media = data;
    }

    //运行状态
    private int runstatus;

    /**
     * 获取运行状态
     *
     * @return power
     */
    public int getRunstatus() {
        return runstatus;
    }

    /**
     * 设置运行状态
     *
     * @param data
     */
    public void setRunstatus(int data) {
        runstatus = data;
    }

    public long getComeDate() {
        return comeDate;
    }

    public void setComeDate(long comeDate) {
        this.comeDate = comeDate;
    }

    public int getAlarm() {
        return alarm;
    }

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    //报警数量
    private int alarm;
    //故障数量
    private int error;

    //设备运行天数
    private int runDays;
    //设备运行小时数
    private int runHours;

    public int getRunDays() {
        return runDays;
    }

    public void setRunDays(int runDays) {
        this.runDays = runDays;
    }

    public int getRunHours() {
        return runHours;
    }

    public void setRunHours(int runHours) {
        this.runHours = runHours;
    }

    public float getFocusItem1() {
        return focusItem1;
    }

    public void setFocusItem1(float focusItem1) {
        this.focusItem1 = focusItem1;
    }

    public float getFocusItem2() {
        return focusItem2;
    }

    public void setFocusItem2(float focusItem2) {
        this.focusItem2 = focusItem2;
    }

    public float getFocusItem3() {
        return focusItem3;
    }

    public void setFocusItem3(float focusItem3) {
        this.focusItem3 = focusItem3;
    }

    public static List<DeviceSnapshot> getDeviceSnapshotList(List<Device> devices){
        ArrayList<DeviceSnapshot> ls = new ArrayList<>(devices.size());
        for (Device d : devices){
            ls.add(d.getSnapshot());
        }
        return ls;
    }

    public static DeviceSnapshot getDeviceSnapshot(Device device){
        DeviceSnapshot snapshot = new DeviceSnapshot();
        snapshot.deviceNo = device.getDeviceNo();
//        snapshot.comeDate = device.getComeDate();
        snapshot.power = device.getPower();
        snapshot.media = device.getMedia();
        snapshot.nickName = device.getNickName();
        snapshot.runDays = device.getRunDays();
        snapshot.runHours = device.getRunHours();
        snapshot.runstatus = device.getRunstatus();
        snapshot.focusItem1 = device.getFocusItem1();
        snapshot.focusItem2 = device.getFocusItem2();
        snapshot.focusItem3 = device.getFocusItem3();
        snapshot.alarm = device.getAlarmCount();
        snapshot.error = device.getErrorCount();
        return snapshot;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }
    public void setValue(DeviceSnapshot item1,DeviceSnapshot item2){
        item1.setNickName(item2.getNickName());
        item1.setComeDate(item2.getComeDate());
        item1.setRunstatus(item2.getRunstatus());
        item1.setFocusItem1(item2.getFocusItem1());
        item1.setFocusItem2(item2.getFocusItem2());
        item1.setFocusItem3(item2.getFocusItem3());
        item1.setAlarm(item2.getAlarm());
        item1.setPower(item2.getPower());
        item1.setMedia(item2.getMedia());
        item1.setError(item2.getError());
        item1.setRunDays(item2.getRunDays());
        item1.setRunHours(item2.getRunHours());
        item1.setFocusItem1Text(item2.getFocusItem1Text());
        item1.setFocusItem2Text(item2.getFocusItem2Text());
        item1.setFocusItem3Text(item2.getFocusItem3Text());
    }
}
