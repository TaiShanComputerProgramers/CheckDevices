package com.example.administrator.checkdevices.model.entities.meta;


import com.example.administrator.checkdevices.model.entities.Device_t;


/**
 * Created by jialiang on 2018/4/19.
 */

public abstract class RunDaysField extends ByteField {
    protected Integer days;

    @Override
    public Object getValue() {
        return days;
    }

    @Override
    public void setDeviceFieldForUIKey(DeviceFieldForUI fieldForUI) {
        fieldForUI.setKey(Device_t.KEY_RUN);
    }
}
