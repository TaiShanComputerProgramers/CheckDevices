package com.example.administrator.checkdevices.model.entities.meta.NJZJ;

/**
 * Created by jialiang on 2018/4/19.
 */

public class ExceptionField extends com.example.administrator.checkdevices.model.entities.meta.ExceptionField {

    @Override
    public boolean haveValue(byte hByte, byte lByte) {
        value = (int) lByte;
        return lByte > 0;
    }

}
