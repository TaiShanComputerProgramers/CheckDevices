package com.example.administrator.checkdevices.model.entities.meta;

import java.io.Serializable;

/**
 * Created by jialiang on 2018/4/20.
 */

public class DeviceFieldForUI implements Serializable{
    private String name;
    private String value;
    private String key;
    private String title;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
