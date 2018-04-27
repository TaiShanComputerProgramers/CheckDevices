package com.example.administrator.checkdevices.model.entities.meta;


import com.example.administrator.checkdevices.model.entities.Device_t;


/**
 * Created by jialiang on 2018/4/20.
 */

public abstract class StartStopField extends ByteField {
    @Override
    public Object getValue() {
        return null;
    }
    @Override
    public void setDeviceFieldForUIKey(DeviceFieldForUI fieldForUI) {
        fieldForUI.setKey(Device_t.KEY_START_STOP);
    }
}
