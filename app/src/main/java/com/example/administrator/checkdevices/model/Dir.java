package com.example.administrator.checkdevices.model;


import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.interfaces.LayoutItemType;

import java.io.Serializable;


/**
 * Created by tlh on 2016/10/1 :)
 */

public class Dir implements LayoutItemType,Serializable {
    public String dirName;

    public Dir(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_dir;
    }
}
