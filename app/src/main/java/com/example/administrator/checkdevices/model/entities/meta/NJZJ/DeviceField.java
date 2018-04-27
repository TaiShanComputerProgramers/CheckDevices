package com.example.administrator.checkdevices.model.entities.meta.NJZJ;

/**
 * Created by jialiang on 2018/4/20.
 */

public class DeviceField extends com.example.administrator.checkdevices.model.entities.meta.DeviceField {

    @Override
    public boolean haveValue(byte hByte, byte lByte) {
        int i = (lByte & 0xFF) | (hByte & 0xFF) << 8;

        if (0x7FFF == i)
            return false;

        if (0xC0 == (hByte & 0xC0))
            sb.append("手/");
        else
            sb.append("自/");
        if (0x30 == (hByte & 0x30))
            sb.append("备/");
        else
            sb.append("主/");
        if (0x0F == (hByte & 0x0F))
            sb.append("启");
        else
            sb.append("停");
        value = lByte & 0xFF;

        return true;
    }


}
