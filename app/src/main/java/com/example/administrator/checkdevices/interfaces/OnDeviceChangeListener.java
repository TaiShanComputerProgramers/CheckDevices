package com.example.administrator.checkdevices.interfaces;

import com.example.administrator.checkdevices.model.DeviceItem;
import com.example.administrator.checkdevices.model.DeviceSnapshot;
import com.example.administrator.checkdevices.model.entities.Device_t;

import java.util.List;


/**
 * Created by Sai on 15/8/9.
 */
public interface OnDeviceChangeListener {
    public void onDeviceResh(DeviceSnapshot deviceItem);
    public void onDeviceResh(Device_t deviceItem);
}
