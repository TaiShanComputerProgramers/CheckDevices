package com.example.administrator.checkdevices.model.entities.meta;


import com.example.administrator.checkdevices.model.entities.Device_t;

import java.util.Locale;


/**
 * Created by jialiang on 2018/4/20.
 */

public abstract class DeviceField extends ByteField {
    protected StringBuilder sb = new StringBuilder();
    protected int value = 0;

    @Override
    public Object getValue() {
        return String.format(Locale.CHINA,"%s %d",sb.toString(),value);
    }

    @Override
    public void setDeviceFieldForUIKey(DeviceFieldForUI fieldForUI) {
        fieldForUI.setKey(Device_t.KEY_DEVICE);
    }


}
