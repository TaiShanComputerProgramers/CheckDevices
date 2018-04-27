package com.example.administrator.checkdevices.model.entities.meta.NJZJ;

/**
 * Created by jialiang on 2018/4/19.
 */

public class RunDaysField extends com.example.administrator.checkdevices.model.entities.meta.RunDaysField {

    @Override
    public boolean haveValue(byte hByte, byte lByte) {
        days = (lByte & 0xFF) | ((hByte & 0xFF)<<8);
        return true;
    }

}
