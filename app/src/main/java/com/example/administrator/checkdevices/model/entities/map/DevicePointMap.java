package com.example.administrator.checkdevices.model.entities.map;


import com.example.administrator.checkdevices.model.entities.meta.ByteField;

import java.util.HashMap;


/**
 * Created by jialiang on 2018/4/20.
 */

public abstract class DevicePointMap {
    protected HashMap<String,ByteField> map = new HashMap<>();

    public HashMap<String, ByteField> getPointMap() {
        return map;
    }
}
