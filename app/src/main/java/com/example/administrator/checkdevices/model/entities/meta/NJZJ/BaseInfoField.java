package com.example.administrator.checkdevices.model.entities.meta.NJZJ;

/**
 * Created by jialiang on 2018/4/19.
 */

public class BaseInfoField extends com.example.administrator.checkdevices.model.entities.meta.BaseInfoField {
    @Override
    public boolean haveValue(byte hByte, byte lByte) {
        value = (int)lByte;
        return true;
    }
}
