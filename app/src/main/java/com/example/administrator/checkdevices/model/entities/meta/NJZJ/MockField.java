package com.example.administrator.checkdevices.model.entities.meta.NJZJ;

import java.math.BigInteger;

/**
 * Created by jialiang on 2018/4/19.
 */

public class MockField extends com.example.administrator.checkdevices.model.entities.meta.MockField {

    @Override
    public boolean haveValue(byte hByte, byte lByte) {
        BigInteger value = new BigInteger(new byte[]{hByte,lByte});
        if(0x7FFF == value.intValue())
            return false;

        if(null != getBaseNumber() && getBaseNumber() > 0)
            data = value.floatValue()/getBaseNumber();
        else
            data = value.floatValue();
        return true;
    }

}
