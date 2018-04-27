package com.example.administrator.checkdevices.model.entities.meta.NJZJ;


import com.example.administrator.checkdevices.model.entities.Device_t_NJZJ;
import com.example.administrator.checkdevices.model.entities.meta.DeviceFieldForUI;

/**
 * Created by jialiang on 2018/4/20.
 */

public class SettingField extends MockField {
    @Override
    public void setDeviceFieldForUIKey(DeviceFieldForUI fieldForUI) {
        fieldForUI.setKey(Device_t_NJZJ.KEY_SETTING);
    }
}
