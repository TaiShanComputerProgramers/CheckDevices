package com.example.administrator.checkdevices.utils;

import com.example.administrator.checkdevices.model.login_devices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */

public class Constant {
//    public static String sql_url="192.168.1.105";
//    public static String sql_url="http://39.106.168.77:8082/";
//    public static String sql_url="http://39.106.168.77:8082/";
    public  static String sql_url="http://39.106.168.77:8082";//接口ip地址
    public static String getVersionUrl="http://39.106.168.77:8082/app/gl/version.txt";//版本更新地址
    public static String  downUrl="http://39.106.168.77:8082/app/gl/gl.apk";//版本下载地址
    public static  long fasong_jiange=6;//秒
    public static  int warn_type=0;//1震动 2 响铃 3 响铃+震动 0 不报警
    public static String cookie="";//cookie
    public static List<String> devices=new ArrayList<>();
    public static String user_name="admin";
    public  static  String tel="17117026888";

}
