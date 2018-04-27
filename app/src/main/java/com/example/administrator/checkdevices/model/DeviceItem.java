package com.example.administrator.checkdevices.model;

import com.example.administrator.checkdevices.interfaces.LayoutItemType;

import java.io.Serializable;


/**
 * Created by Administrator on 2017/8/23.
 */

public class DeviceItem implements LayoutItemType,Serializable {
    //基本状态信息

    private String name;//名称或编号
    private int rl_type;//燃料类型  0-油气 1-电 2-煤  3-生物质
    private int jz_type;//介质类型  0- 热水 1-蒸汽 2-导热油
    private int yx_statu;//运行状态 0-关机 1-待机 2-运行 3-报警
    private int set_statu;// 0-非设定状态 1-设定状态
    private int year;//年
    private int month;//月
    private int day;//日
    private int week;//周
    private int hour;//时
    private int minute;//分
    private int second;//秒



    private int py_wendu;//排烟温度
    private int bj_wendu;//报警温度
    private int tl_wendu;//停炉温度
    private int mb_wendu;//目标温度
    private int ql_wendu;//启炉温度
    private int zh_huicha;//转火回差
    private int ql_huicha;//启炉回差
    private int kb_wendu;//开泵温度
    private int gb_wendu;//关泵温度
    private int bj_yali;//报警压力 显示时除以100  MPA
    private int tl_yali;//停炉压力  MPA
    private int mb_yali;//目标压力  MPA
    private int ql_yali;//启炉压力  MPA
    private int zh_huicha_yali;//转火回差  MPA
    private int ql_huicha_yali;//启炉回差  MPA
    private int qian_yanshi;//前延时 秒
    private int hou_yanshi;//后延时  秒
    private int qian_chuifeng;//前吹扫 秒
    private int hou_chuifeng;//后吹扫 秒
    private int lb_warn_wendu;//炉壁报警温度
    private int lb_chuk_bj_wendu;//炉壁出口报警温度
    private int bh_wendu;//保护温度
    private int py_warn_wendu;//本体排烟温度报警值
    private int qd_time1;//启动时间  时 分   时*60+分
    private int qd_time2;//启动时间  时 分   时*60+分
    private int qd_time3;//启动时间  时 分   时*60+分
    private int qd_time4;//启动时间  时 分   时*60+分
    private int qd_time5;//启动时间  时 分   时*60+分
    private int qd_time6;//启动时间  时 分   时*60+分
    private String currentTime;//当前时间
    private String warn_message;

    public String getWarn_message() {
        return warn_message;
    }

