package com.example.administrator.checkdevices.model;

/**
 * Created by wd on 2018/1/23.
 *
 * @author wd
 * @date 2018/2/12
 * @describe TODO
 * @package com.example.administrator.checkdevices.model
 */

import com.example.administrator.checkdevices.interfaces.LayoutItemType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 设备信息快照实体
 */
public class login_devices implements LayoutItemType ,Serializable{
    private int id;
    private int enterpriseId;
    private int manufacturerId;
    private int status;
    private int runStatus;
    private String deviceNo;
    private String nickName;
    private long imporDatetime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(int runStatus) {
        this.runStatus = runStatus;
    }

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

    public long getImporDatetime() {
        return imporDatetime;
    }

    public void setImporDatetime(long imporDatetime) {
        this.imporDatetime = imporDatetime;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}
