package com.example.administrator.checkdevices.model.entities.meta.NJZJ;

import java.math.BigInteger;

/**
 * Created by jialiang on 2018/4/20.
 */

public class StartStopField extends com.example.administrator.checkdevices.model.entities.meta.StartStopField {

    @Override
    public boolean haveValue(byte hByte, byte lByte) {
        BigInteger value = new BigInteger(new byte[]{hByte,lByte});
        return  0x7FFF != value.intValue();
    }

}