    public void setWarn_message(String warn_message) {
        this.warn_message = warn_message;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getRl_type() {
        return rl_type;
    }

    public void setRl_type(int rl_type) {
        this.rl_type = rl_type;
    }

    public int getJz_type() {
        return jz_type;
    }

    public void setJz_type(int jz_type) {
        this.jz_type = jz_type;
    }

    public int getYx_statu() {
        return yx_statu;
    }

    public void setYx_statu(int yx_statu) {
        this.yx_statu = yx_statu;
    }

    public int getSet_statu() {
        return set_statu;
    }

    public void setSet_statu(int set_statu) {
        this.set_statu = set_statu;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getPy_wendu() {
        return py_wendu;
    }

    public void setPy_wendu(int py_wendu) {
        this.py_wendu = py_wendu;
    }

    public int getBj_wendu() {
        return bj_wendu;
    }

    public void setBj_wendu(int bj_wendu) {
        this.bj_wendu = bj_wendu;
    }

    public int getTl_wendu() {
        return tl_wendu;
    }

    public void setTl_wendu(int tl_wendu) {
        this.tl_wendu = tl_wendu;
    }

    public int getMb_wendu() {
        return mb_wendu;
    }

    public void setMb_wendu(int mb_wendu) {
        this.mb_wendu = mb_wendu;
    }

    public int getQl_wendu() {
        return ql_wendu;
    }

    public void setQl_wendu(int ql_wendu) {
        this.ql_wendu = ql_wendu;
    }

    public int getZh_huicha() {
        return zh_huicha;
    }

    public void setZh_huicha(int zh_huicha) {
        this.zh_huicha = zh_huicha;
    }

    public int getQl_huicha() {
        return ql_huicha;
    }

    public void setQl_huicha(int ql_huicha) {
        this.ql_huicha = ql_huicha;
    }

    public int getKb_wendu() {
        return kb_wendu;
    }

    public void setKb_wendu(int kb_wendu) {
        this.kb_wendu = kb_wendu;
    }

    public int getGb_wendu() {
        return gb_wendu;
    }

    public void setGb_wendu(int gb_wendu) {
        this.gb_wendu = gb_wendu;
    }

    public int getBj_yali() {
        return bj_yali;
    }

    public void setBj_yali(int bj_yali) {
        this.bj_yali = bj_yali;
    }

    public int getTl_yali() {
        return tl_yali;
    }

    public void setTl_yali(int tl_yali) {
        this.tl_yali = tl_yali;
    }

    public int getMb_yali() {
        return mb_yali;
    }

    public void setMb_yali(int mb_yali) {
        this.mb_yali = mb_yali;
    }

    public int getQl_yali() {
        return ql_yali;
    }

    public void setQl_yali(int ql_yali) {
        this.ql_yali = ql_yali;
    }

    public int getZh_huicha_yali() {
        return zh_huicha_yali;
    }

    public void setZh_huicha_yali(int zh_huicha_yali) {
        this.zh_huicha_yali = zh_huicha_yali;
    }

    public int getQl_huicha_yali() {
        return ql_huicha_yali;
    }

    public void setQl_huicha_yali(int ql_huicha_yali) {
        this.ql_huicha_yali = ql_huicha_yali;
    }

    public int getQian_yanshi() {
        return qian_yanshi;
    }

    public void setQian_yanshi(int qian_yanshi) {
        this.qian_yanshi = qian_yanshi;
    }

    public int getHou_yanshi() {
        return hou_yanshi;
    }

    public void setHou_yanshi(int hou_yanshi) {
        this.hou_yanshi = hou_yanshi;
    }

    public int getQian_chuifeng() {
        return qian_chuifeng;
    }

    public void setQian_chuifeng(int qian_chuifeng) {
        this.qian_chuifeng = qian_chuifeng;
    }

    public int getHou_chuifeng() {
        return hou_chuifeng;
    }

    public void setHou_chuifeng(int hou_chuifeng) {
        this.hou_chuifeng = hou_chuifeng;
    }

    public int getLb_warn_wendu() {
        return lb_warn_wendu;
    }

    public void setLb_warn_wendu(int lb_warn_wendu) {
        this.lb_warn_wendu = lb_warn_wendu;
    }

    public int getLb_chuk_bj_wendu() {
        return lb_chuk_bj_wendu;
    }

    public void setLb_chuk_bj_wendu(int lb_chuk_bj_wendu) {
        this.lb_chuk_bj_wendu = lb_chuk_bj_wendu;
    }

    public int getBh_wendu() {
        return bh_wendu;
    }

    public void setBh_wendu(int bh_wendu) {
        this.bh_wendu = bh_wendu;
    }

    public int getPy_warn_wendu() {
        return py_warn_wendu;
    }

    public void setPy_warn_wendu(int py_warn_wendu) {
        this.py_warn_wendu = py_warn_wendu;
    }

    public int getQd_time1() {
        return qd_time1;
    }

    public void setQd_time1(int qd_time1) {
        this.qd_time1 = qd_time1;
    }

    public int getQd_time2() {
        return qd_time2;
    }

    public void setQd_time2(int qd_time2) {
        this.qd_time2 = qd_time2;
    }

    public int getQd_time3() {
        return qd_time3;
    }

    public void setQd_time3(int qd_time3) {
        this.qd_time3 = qd_time3;
    }

    public int getQd_time4() {
        return qd_time4;
    }

    public void setQd_time4(int qd_time4) {
        this.qd_time4 = qd_time4;
    }

    public int getQd_time5() {
        return qd_time5;
    }

    public void setQd_time5(int qd_time5) {
        this.qd_time5 = qd_time5;
    }

    public int getQd_time6() {
        return qd_time6;
    }

    public void setQd_time6(int qd_time6) {
        this.qd_time6 = qd_time6;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    /*@Override
    public boolean equals(Object obj) {
        if(!(obj instanceof DeviceItem))return false;
        if(obj==this)return true;
        DeviceItem tree=(DeviceItem)obj;
        if(this.getAddress()==tree.getAddress())return true;
        return false;
    }*/
    public void setValue(DeviceItem item1,DeviceItem item2){
        item1.setCurrentTime(item2.getCurrentTime());
        item1.setYx_statu(item2.getYx_statu());
    }
}
