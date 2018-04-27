package com.example.administrator.checkdevices.model.entities.meta;


import com.example.administrator.checkdevices.model.entities.Device_t;

import java.util.Locale;


/**
 * Created by jialiang on 2018/4/19.
 */

public abstract class MockField extends ByteField {
    protected Float data;
    @Override
    public Object getValue() {
        return String.format(Locale.CHINA, "%.2f %s",data,getUnit());
    }


    @Override
    public void setDeviceFieldForUIKey(DeviceFieldForUI fieldForUI) {
        fieldForUI.setKey(Device_t.KEY_MOCK);
    }
}
