package com.example.administrator.checkdevices.model.entities.meta;

/**
 * Created by jialiang on 2018/4/19.
 */

public abstract class ByteField {
    private String name;
    private String unit;
    private String title;
    private Integer startIndex ,bytesLength,baseNumber;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public abstract Object getValue();
    public abstract boolean haveValue(byte hByte, byte lByte);
    public abstract void setDeviceFieldForUIKey(DeviceFieldForUI fieldForUI);


    public DeviceFieldForUI getDeviceFieldForUI() {
        DeviceFieldForUI fieldForUI = new DeviceFieldForUI();
        setDeviceFieldForUIKey(fieldForUI);
        fieldForUI.setName(getName());
        fieldForUI.setTitle(getTitle());
        fieldForUI.setValue(null== getValue()?"": getValue().toString());
        return fieldForUI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getBytesLength() {
        return bytesLength;
    }

    public void setBytesLength(Integer bytesLength) {
        this.bytesLength = bytesLength;
    }

    public Integer getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(Integer baseNumber) {
        this.baseNumber = baseNumber;
    }

    public static ByteField Init(ByteField field, String name, int startIndex, int bytesLength, String title){
        field.setName(name);
        field.setStartIndex(startIndex);
        field.setBytesLength(bytesLength);
        field.setTitle(title);
        return field;
    }
    public static ByteField Init(ByteField field, String name, int startIndex, int bytesLength, String title, String unit){
        Init(field,name,startIndex,bytesLength,title);
        field.setUnit(unit);
        return field;
    }
    public static ByteField Init(ByteField field, String name, int startIndex, int bytesLength, String title, String unit, int baseNumber){
        Init(field,name,startIndex,bytesLength,title,unit);
        field.setBaseNumber(baseNumber);
        return field;
    }
}
