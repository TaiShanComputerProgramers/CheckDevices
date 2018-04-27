package com.example.administrator.checkdevices.model.entities.meta;


import com.example.administrator.checkdevices.model.entities.Device_t;

/**
 * Created by jialiang on 2018/4/19.
 */

public abstract class BaseInfoField extends ByteField {
    protected Integer value;
    @Override
    public Object getValue() {
        if (0 > value)
            value &= 0xFF;
        return value;
    }

    @Override
    public void setDeviceFieldForUIKey(DeviceFieldForUI fieldForUI) {
        fieldForUI.setKey(Device_t.KEY_BASE);
    }
}
