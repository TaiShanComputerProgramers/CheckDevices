package com.example.administrator.checkdevices.model.entities;


import com.example.administrator.checkdevices.interfaces.LayoutItemType;
import com.example.administrator.checkdevices.model.entities.meta.DeviceFieldForUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Created by jialiang on 2018/4/20.
 */

public class Device_t_NJZJ extends Device_t{
    public static String getFiledKey(String str){
        if(str.startsWith("ba"))
            return KEY_BASE;
        if(str.startsWith("ex"))
            return KEY_EXCEPTION;
        if (str.startsWith("mo"))
            return KEY_MOCK;
        if (str.startsWith("se"))
            return KEY_SETTING;
        if(str.startsWith("de"))
            return KEY_DEVICE;
        if(str.startsWith("ru"))
            return KEY_RUN;
        if(str.startsWith("st"))
            return KEY_START_STOP;
        return "";
    }
    public Device_t_NJZJ(){
        fieldMap.put(KEY_BASE,new ArrayList<DeviceFieldForUI>());
        fieldMap.put(KEY_RUN,new ArrayList<DeviceFieldForUI>());
        fieldMap.put(KEY_EXCEPTION,new ArrayList<DeviceFieldForUI>());
        fieldMap.put(KEY_MOCK,new ArrayList<DeviceFieldForUI>());
        fieldMap.put(KEY_SETTING,new ArrayList<DeviceFieldForUI>());
        fieldMap.put(KEY_DEVICE,new ArrayList<DeviceFieldForUI>());
        fieldMap.put(KEY_START_STOP,new ArrayList<DeviceFieldForUI>());
    }

    @Override
    public void AddField(DeviceFieldForUI field) {
        if(fieldMap.containsKey(field.getKey()))
            fieldMap.get(field.getKey()).add(field);
    }

  /*  @Override
    public List<DeviceFieldForUI> getBaseDeviceInfo() {
        return fieldMap.get(KEY_BASE);
    }*/


    @Override
    public HashMap<String, DeviceFieldForUI> getBaseDeviceInfo() {
        HashMap<String,DeviceFieldForUI> map=new HashMap<>();
        List<DeviceFieldForUI> list=fieldMap.get(KEY_BASE);
        for(int i=0;i<list.size();i++){
            DeviceFieldForUI deviceFieldForUI=list.get(i);
            map.put(deviceFieldForUI.getName(),deviceFieldForUI);
        }
        return map;
    }

  /*  @Override
    public List<DeviceFieldForUI> getDeviceFocusInfo() {
        return null;
    }

    @Override
    public List<DeviceFieldForUI> getExceptionInfo() {
        return null;
    }*/

    @Override
    public HashMap<String, DeviceFieldForUI> getDeviceFiled() {
        HashMap<String,DeviceFieldForUI> map=new HashMap<>();
        List<DeviceFieldForUI> list=fieldMap.get(KEY_DEVICE);
        for(int i=0;i<list.size();i++){
            DeviceFieldForUI deviceFieldForUI=list.get(i);
            map.put(deviceFieldForUI.getName(),deviceFieldForUI);
        }
        return map;
    }

    @Override
    public HashMap<String, DeviceFieldForUI> getExceptionFiled() {
        HashMap<String,DeviceFieldForUI> map=new HashMap<>();
        List<DeviceFieldForUI> list=fieldMap.get(KEY_EXCEPTION);
        for(int i=0;i<list.size();i++){
            DeviceFieldForUI deviceFieldForUI=list.get(i);
            map.put(deviceFieldForUI.getName(),deviceFieldForUI);
        }
        return map;
    }

    @Override
    public HashMap<String, DeviceFieldForUI> getMockFiled() {
        HashMap<String,DeviceFieldForUI> map=new HashMap<>();
        List<DeviceFieldForUI> list=fieldMap.get(KEY_MOCK);
        for(int i=0;i<list.size();i++){
            DeviceFieldForUI deviceFieldForUI=list.get(i);
            map.put(deviceFieldForUI.getName(),deviceFieldForUI);
        }
        return map;
    }

    @Override
    public HashMap<String, DeviceFieldForUI> getRunDaysField() {
        HashMap<String,DeviceFieldForUI> map=new HashMap<>();
        List<DeviceFieldForUI> list=fieldMap.get(KEY_RUN);
        for(int i=0;i<list.size();i++){
            DeviceFieldForUI deviceFieldForUI=list.get(i);
            map.put(deviceFieldForUI.getName(),deviceFieldForUI);
        }
        return map;
    }

    @Override
    public HashMap<String, DeviceFieldForUI> getSettingFiled() {
        HashMap<String,DeviceFieldForUI> map=new HashMap<>();
        List<DeviceFieldForUI> list=fieldMap.get(KEY_SETTING);
        for(int i=0;i<list.size();i++){
            DeviceFieldForUI deviceFieldForUI=list.get(i);
            map.put(deviceFieldForUI.getName(),deviceFieldForUI);
        }
        return map;
    }

    @Override
    public HashMap<String, DeviceFieldForUI> getStartStopField() {
        HashMap<String,DeviceFieldForUI> map=new HashMap<>();
        List<DeviceFieldForUI> list=fieldMap.get(KEY_START_STOP);
        for(int i=0;i<list.size();i++){
            DeviceFieldForUI deviceFieldForUI=list.get(i);
            map.put(deviceFieldForUI.getName(),deviceFieldForUI);
        }
        return map;
    }

    @Override
    public int getExceptionCount() {
        return fieldMap.get(KEY_EXCEPTION).size();
    }
    @Override
    public void setValue(Device_t item1, Device_t item2){
//        item1.setNickName(item2.getNickName());

        HashMap<String, ArrayList<DeviceFieldForUI>> map2=item2.getFieldMap();
        item1.setFieldMap(map2);
        /*HashMap<String,DeviceFieldForUI> map_ss1=item1.getStartStopField();
        HashMap<String,DeviceFieldForUI> map_ss2=item1.getStartStopField();
*/

    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}
