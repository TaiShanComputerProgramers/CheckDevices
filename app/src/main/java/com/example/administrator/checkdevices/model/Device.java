package com.example.administrator.checkdevices.model;

import com.example.administrator.checkdevices.model.entities.meta.ByteField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wd on 2018/1/23.
 *
 * @author wd
 * @date 2018/1/23
 * @describe TODO
 * @package com.example.administrator.checkdevices.model
 */

public class Device implements Serializable {
    //设备基本信息
    /*private String ba_yunxingzhuangtai;//运行状态
    private String ba_yunxingxiaoshishu;//运行小时数
    private String ba_ranliaoleixing;//燃料类型
    private String ba_jiezhileixing;//介质类型
    private String ba_guolushuiweizhuangtai;//锅炉水位状态
    private String ba_shuixiangshuiweizhuangtai;//水箱水位状态
    private String ba_guoluyalizhuangtai;//锅炉压力状态
    private String ba_shuixiangshuiweizhuangtai;//水箱水位状态
    private String ba_shuixiangshuiweizhuangtai;//水箱水位状态
    private String ba_shuixiangshuiweizhuangtai;//水箱水位状态
    private String ba_shuixiangshuiweizhuangtai;//水箱水位状态
    private String ba_shuixiangshuiweizhuangtai;//水箱水位状态

    ba_yunxingxiaoshishu

    //设备运行信息
    private String ru_yunxingtianshu;//运行天数

    //异常信息
    private String ex_paiyanwendugaobaojing;//排烟温度高报警
    private String ex_lushuiwendugaobaojing;//炉水温度高报警
    private String ex_chukouwendugaobaojing;//出口温度高报警
    private String ex_chaoyabaojing;//超压报警
    private String ex_jixiandishuiweibaojing;//极限低水位报警
    private String ex_dishuiweibaojing;//低水位报警
    private String ex_gaoshuiweibaojing;//高水位报警
    private String ex_shuiweixinhaoluojicuobaojing;//水位信号逻辑错报警
    private String ex_lubiwendugaobaojing;//炉壁温度高报警
    private String ex_fuyazhengqiwendugaobaojing;//负压蒸汽温度高报警
    private String ex_ranshaoqiguzhangbaojing;//燃烧器故障报警
    private String ex_ranqixieloubaojing;//燃气泄漏报警
    private String ex_ranqiyalidibaojing;//燃气压力低报警
    private String ex_ranqiyaliyichangbaojing;//燃气压力异常报警
    private String ex_ranqiyaligaobaojing;//燃气压力高报警
    private String ex_jishuibianpinqiguzhangbaojing;//给水变频器故障报警
    private String ex_xunhuanbianpinqiguzhangbaojing;//循环变频器故障报警
    private String ex_yinfengbianpinqiguzhangbaojing;//引风变频器故障报警
    private String ex_gufengbianpinqiguzhangbaojing;//鼓风变频器故障报警
    private String ex_ecigufengbianpinqiguzhangbaojing;//二次鼓风变频器故障报警
    private String ex_lupaibianpinqiguzhangbaojing;//炉排变频器故障报警
    private String ex_jishuibengguzhangbaojing;//给水泵故障报警
    private String ex_xunhuanbengguzhangbaojing;//循环泵故障报警
    private String ex_qianyabaojing;//欠压报警
    private String ex_didianyabaojing;//低电压报警
    private String ex_gaodianyabaojing;//高电压报警
    private String ex_quexiangbaojing;//缺相报警
    private String ex_loudianbaojing;//漏电报警

    private String ex_biansongqiguoyabaohu;//变送器过压保护
    private String ex_guanjiancanshuyichang;//关键参数异常
    private String ex_shedingcanshuyichang;//设定参数异常
    private String ex_shizhongguzhang;//时钟故障
    private String ex_cunchuqiguzhang;//存储器故障
    private String ex_waibuliansuobaojing;//外部连锁报警
    private String ex_queyoubaojing;//缺油报警
    private String ex_diyouweibaojing;//低油位报警
    private String ex_bentipaiyanwendugaobaojing;//本体排烟温度高报警
    private String ru_yunxingtianshu;//运行天数
    private String ru_yunxingtianshu;//运行天数
    private String ru_yunxingtianshu;//运行天数





        map.put("ex_diyouweibaojing", ByteField.Init(new ExceptionField(), "ex_diyouweibaojing", 67,1,"低油位报警"));

        map.put("ex_bentipaiyanwendugaobaojing", ByteField.Init(new ExceptionField(), "ex_bentipaiyanwendugaobaojing", 68,1,"本体排烟温度高报警"));

        map.put("ex_bianpinqiguzhangbaojing", ByteField.Init(new ExceptionField(), "ex_bianpinqiguzhangbaojing", 69,1,"变频器故障报警"));

        map.put("ex_meishuiwendugaobaojing", ByteField.Init(new ExceptionField(), "ex_meishuiwendugaobaojing", 70,1,"媒水温度高报警"));

        map.put("ex_1haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_1haoguoluguzhang", 71,1,"1号锅炉故障"));

        map.put("ex_2haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_2haoguoluguzhang", 72,1,"2号锅炉故障"));

        map.put("ex_3haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_3haoguoluguzhang", 73,1,"3号锅炉故障"));

        map.put("ex_4haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_4haoguoluguzhang", 74,1,"4号锅炉故障"));

        map.put("ex_5haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_5haoguoluguzhang", 75,1,"5号锅炉故障"));

        map.put("ex_6haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_6haoguoluguzhang", 76,1,"6号锅炉故障"));

        map.put("ex_7haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_7haoguoluguzhang", 77,1,"7号锅炉故障"));

        map.put("ex_8haoguoluguzhang", ByteField.Init(new ExceptionField(), "ex_8haoguoluguzhang", 78,1,"8号锅炉故障"));

        map.put("ex_bushuibianpinqiguzhangbaojing", ByteField.Init(new ExceptionField(), "ex_bushuibianpinqiguzhangbaojing", 79,1,"补水变频器故障报警"));

        map.put("ex_shuiliukaiguanbaohubaojing", ByteField.Init(new ExceptionField(), "ex_shuiliukaiguanbaohubaojing", 80,1,"水流开关保护报警"));

        map.put("ex_rukouwendudibaojing", ByteField.Init(new ExceptionField(), "ex_rukouwendudibaojing", 81,1,"入口温度低报警"));

        map.put("ex_xunhuanbengbianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_xunhuanbengbianpinqiguzhang", 82,1,"循环泵变频器故障"));

        map.put("ex_ecixunhuanbengbianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_ecixunhuanbengbianpinqiguzhang", 83,1,"二次循环泵变频器故障"));

        map.put("ex_reshuibengbianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_reshuibengbianpinqiguzhang", 84,1,"热水泵变频器故障"));

        map.put("ex_buyoubengbianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_buyoubengbianpinqiguzhang", 85,1,"补油泵变频器故障"));

        map.put("ex_ecigufengbianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_ecigufengbianpinqiguzhang", 86,1,"二次鼓风变频器故障"));

        map.put("ex_songliaojibianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_songliaojibianpinqiguzhang", 87,1,"送料机变频器故障"));

        map.put("ex_zhenkongbengbianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_zhenkongbengbianpinqiguzhang", 88,1,"真空泵变频器故障"));

        map.put("ex_lengningbengbianpinqiguzhang", ByteField.Init(new ExceptionField(), "ex_lengningbengbianpinqiguzhang", 89,1,"冷凝泵变频器故障"));

        map.put("ex_bushuibengguzhang", ByteField.Init(new ExceptionField(), "ex_bushuibengguzhang", 90,1,"补水泵故障"));

        map.put("ex_buyoubengguzhang", ByteField.Init(new ExceptionField(), "ex_buyoubengguzhang", 91,1,"补油泵故障"));

        map.put("ex_lengningbengguzhang", ByteField.Init(new ExceptionField(), "ex_lengningbengguzhang", 92,1,"冷凝泵故障"));

        map.put("ex_reshuibengguzhang", ByteField.Init(new ExceptionField(), "ex_reshuibengguzhang", 93,1,"热水泵故障"));

        map.put("ex_zhenkongbengguzhang", ByteField.Init(new ExceptionField(), "ex_zhenkongbengguzhang", 94,1,"真空泵故障"));

        map.put("ex_ecixunhuanbengguzhang", ByteField.Init(new ExceptionField(), "ex_ecixunhuanbengguzhang", 95,1,"二次循环泵故障"));

        map.put("ex_huilu1xunhuanbengguzhang", ByteField.Init(new ExceptionField(), "ex_huilu1xunhuanbengguzhang", 96,1,"回路1循环泵故障"));

        map.put("ex_huilu2xunhuanbengguzhang", ByteField.Init(new ExceptionField(), "ex_huilu2xunhuanbengguzhang", 97,1,"回路2循环泵故障"));

        map.put("ex_huilu3xunhuanbengguzhang", ByteField.Init(new ExceptionField(), "ex_huilu3xunhuanbengguzhang", 98,1,"回路3循环泵故障"));

        map.put("ex_huilu4xunhuanbengguzhang", ByteField.Init(new ExceptionField(), "ex_huilu4xunhuanbengguzhang", 99,1,"回路4循环泵故障"));

        map.put("ex_huilu5xunhuanbengguzhang", ByteField.Init(new ExceptionField(), "ex_huilu5xunhuanbengguzhang", 100,1,"回路5循环泵故障"));

        map.put("ex_huilu1wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_huilu1wendugaobaojing", 101,1,"回路1温度高报警"));

        map.put("ex_huilu2wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_huilu2wendugaobaojing", 102,1,"回路2温度高报警"));

        map.put("ex_huilu3wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_huilu3wendugaobaojing", 103,1,"回路3温度高报警"));

        map.put("ex_huilu4wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_huilu4wendugaobaojing", 104,1,"回路4温度高报警"));

        map.put("ex_huilu5wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_huilu5wendugaobaojing", 105,1,"回路5温度高报警"));

        map.put("ex_panguan1wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan1wendugaobaojing", 106,1,"盘管1温度高报警"));

        map.put("ex_panguan2wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan2wendugaobaojing", 107,1,"盘管2温度高报警"));

        map.put("ex_panguan3wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan3wendugaobaojing", 108,1,"盘管3温度高报警"));

        map.put("ex_panguan4wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan4wendugaobaojing", 109,1,"盘管4温度高报警"));

        map.put("ex_panguan5wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan5wendugaobaojing", 110,1,"盘管5温度高报警"));

        map.put("ex_panguan6wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan6wendugaobaojing", 111,1,"盘管6温度高报警"));

        map.put("ex_panguan7wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan7wendugaobaojing", 112,1,"盘管7温度高报警"));

        map.put("ex_panguan8wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan8wendugaobaojing", 113,1,"盘管8温度高报警"));

        map.put("ex_panguan9wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan9wendugaobaojing", 114,1,"盘管9温度高报警"));

        map.put("ex_panguan10wendugaobaojing", ByteField.Init(new ExceptionField(), "ex_panguan10wendugaobaojing", 115,1,"盘管10温度高报警"));

        map.put("ex_shanzhengguanchaoyabaojing", ByteField.Init(new ExceptionField(), "ex_shanzhengguanchaoyabaojing", 116,1,"闪蒸罐超压报警"));

        map.put("ex_lengningguanchaoyabaojing", ByteField.Init(new ExceptionField(), "ex_lengningguanchaoyabaojing", 117,1,"冷凝罐超压报警"));

        map.put("ex_pengzhangguanchaoyabaojing", ByteField.Init(new ExceptionField(), "ex_pengzhangguanchaoyabaojing", 118,1,"膨胀罐超压报警"));

        map.put("ex_shanzhengguanyeweigaobaojing", ByteField.Init(new ExceptionField(), "ex_shanzhengguanyeweigaobaojing", 119,1,"闪蒸罐液位高报警"));

        map.put("ex_shanzhengguanyeweidibaojing", ByteField.Init(new ExceptionField(), "ex_shanzhengguanyeweidibaojing", 120,1,"闪蒸罐液位低报警"));

        map.put("ex_lengningguanyeweigaobaojing", ByteField.Init(new ExceptionField(), "ex_lengningguanyeweigaobaojing", 121,1,"冷凝罐液位高报警"));

        map.put("ex_lengningguanyeweidibaojing", ByteField.Init(new ExceptionField(), "ex_lengningguanyeweidibaojing", 122,1,"冷凝罐液位低报警"));

        map.put("ex_pengzhangguanyeweigaobaojing", ByteField.Init(new ExceptionField(), "ex_pengzhangguanyeweigaobaojing", 123,1,"膨胀罐液位高报警"));

        map.put("ex_pengzhangguanyeweidibaojing", ByteField.Init(new ExceptionField(), "ex_pengzhangguanyeweidibaojing", 124,1,"膨胀罐液位低报警"));

        map.put("ex_jinchukouyachadibaojing", ByteField.Init(new ExceptionField(), "ex_jinchukouyachadibaojing", 125,1,"进出口压差低报警"));

        map.put("ex_bentipaiyanwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_bentipaiyanwenduchuanganqiguzhang", 181,1,"本体排烟温度传感器故障"));

        map.put("ex_paiyanwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_paiyanwenduchuanganqiguzhang", 182,1,"排烟温度传感器故障"));

        map.put("ex_lushuiwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lushuiwenduchuanganqiguzhang", 183,1,"炉水温度传感器故障"));

        map.put("ex_chukouwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_chukouwenduchuanganqiguzhang", 184,1,"出口温度传感器故障"));

        map.put("ex_rukouwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_rukouwenduchuanganqiguzhang", 185,1,"入口温度传感器故障"));

        map.put("ex_jienengqichukouwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_jienengqichukouwenduchuanganqiguzhang", 186,1,"节能器出口温度传感器故障"));

        map.put("ex_jienengqirukouwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_jienengqirukouwenduchuanganqiguzhang", 187,1,"节能器入口温度传感器故障"));

        map.put("ex_jishuiwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_jishuiwenduchuanganqiguzhang", 188,1,"给水温度传感器故障"));

        map.put("ex_lutangwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lutangwenduchuanganqiguzhang", 189,1,"炉膛温度传感器故障"));

        map.put("ex_lutangchukouwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lutangchukouwenduchuanganqiguzhang", 190,1,"炉膛出口温度传感器故障"));

        map.put("ex_lubiwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lubiwenduchuanganqiguzhang", 191,1,"炉壁温度传感器故障"));

        map.put("ex_ranliaowenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_ranliaowenduchuanganqiguzhang", 192,1,"燃料温度传感器故障"));

        map.put("ex_refengwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_refengwenduchuanganqiguzhang", 193,1,"热风温度传感器故障"));

        map.put("ex_fuyazhengqiwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_fuyazhengqiwenduchuanganqiguzhang", 194,1,"负压蒸汽温度传感器故障"));

        map.put("ex_guorezhengqiwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_guorezhengqiwenduchuanganqiguzhang", 195,1,"过热蒸汽温度传感器故障"));

        map.put("ex_huilu1wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_huilu1wenduchuanganqiguzhang", 196,1,"回路1温度传感器故障"));

        map.put("ex_huilu2wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_huilu2wenduchuanganqiguzhang", 197,1,"回路2温度传感器故障"));

        map.put("ex_huilu3wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_huilu3wenduchuanganqiguzhang", 198,1,"回路3温度传感器故障"));

        map.put("ex_huilu4wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_huilu4wenduchuanganqiguzhang", 199,1,"回路4温度传感器故障"));

        map.put("ex_huilu5wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_huilu5wenduchuanganqiguzhang", 200,1,"回路5温度传感器故障"));

        map.put("ex_shiwaiwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_shiwaiwenduchuanganqiguzhang", 201,1,"室外温度传感器故障"));

        map.put("ex_zhengqiyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_zhengqiyalichuanganqiguzhang", 202,1,"蒸汽压力传感器故障"));

        map.put("ex_jishuiyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_jishuiyalichuanganqiguzhang", 203,1,"给水压力传感器故障"));

        map.put("ex_chukouyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_chukouyalichuanganqiguzhang", 204,1,"出口压力传感器故障"));

        map.put("ex_rukouyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_rukouyalichuanganqiguzhang", 205,1,"入口压力传感器故障"));

        map.put("ex_lutangyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lutangyalichuanganqiguzhang", 206,1,"炉膛压力传感器故障"));

        map.put("ex_lutangchukouyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lutangchukouyalichuanganqiguzhang", 207,1,"炉膛出口压力传感器故障"));

        map.put("ex_ranqiyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_ranqiyalichuanganqiguzhang", 208,1,"燃气压力传感器故障"));

        map.put("ex_yicifengyachuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_yicifengyachuanganqiguzhang", 209,1,"一次风压传感器故障"));

        map.put("ex_ecifengyachuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_ecifengyachuanganqiguzhang", 210,1,"二次风压传感器故障"));

        map.put("ex_ranliaoliangchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_ranliaoliangchuanganqiguzhang", 211,1,"燃料量传感器故障"));

        map.put("ex_zhengqiliuliangchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_zhengqiliuliangchuanganqiguzhang", 212,1,"蒸汽流量传感器故障"));

        map.put("ex_jishuiliuliangchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_jishuiliuliangchuanganqiguzhang", 213,1,"给水流量传感器故障"));

        map.put("ex_xunhuanliuliangchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_xunhuanliuliangchuanganqiguzhang", 214,1,"循环流量传感器故障"));

        map.put("ex_bushuiliuliangchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_bushuiliuliangchuanganqiguzhang", 215,1,"补水流量传感器故障"));

        map.put("ex_guoluyeweichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_guoluyeweichuanganqiguzhang", 216,1,"锅炉液位传感器故障"));

        map.put("ex_shuixiangyeweichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_shuixiangyeweichuanganqiguzhang", 217,1,"水箱液位传感器故障"));

        map.put("ex_paiyanyanghanliangchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_paiyanyanghanliangchuanganqiguzhang", 218,1,"排烟氧含量传感器故障"));

        map.put("ex_lupaisudufankuichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lupaisudufankuichuanganqiguzhang", 219,1,"炉排速度反馈传感器故障"));

        map.put("ex_yinfengshuchufankuichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_yinfengshuchufankuichuanganqiguzhang", 220,1,"引风输出反馈传感器故障"));

        map.put("ex_gufengshuchufankuichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_gufengshuchufankuichuanganqiguzhang", 221,1,"鼓风输出反馈传感器故障"));

        map.put("ex_jishuishuchufankuichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_jishuishuchufankuichuanganqiguzhang", 222,1,"给水输出反馈传感器故障"));

        map.put("ex_meishuiwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_meishuiwenduchuanganqiguzhang", 223,1,"媒水温度传感器故障"));

        map.put("ex_shuixiangwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_shuixiangwenduchuanganqiguzhang", 224,1,"水箱温度传感器故障"));

        map.put("ex_pengzhangguanyeweichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_pengzhangguanyeweichuanganqiguzhang", 225,1,"膨胀罐液位传感器故障"));

        map.put("ex_shanzhengguanyeweichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_shanzhengguanyeweichuanganqiguzhang", 226,1,"闪蒸罐液位传感器故障"));

        map.put("ex_lengningyeguanyeweichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lengningyeguanyeweichuanganqiguzhang", 227,1,"冷凝液罐液位传感器故障"));

        map.put("ex_chuguanyeweichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_chuguanyeweichuanganqiguzhang", 228,1,"储罐液位传感器故障"));

        map.put("ex_pengzhangguanwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_pengzhangguanwenduchuanganqiguzhang", 229,1,"膨胀罐温度传感器故障"));

        map.put("ex_shanzhengguanwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_shanzhengguanwenduchuanganqiguzhang", 230,1,"闪蒸罐温度传感器故障"));

        map.put("ex_lengningyeguanwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_lengningyeguanwenduchuanganqiguzhang", 231,1,"冷凝液罐温度传感器故障"));

        map.put("ex_chuguanwenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_chuguanwenduchuanganqiguzhang", 232,1,"储罐温度传感器故障"));

        map.put("ex_guoluyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_guoluyalichuanganqiguzhang", 233,1,"锅炉压力传感器故障"));

        map.put("ex_guorezhengqiyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_guorezhengqiyalichuanganqiguzhang", 234,1,"过热蒸汽压力传感器故障"));

        map.put("ex_paiyanchuyalichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_paiyanchuyalichuanganqiguzhang", 235,1,"排烟处压力传感器故障"));

        map.put("ex_fengshifengyachuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_fengshifengyachuanganqiguzhang", 236,1,"风室风压传感器故障"));

        map.put("ex_yinfengjidianliuchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_yinfengjidianliuchuanganqiguzhang", 237,1,"引风机电流传感器故障"));

        map.put("ex_gufengjidianliuchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_gufengjidianliuchuanganqiguzhang", 238,1,"鼓风机电流传感器故障"));

        map.put("ex_jiliaojisudufankuichuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_jiliaojisudufankuichuanganqiguzhang", 239,1,"给料机速度反馈传感器故障"));

        map.put("ex_panguan1wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan1wenduchuanganqiguzhang", 240,1,"盘管1温度传感器故障"));

        map.put("ex_panguan2wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan2wenduchuanganqiguzhang", 241,1,"盘管2温度传感器故障"));

        map.put("ex_panguan3wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan3wenduchuanganqiguzhang", 242,1,"盘管3温度传感器故障"));

        map.put("ex_panguan4wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan4wenduchuanganqiguzhang", 243,1,"盘管4温度传感器故障"));

        map.put("ex_panguan5wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan5wenduchuanganqiguzhang", 244,1,"盘管5温度传感器故障"));

        map.put("ex_panguan6wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan6wenduchuanganqiguzhang", 245,1,"盘管6温度传感器故障"));

        map.put("ex_panguan7wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan7wenduchuanganqiguzhang", 246,1,"盘管7温度传感器故障"));

        map.put("ex_panguan8wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan8wenduchuanganqiguzhang", 247,1,"盘管8温度传感器故障"));

        map.put("ex_panguan9wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan9wenduchuanganqiguzhang", 248,1,"盘管9温度传感器故障"));

        map.put("ex_panguan10wenduchuanganqiguzhang", ByteField.Init(new ExceptionField(), "ex_panguan10wenduchuanganqiguzhang", 249,1,"盘管10温度传感器故障"));

        map.put("mo_bentipaiyanwendu", ByteField.Init(new MockField(), "mo_bentipaiyanwendu", 277,2,"本体排烟温度", "℃"));

        map.put("mo_paiyanwendu", ByteField.Init(new MockField(), "mo_paiyanwendu", 279,2,"排烟温度", "℃"));

        map.put("mo_lushuiwendu", ByteField.Init(new MockField(), "mo_lushuiwendu", 281,2,"炉水温度", "℃"));

        map.put("mo_chukouwendu", ByteField.Init(new MockField(), "mo_chukouwendu", 283,2,"出口温度", "℃"));

        map.put("mo_rukouwendu", ByteField.Init(new MockField(), "mo_rukouwendu", 285,2,"入口温度", "℃"));

        map.put("mo_jienengqichukouwendu", ByteField.Init(new MockField(), "mo_jienengqichukouwendu", 287,2,"节能器出口温度", "℃"));

        map.put("mo_jienengqirukouwendu", ByteField.Init(new MockField(), "mo_jienengqirukouwendu", 289,2,"节能器入口温度", "℃"));

        map.put("mo_jishuiwendu", ByteField.Init(new MockField(), "mo_jishuiwendu", 291,2,"给水温度", "℃"));

        map.put("mo_lutangwendu", ByteField.Init(new MockField(), "mo_lutangwendu", 293,2,"炉膛温度", "℃"));

        map.put("mo_lutangchukouwendu", ByteField.Init(new MockField(), "mo_lutangchukouwendu", 295,2,"炉膛出口温度", "℃"));

        map.put("mo_lubiwendu", ByteField.Init(new MockField(), "mo_lubiwendu", 297,2,"炉壁温度", "℃"));

        map.put("mo_ranliaowendu", ByteField.Init(new MockField(), "mo_ranliaowendu", 299,2,"燃料温度", "℃"));

        map.put("mo_refengwendu", ByteField.Init(new MockField(), "mo_refengwendu", 301,2,"热风温度", "℃"));

        map.put("mo_fuyazhengqiwendu", ByteField.Init(new MockField(), "mo_fuyazhengqiwendu", 303,2,"负压蒸汽温度", "℃"));

        map.put("mo_guorezhengqiwendu", ByteField.Init(new MockField(), "mo_guorezhengqiwendu", 305,2,"过热蒸汽温度", "℃"));

        map.put("mo_huilu1wendu", ByteField.Init(new MockField(), "mo_huilu1wendu", 307,2,"回路1温度", "℃"));

        map.put("mo_huilu2wendu", ByteField.Init(new MockField(), "mo_huilu2wendu", 309,2,"回路2温度", "℃"));

        map.put("mo_huilu3wendu", ByteField.Init(new MockField(), "mo_huilu3wendu", 311,2,"回路3温度", "℃"));

        map.put("mo_huilu4wendu", ByteField.Init(new MockField(), "mo_huilu4wendu", 313,2,"回路4温度", "℃"));

        map.put("mo_huilu5wendu", ByteField.Init(new MockField(), "mo_huilu5wendu", 315,2,"回路5温度", "℃"));

        map.put("mo_shiwaiwendu", ByteField.Init(new MockField(), "mo_shiwaiwendu", 317,2,"室外温度", "℃"));

        map.put("mo_zhengqiyali", ByteField.Init(new MockField(), "mo_zhengqiyali", 319,2,"蒸汽压力", "MPa", 100));

        map.put("mo_jishuiyali", ByteField.Init(new MockField(), "mo_jishuiyali", 321,2,"给水压力", "MPa", 100));

        map.put("mo_chukouyali", ByteField.Init(new MockField(), "mo_chukouyali", 323,2,"出口压力", "MPa", 100));

        map.put("mo_rukouyali", ByteField.Init(new MockField(), "mo_rukouyali", 325,2,"入口压力", "MPa", 100));

        map.put("mo_lutangyali", ByteField.Init(new MockField(), "mo_lutangyali", 327,2,"炉膛压力", "Pa"));

        map.put("mo_lutangchukouyali", ByteField.Init(new MockField(), "mo_lutangchukouyali", 329,2,"炉膛出口压力", "Pa"));

        map.put("mo_ranqiyali", ByteField.Init(new MockField(), "mo_ranqiyali", 331,2,"燃气压力", "KPa"));

        map.put("mo_yicifengya", ByteField.Init(new MockField(), "mo_yicifengya", 333,2,"一次风压", "KPa"));

        map.put("mo_ecifengya", ByteField.Init(new MockField(), "mo_ecifengya", 335,2,"二次风压", "KPa"));

        map.put("mo_ranliaoliang", ByteField.Init(new MockField(), "mo_ranliaoliang", 337,2,"燃料量"));

        map.put("mo_zhengqiliuliang", ByteField.Init(new MockField(), "mo_zhengqiliuliang", 339,2,"蒸汽流量"));

        map.put("mo_jishuiliuliang", ByteField.Init(new MockField(), "mo_jishuiliuliang", 341,2,"给水流量"));

        map.put("mo_xunhuanliuliang", ByteField.Init(new MockField(), "mo_xunhuanliuliang", 343,2,"循环流量"));

        map.put("mo_bushuiliuliang", ByteField.Init(new MockField(), "mo_bushuiliuliang", 345,2,"补水流量"));

        map.put("mo_guoluyewei", ByteField.Init(new MockField(), "mo_guoluyewei", 347,2,"锅炉液位", "mm"));

        map.put("mo_shuixiangyewei", ByteField.Init(new MockField(), "mo_shuixiangyewei", 349,2,"水箱液位", "mm"));

        map.put("mo_paiyanyanghanliang", ByteField.Init(new MockField(), "mo_paiyanyanghanliang", 351,2,"排烟氧含量", "%", 10));

        map.put("mo_lupaisudufankui", ByteField.Init(new MockField(), "mo_lupaisudufankui", 353,2,"炉排速度反馈", "%"));

        map.put("mo_yinfengshuchufankui", ByteField.Init(new MockField(), "mo_yinfengshuchufankui", 355,2,"引风输出反馈", "%"));

        map.put("mo_gufengshuchufankui", ByteField.Init(new MockField(), "mo_gufengshuchufankui", 357,2,"鼓风输出反馈", "%"));

        map.put("mo_jishuishuchufankui", ByteField.Init(new MockField(), "mo_jishuishuchufankui", 359,2,"给水输出反馈", "%"));

        map.put("mo_meishuiwendu", ByteField.Init(new MockField(), "mo_meishuiwendu", 361,2,"媒水温度", "℃"));

        map.put("mo_shuixiangwendu", ByteField.Init(new MockField(), "mo_shuixiangwendu", 363,2,"水箱温度", "℃"));

        map.put("mo_pengzhangguanyewei", ByteField.Init(new MockField(), "mo_pengzhangguanyewei", 365,2,"膨胀罐液位", "mm"));

        map.put("mo_shanzhengguanyewei", ByteField.Init(new MockField(), "mo_shanzhengguanyewei", 367,2,"闪蒸罐液位", "mm"));

        map.put("mo_lengningyeguanyewei", ByteField.Init(new MockField(), "mo_lengningyeguanyewei", 369,2,"冷凝液罐液位", "mm"));

        map.put("mo_chuguanyewei", ByteField.Init(new MockField(), "mo_chuguanyewei", 371,2,"储罐液位", "mm"));

        map.put("mo_pengzhangguanwendu", ByteField.Init(new MockField(), "mo_pengzhangguanwendu", 373,2,"膨胀罐温度", "℃"));

        map.put("mo_shanzhengguanwendu", ByteField.Init(new MockField(), "mo_shanzhengguanwendu", 375,2,"闪蒸罐温度", "℃"));

        map.put("mo_lengningyeguanwendu", ByteField.Init(new MockField(), "mo_lengningyeguanwendu", 377,2,"冷凝液罐温度", "℃"));

        map.put("mo_chuguanwendu", ByteField.Init(new MockField(), "mo_chuguanwendu", 379,2,"储罐温度", "℃"));

        map.put("mo_guoluyali", ByteField.Init(new MockField(), "mo_guoluyali", 381,2,"锅炉压力", "MPa", 100));

        map.put("mo_guorezhengqiyali", ByteField.Init(new MockField(), "mo_guorezhengqiyali", 383,2,"过热蒸汽压力", "MPa", 100));

        map.put("mo_paiyanchuyali", ByteField.Init(new MockField(), "mo_paiyanchuyali", 385,2,"排烟处压力", "Pa"));

        map.put("mo_fengshifengya", ByteField.Init(new MockField(), "mo_fengshifengya", 387,2,"风室风压", "KPa"));

        map.put("mo_yinfengjidianliu", ByteField.Init(new MockField(), "mo_yinfengjidianliu", 389,2,"引风机电流", "A"));

        map.put("mo_gufengjidianliu", ByteField.Init(new MockField(), "mo_gufengjidianliu", 391,2,"鼓风机电流", "A"));

        map.put("mo_jiliaojisudufankui", ByteField.Init(new MockField(), "mo_jiliaojisudufankui", 393,2,"给料机速度反馈", "%"));

        map.put("mo_panguan1wendu", ByteField.Init(new MockField(), "mo_panguan1wendu", 395,2,"盘管1温度", "℃"));

        map.put("mo_panguan2wendu", ByteField.Init(new MockField(), "mo_panguan2wendu", 397,2,"盘管2温度", "℃"));

        map.put("mo_panguan3wendu", ByteField.Init(new MockField(), "mo_panguan3wendu", 399,2,"盘管3温度", "℃"));

        map.put("mo_panguan4wendu", ByteField.Init(new MockField(), "mo_panguan4wendu", 401,2,"盘管4温度", "℃"));

        map.put("mo_panguan5wendu", ByteField.Init(new MockField(), "mo_panguan5wendu", 403,2,"盘管5温度", "℃"));

        map.put("mo_panguan6wendu", ByteField.Init(new MockField(), "mo_panguan6wendu", 405,2,"盘管6温度", "℃"));

        map.put("mo_panguan7wendu", ByteField.Init(new MockField(), "mo_panguan7wendu", 407,2,"盘管7温度", "℃"));

        map.put("mo_panguan8wendu", ByteField.Init(new MockField(), "mo_panguan8wendu", 409,2,"盘管8温度", "℃"));

        map.put("mo_panguan9wendu", ByteField.Init(new MockField(), "mo_panguan9wendu", 411,2,"盘管9温度", "℃"));

        map.put("mo_panguan10wendu", ByteField.Init(new MockField(), "mo_panguan10wendu", 413,2,"盘管10温度", "℃"));

        map.put("se_paiyanwendu", ByteField.Init(new SettingField(), "se_paiyanwendu", 465,2,"排烟温度", "℃"));

        map.put("se_baojingwendu", ByteField.Init(new SettingField(), "se_baojingwendu", 467,2,"报警温度", "℃"));

        map.put("se_tingluwendu", ByteField.Init(new SettingField(), "se_tingluwendu", 469,2,"停炉温度", "℃"));

        map.put("se_mubiaowendu", ByteField.Init(new SettingField(), "se_mubiaowendu", 471,2,"目标温度", "℃"));

        map.put("se_qiluwendu", ByteField.Init(new SettingField(), "se_qiluwendu", 473,2,"启炉温度", "℃"));

        map.put("se_zhuanhuohuichawendu", ByteField.Init(new SettingField(), "se_zhuanhuohuichawendu", 475,2,"转火回差温度", "℃"));

        map.put("se_qiluhuichawendu", ByteField.Init(new SettingField(), "se_qiluhuichawendu", 477,2,"启炉回差温度", "℃"));

        map.put("se_kaibengwendu", ByteField.Init(new SettingField(), "se_kaibengwendu", 479,2,"开泵温度", "℃"));

        map.put("se_guanbengwendu", ByteField.Init(new SettingField(), "se_guanbengwendu", 481,2,"关泵温度", "℃"));

        map.put("se_baojingyali", ByteField.Init(new SettingField(), "se_baojingyali", 483,2,"报警压力", "MPa", 100));

        map.put("se_tingluyali", ByteField.Init(new SettingField(), "se_tingluyali", 485,2,"停炉压力", "MPa", 100));

        map.put("se_mubiaoyali", ByteField.Init(new SettingField(), "se_mubiaoyali", 487,2,"目标压力", "MPa", 100));

        map.put("se_qiluyali", ByteField.Init(new SettingField(), "se_qiluyali", 489,2,"启炉压力", "MPa", 100));

        map.put("se_zhuanhuohuichayali", ByteField.Init(new SettingField(), "se_zhuanhuohuichayali", 491,2,"转火回差压力", "MPa", 100));

        map.put("se_qiluhuichayali", ByteField.Init(new SettingField(), "se_qiluhuichayali", 493,2,"启炉回差压力", "MPa", 100));

        map.put("se_qianyanshi", ByteField.Init(new SettingField(), "se_qianyanshi", 495,2,"前延时", "S"));

        map.put("se_houyanshimiao", ByteField.Init(new SettingField(), "se_houyanshimiao", 497,2,"后延时秒", "S"));

        map.put("se_qianchuisao", ByteField.Init(new SettingField(), "se_qianchuisao", 499,2,"前吹扫", "S"));

        map.put("se_houchuisao", ByteField.Init(new SettingField(), "se_houchuisao", 501,2,"后吹扫", "S"));

        map.put("se_lubibaojingwendu", ByteField.Init(new SettingField(), "se_lubibaojingwendu", 503,2,"炉壁报警温度", "℃"));

        map.put("se_lutangchukoubaojingwendu", ByteField.Init(new SettingField(), "se_lutangchukoubaojingwendu", 505,2,"炉膛出口报警温度", "℃"));

        map.put("se_baohuwendu", ByteField.Init(new SettingField(), "se_baohuwendu", 507,2,"保护温度", "℃"));

        map.put("se_bentipaiyanwendubaojingzhi", ByteField.Init(new SettingField(), "se_bentipaiyanwendubaojingzhi", 509,2,"本体排烟温度报警值", "℃"));

        map.put("se_jiarezushu", ByteField.Init(new SettingField(), "se_jiarezushu", 511,2,"加热组数"));

        map.put("se_jianceyalishijian", ByteField.Init(new SettingField(), "se_jianceyalishijian", 513,2,"检测压力时间"));

        map.put("se_houyanshifen", ByteField.Init(new SettingField(), "se_houyanshifen", 515,2,"后延时分", "m"));

        map.put("se_shedingwendu", ByteField.Init(new SettingField(), "se_shedingwendu", 517,2,"设定温度", "℃"));

        map.put("se_mokuailutaishu", ByteField.Init(new SettingField(), "se_mokuailutaishu", 519,2,"模块炉台数"));

        map.put("se_gufenghouyanshi", ByteField.Init(new SettingField(), "se_gufenghouyanshi", 521,2,"鼓风后延时", "S"));

        map.put("se_yinfenghouyanshi", ByteField.Init(new SettingField(), "se_yinfenghouyanshi", 523,2,"引风后延时", "S"));

        map.put("se_shuixiangkaibengwendu", ByteField.Init(new SettingField(), "se_shuixiangkaibengwendu", 525,2,"水箱开泵温度", "℃"));

        map.put("se_shuixiangguanbengwendu", ByteField.Init(new SettingField(), "se_shuixiangguanbengwendu", 527,2,"水箱关泵温度", "℃"));

        map.put("se_lushuibaojingwendu", ByteField.Init(new SettingField(), "se_lushuibaojingwendu", 529,2,"炉水报警温度", "℃"));

        map.put("se_buchangxishu", ByteField.Init(new SettingField(), "se_buchangxishu", 531,2,"补偿系数"));

        map.put("se_cankaowendu", ByteField.Init(new SettingField(), "se_cankaowendu", 533,2,"参考温度", "℃"));

        map.put("se_tingluzuidazhi", ByteField.Init(new SettingField(), "se_tingluzuidazhi", 535,2,"停炉最大值", "℃"));

        map.put("se_qiluzuixiaozhi", ByteField.Init(new SettingField(), "se_qiluzuixiaozhi", 537,2,"启炉最小值", "℃"));

        map.put("se_cankaohuicha", ByteField.Init(new SettingField(), "se_cankaohuicha", 539,2,"参考回差", "℃"));

        map.put("se_tingluwendu1", ByteField.Init(new SettingField(), "se_tingluwendu1", 541,2,"停炉温度1", "℃"));

        map.put("se_qiluwendu1", ByteField.Init(new SettingField(), "se_qiluwendu1", 543,2,"启炉温度1", "℃"));

        map.put("se_tingluwendu2", ByteField.Init(new SettingField(), "se_tingluwendu2", 545,2,"停炉温度2", "℃"));

        map.put("se_qiluwendu2", ByteField.Init(new SettingField(), "se_qiluwendu2", 547,2,"启炉温度2", "℃"));

        map.put("se_yusongliaoshijian", ByteField.Init(new SettingField(), "se_yusongliaoshijian", 549,2,"预送料时间", "S"));

        map.put("se_dianhuoshijian", ByteField.Init(new SettingField(), "se_dianhuoshijian", 551,2,"点火时间", "S"));

        map.put("se_songliaoqidongshijian", ByteField.Init(new SettingField(), "se_songliaoqidongshijian", 553,2,"送料启动时间", "S"));

        map.put("se_songliaotingzhishijian", ByteField.Init(new SettingField(), "se_songliaotingzhishijian", 555,2,"送料停止时间", "S"));

        map.put("se_dianhuojiange", ByteField.Init(new SettingField(), "se_dianhuojiange", 557,2,"点火间隔", "m"));

        map.put("se_dianhuochenggongwendu", ByteField.Init(new SettingField(), "se_dianhuochenggongwendu", 559,2,"点火成功温度", "℃"));

        map.put("se_lushuitingluwendu", ByteField.Init(new SettingField(), "se_lushuitingluwendu", 561,2,"炉水停炉温度", "℃"));

        map.put("se_lushuiqiluwendu", ByteField.Init(new SettingField(), "se_lushuiqiluwendu", 563,2,"炉水启炉温度", "℃"));

        map.put("se_meishuibaojingwendu", ByteField.Init(new SettingField(), "se_meishuibaojingwendu", 565,2,"媒水报警温度", "℃"));

        map.put("se_meishuitingluwendu", ByteField.Init(new SettingField(), "se_meishuitingluwendu", 567,2,"媒水停炉温度", "℃"));

        map.put("se_meishuiqiluwendu", ByteField.Init(new SettingField(), "se_meishuiqiluwendu", 569,2,"媒水启炉温度", "℃"));

        map.put("se_kaibengyali", ByteField.Init(new SettingField(), "se_kaibengyali", 571,2,"开泵压力", "MPa", 100));

        map.put("se_guanbengyali", ByteField.Init(new SettingField(), "se_guanbengyali", 573,2,"关泵压力", "MPa", 100));

        map.put("se_panguanbaojingwendu", ByteField.Init(new SettingField(), "se_panguanbaojingwendu", 575,2,"盘管报警温度", "℃"));

        map.put("se_huilu1baojingwendu", ByteField.Init(new SettingField(), "se_huilu1baojingwendu", 577,2,"回路1报警温度", "℃"));

        map.put("se_huilu1kaibengwendu", ByteField.Init(new SettingField(), "se_huilu1kaibengwendu", 579,2,"回路1开泵温度", "℃"));

        map.put("se_huilu1guanbengwendu", ByteField.Init(new SettingField(), "se_huilu1guanbengwendu", 581,2,"回路1关泵温度", "℃"));

        map.put("se_huilu2baojingwendu", ByteField.Init(new SettingField(), "se_huilu2baojingwendu", 583,2,"回路2报警温度", "℃"));

        map.put("se_huilu2kaibengwendu", ByteField.Init(new SettingField(), "se_huilu2kaibengwendu", 585,2,"回路2开泵温度", "℃"));

        map.put("se_huilu2guanbengwendu", ByteField.Init(new SettingField(), "se_huilu2guanbengwendu", 587,2,"回路2关泵温度", "℃"));

        map.put("se_huilu3baojingwendu", ByteField.Init(new SettingField(), "se_huilu3baojingwendu", 589,2,"回路3报警温度", "℃"));

        map.put("se_huilu3kaibengwendu", ByteField.Init(new SettingField(), "se_huilu3kaibengwendu", 591,2,"回路3开泵温度", "℃"));

        map.put("se_huilu3guanbengwendu", ByteField.Init(new SettingField(), "se_huilu3guanbengwendu", 593,2,"回路3关泵温度", "℃"));

        map.put("se_huilu4baojingwendu", ByteField.Init(new SettingField(), "se_huilu4baojingwendu", 595,2,"回路4报警温度", "℃"));

        map.put("se_huilu4kaibengwendu", ByteField.Init(new SettingField(), "se_huilu4kaibengwendu", 597,2,"回路4开泵温度", "℃"));

        map.put("se_huilu4guanbengwendu", ByteField.Init(new SettingField(), "se_huilu4guanbengwendu", 599,2,"回路4关泵温度", "℃"));

        map.put("se_huilu5baojingwendu", ByteField.Init(new SettingField(), "se_huilu5baojingwendu", 601,2,"回路5报警温度", "℃"));

        map.put("se_huilu5kaibengwendu", ByteField.Init(new SettingField(), "se_huilu5kaibengwendu", 603,2,"回路5开泵温度", "℃"));

        map.put("se_huilu5guanbengwendu", ByteField.Init(new SettingField(), "se_huilu5guanbengwendu", 605,2,"回路5关泵温度", "℃"));

        map.put("st_qidongshijian1", ByteField.Init(new StartStopField(), "st_qidongshijian1", 607,2,"启动时间1"));

        map.put("st_tingzhishijian1", ByteField.Init(new StartStopField(), "st_tingzhishijian1", 609,2,"停止时间1"));

        map.put("st_qidongshijian2", ByteField.Init(new StartStopField(), "st_qidongshijian2", 611,2,"启动时间2"));

        map.put("st_tingzhishijian2", ByteField.Init(new StartStopField(), "st_tingzhishijian2", 613,2,"停止时间2"));

        map.put("st_qidongshijian3", ByteField.Init(new StartStopField(), "st_qidongshijian3", 615,2,"启动时间3"));

        map.put("st_tingzhishijian3", ByteField.Init(new StartStopField(), "st_tingzhishijian3", 617,2,"停止时间3"));

        map.put("st_qidongshijian4", ByteField.Init(new StartStopField(), "st_qidongshijian4", 619,2,"启动时间4"));

        map.put("st_tingzhishijian4", ByteField.Init(new StartStopField(), "st_tingzhishijian4", 621,2,"停止时间4"));

        map.put("st_qidongshijian5", ByteField.Init(new StartStopField(), "st_qidongshijian5", 623,2,"启动时间5"));

        map.put("st_tingzhishijian5", ByteField.Init(new StartStopField(), "st_tingzhishijian5", 625,2,"停止时间5"));

        map.put("st_qidongshijian6", ByteField.Init(new StartStopField(), "st_qidongshijian6", 627,2,"启动时间6"));

        map.put("st_tingzhishijian6", ByteField.Init(new StartStopField(), "st_tingzhishijian6", 629,2,"停止时间6"));

        map.put("de_ranshaoqi", ByteField.Init(new DeviceField(), "de_ranshaoqi", 681,2,"燃烧器"));

        map.put("de_jiarezu", ByteField.Init(new DeviceField(), "de_jiarezu", 683,2,"加热组"));

        map.put("de_bushuibeng", ByteField.Init(new DeviceField(), "de_bushuibeng", 685,2,"补水泵"));

        map.put("de_jishuibeng", ByteField.Init(new DeviceField(), "de_jishuibeng", 687,2,"给水泵"));

        map.put("de_buyoubeng", ByteField.Init(new DeviceField(), "de_buyoubeng", 689,2,"补油泵"));

        map.put("de_xunhuanbeng", ByteField.Init(new DeviceField(), "de_xunhuanbeng", 691,2,"循环泵"));

        map.put("de_lengningbeng", ByteField.Init(new DeviceField(), "de_lengningbeng", 693,2,"冷凝泵"));

        map.put("de_reshuibeng", ByteField.Init(new DeviceField(), "de_reshuibeng", 695,2,"热水泵"));

        map.put("de_zhenkongbeng", ByteField.Init(new DeviceField(), "de_zhenkongbeng", 697,2,"真空泵"));

        map.put("de_ecixunhuanbeng", ByteField.Init(new DeviceField(), "de_ecixunhuanbeng", 699,2,"二次循环泵"));

        map.put("de_yinfengji", ByteField.Init(new DeviceField(), "de_yinfengji", 701,2,"引风机"));

        map.put("de_gufengji", ByteField.Init(new DeviceField(), "de_gufengji", 703,2,"鼓风机"));

        map.put("de_lupai", ByteField.Init(new DeviceField(), "de_lupai", 705,2,"炉排"));

        map.put("de_chuzhaji", ByteField.Init(new DeviceField(), "de_chuzhaji", 707,2,"出渣机"));

        map.put("de_ecigufengji", ByteField.Init(new DeviceField(), "de_ecigufengji", 709,2,"二次鼓风机"));

        map.put("de_dianhuoqi", ByteField.Init(new DeviceField(), "de_dianhuoqi", 711,2,"点火器"));

        map.put("de_shangmeiji", ByteField.Init(new DeviceField(), "de_shangmeiji", 713,2,"上煤机"));

        map.put("de_songliaoji", ByteField.Init(new DeviceField(), "de_songliaoji", 715,2,"送料机"));

        map.put("de_jiayaobeng", ByteField.Init(new DeviceField(), "de_jiayaobeng", 717,2,"加药泵"));

        map.put("de_paiwufa", ByteField.Init(new DeviceField(), "de_paiwufa", 719,2,"排污阀"));

        map.put("de_huilu1xunhuanbeng", ByteField.Init(new DeviceField(), "de_huilu1xunhuanbeng", 721,2,"回路1循环泵"));

        map.put("de_huilu2xunhuanbeng", ByteField.Init(new DeviceField(), "de_huilu2xunhuanbeng", 723,2,"回路2循环泵"));

        map.put("de_huilu3xunhuanbeng", ByteField.Init(new DeviceField(), "de_huilu3xunhuanbeng", 725,2,"回路3循环泵"));

        map.put("de_huilu4xunhuanbeng", ByteField.Init(new DeviceField(), "de_huilu4xunhuanbeng", 727,2,"回路4循环泵"));

        map.put("de_huilu5xunhuanbeng", ByteField.Init(new DeviceField(), "de_huilu5xunhuanbeng", 729,2,"回路5循环泵"));
*/


    public static final String KEY_DEVICE_NO = "deviceNo";
    //region ----------设备固定参数---------
    //设备编号
    private String deviceNo;

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private String nickName;
    //endregion
    //region ----------设备设定参数相关属性----------
    //燃料类型
    private int power;
    //介质类型
    private int media;
    //运行状态
    private int runstatus;
    //设备运行天数
    private int runDays;
    //设备运行小时数
    private int runHours;
    //endregion
    //数据更新时间
    private long comeDate;
    //炉水温度  给水温度 蒸汽压力
    private float focusItem1, focusItem2, focusItem3;
    private String focusItem1Text,focusItem2Text,focusItem3Text;
    //出口温度高
    private int chuKouWenDuGao;
    //超压
    private int chaoYa;
    //炉水温度故障
    private int luShuiWenDuError;
    //高水位报警电极
    private int gaoShuiWeiBaoJingDianJi;
    //漏电报警信号
    private int   louDianBaoJingXinHao;
    //燃烧器启停报警
    private int  ranShaoQiQiTing ;
    //出渣机故障
    private int  chuZhaJi ;
    //
    private int  paiWuFa ;
    //
    private int  luShuiWenDu;
    //
    private int   ranLiaoWenDu;
    //
    private float   jiShuiYaLi;
    //
    private int xunHuanShuChuLiangSetting;
    //
    private float jiShuiWenDu;
    //
    private float zhengQiYaLi;
    //
    private int kaiBengWenDuSetting;
    //
    private int guanBengWenDuSetting;
    //
    private int luBiBaoJingWenDuSetting;
    //
    private int paiYanWenDuGao;
    //
    private int luShuiWenDuGao;
    //
    private int paiYanWenDuSetting;
    //
    private int baoJingWenDuSetting;
    //
    private int tingLuWenDuSetting;
    //
    private int muBiaoWenDuSetting;
    //
    private int qiLuWenDuSetting;
    //
    private int zhuanHuoHuiChaSetting;
    //
    private int qiLuHuiChaSetting;
    //
    private float baoJingYaLiSetting;
    //
    private float tingLuYaLiSetting;
    //
    private float muBiaoYaLiSetting;
    //
    private float qiLuYaLiSetting;
    //
    private float zhuanHuoHuiChaYaLiSetting;
    //
    private float qiLuHuiChaYaLiSetting;
    //
    private int qianYanShiSetting;
    //
    private int houYanShiSetting;
    //
    private int qianChuiSaoSetting;
    //
    private int houChuiSaoSetting;
    //
    private int luTangChuKouBaoJingWenDuSetting;
    //
    private int baoHuWenDuSetting;
    //
    private int benTiPaiYanWenDuBaoJingZhiSetting;
    //
    private int qiDongShiJian1Setting;
    //
    private int tingZhiShiJian1Setting;
    //
    private int qiDongShiJian2Setting;
    //
    private int tingZhiShiJian2Setting;
    //
    private int qiDongShiJian3Setting;
    //
    private int tingZhiShiJian3Setting;
    //
    private int qiDongShiJian4Setting;
    //
    private int tingZhiShiJian4Setting;
    //
    private int qiDongShiJian5Setting;
    //
    private int tingZhiShiJian5Setting;
    //
    private int qiDongShiJian6Setting;
    //
    private int tingZhiShiJian6Setting;
    //
    private int jiXianDiShuiWei;
    //
    private int diShuiWei;
    //
    private int gaoShuiWei;
    //
    private int shuiWeiXinHaoLuoJiCuo;
    //
    private int luBiWenDuGao;
    //
    private int fuYaZhengQiWenDuGao;
    //
    private int ranShaoQiGuZhang;
    //
    private int ranQiXieLou;
    //
    private int ranQiYaLiDi;
    //
    private int ranQiYaLiYiChang;
    //
    private int ranQiYaLiGao;
    //
    private int jiShuiBianPinQiGuZhang;
    //
    private int xunHuanBianPinQiGuZhang;
    //
    private int yinFengBianPinQiGuZhang;
    //
    private int guFengBianPinQiGuZhang;
    //
    private int eciGuFengBianPinQiGuZhang;
    //
    private int luPaiBianPinQiGuZhang;
    //
    private int jiShuiBengGuZhang;
    //
    private int xunHuanBengGuZhang;
    //
    private int xunHuanXiTongQianYa;
    //
    private int diDianYa;
    //
    private int gaoDianYa;
    //
    private int queXiang;
    //
    private int louDian;
    //
    private int bianSongQiGuoYaBaoHu;
    //
    private int guanJianCanShuYiChang;
    //
    private int sheDingCanShuYiChang;
    //
    private int shiZhongGuZhang;
    //
    private int cunChuQiGuZhang;
    //
    private int waiBuLianSuo;
    //
    private int queYou;
    //
    private int diYouWei;
    //
    private int benTiPaiYanWenDuGao;
    //
    private int benTiPaiYanWenDuError;
    //
    private int paiYanWenDuError;
    //
    private int chuKouWenDuError;
    //
    private int ruKouWenDuError;
    //
    private int jieNengQiChuKouWenDuError;
    //
    private int jieNengQiRuKouWenDuError;
    //
    private int jiShuiWenDuError;
    //
    private int luTangWenDuError;
    //
    private int luTangChuKouWenDuError;
    //
    private int luBiWenDuError;
    //
    private int ranLiaoWenDuError;
    //
    private int kongYuQiChuKouReFengWenDuError;
    //
    private int fuYaZhengQiWenDuError;
    //
    private int guoReZhengQiWenDuError;
    //
    private int huiLu1WenDuError;
    //
    private int huiLu2WenDuError;
    //
    private int huiLu3WenDuError;
    //
    private int huiLu4WenDuError;
    //
    private int huiLu5WenDuError;
    //
    private int shiWaiWenDuError;
    //
    private int zhengQiYaLiError;
    //
    private int jiShuiYaLiError;
    //
    private int chuKouYaLiError;
    //
    private int ruKouYaLiError;
    //
    private int luTangYaLiError;
    //
    private int luTangChuKouYaLiError;
    //
    private int ranQiYaLiError;
    //
    private int yiCiFengYaError;
    //
    private int eciFengYaError;
    //
    private int shunShiRanLiaoLiangError;
    //
    private int shunShiZhengQiLiuLiangError;
    //
    private int shunShiJiShuiLiuLiangError;
    //
    private int shunShiXunHuanLiuLiangError;
    //
    private int shunShiBuShuiLiuLiangError;
    //
    private int guoLuYeWeiError;
    //
    private int shuiXiangYeWeiError;
    //
    private int paiYanYangHanLiangError;
    //
    private int luPaiSuDuFanKuiError;
    //
    private int yinFengShuChuFanKuiError;
    //
    private int guFengShuChuFanKuiError;
    //
    private int jiShuiShuChuFanKuiError;
    //
    private int benTiPaiYanWenDu;
    //
    private int paiYanWenDu;
    //
    private int chuKouWenDu;
    //
    private int ruKouWenDu;
    //
    private int jieNengQiChuKouWenDu;
    //
    private int jieNengQiRuKouWenDu;
    //
    private int luTangWenDu;
    //
    private int luTangChuKouWenDu;
    //
    private int luBiWenDu;
    //
    private int kongYuQiChuKouReFengWenDu;
    //
    private int fuYaZhengQiWenDu;
    //
    private int guoReZhengQiWenDu;
    //
    private int huiLu1WenDu;
    //
    private int huiLu2WenDu;
    //
    private int huiLu3WenDu;
    //
    private int huiLu4WenDu;
    //
    private int huiLu5WenDu;
    //
    private int shiWaiWenDu;
    //
    private float chuKouYaLi;
    //
    private float ruKouYaLi;
    //
    private float luTangYaLi;
    //
    private float luTangChuKouYaLi;
    //
    private float ranQiYaLi;
    //
    private float yiCiFengYa;
    //
    private float eciFengYa;
    //
    private int shunShiRanLiaoLiang;
    //
    private int shunShiZhengQiLiuLiang;
    //
    private int shunShiJiShuiLiuLiang;
    //
    private int shunShiXunHuanLiuLiang;
    //
    private int shunShiBuShuiLiuLiang;
    //
    private int guoLuYeWei;
    //
    private int shuiXiangYeWei;
    //
    private float paiYanYangHanLiang;
    //
    private int luPaiSuDuFanKui;
    //
    private int yinFengShuChuFanKui;
    //
    private int guFengShuChuFanKui;
    //
    private int jiShuiShuChuFanKui;
    //
    private int ranShaoShuChuLiangSetting;
    //
    private int jiShuiShuChuLiangSetting;
    //
    private int yinFengShuChuLiangSetting;
    //
    private int guFengShuChuLiangSetting;
    //
    private int eciGuFengShuChuLiangSetting;
    //
    private int luPaiHuoJinLiaoShuChuLiangSetting;
    //
    private int jiXianDiShuiWeiBaoJingDianJi;
    //
    private int diShuiWeiBaoJingDianJi;
    //
    private int diShuiWeiDianJi;
    //
    private int zhongShuiWeiDianJi;
    //
    private int gaoShuiWeiDianJi;
    //
    private int shuiXiangDiWeiDianJi;
    //
    private int shuiXiangGaoWeiDianJi;
    //
    private int jiXianDiYeWeiBaoJingXinHao;
    //
    private int diBaoJingXinHao;
    //
    private int kongBengXinHao;
    //
    private int gaoBaoJingXinHao;
    //
    private int chaoYaBaoJingXinHao;
    //
    private int fuHeDiaoJieYaLiXinHao;
    //
    private int qiTingKongZhiYaLiXinHao;
    //
    private int yaLiBiaoDiZhen;
    //
    private int yaLiBiaoGaoZhen;
    //
    private int luBiChaoWenXinHao;
    //
    private int ranShaoQiGuZhangBaoJingXinHao;
    //
    private int ranQiXieLouBaoJingXinHao;
    //
    private int ranQiYaLiDiBaoJingXinHao;
    //
    private int ranQiYaLiYiChangBaoJingXinHao;
    //
    private int ranQiYaLiGaoBaoJingXinHao;
    //
    private int xunHuanBengDongZuoFanKuiXinHao;
    //
    private int xunHuanBengDongZuoFanKuiXinHaoBei;
    //
    private int jiShuiBengDongZuoFanKuiXinHao;
    //
    private int jiShuiBengDongZuoFanKuiXinHaoBei;
    //
    private int yinFengJiDongZuoFanKuiXinHao;
    //
    private int guFengJiDongZuoFanKuiXinHao;
    //
    private int eciGuFengJiDongZuoFanKuiXinHao;
    //
    private int chuZhaJiDongZuoFanKuiXinHao;
    //
    private int jiShuiBianPinQiGuZhangXinHao;
    //
    private int yinFengBianPinQiGuZhangXinHao;
    //
    private int guFengBianPinQiGuZhangXinHao;
    //
    private int luPaiBianPinQiGuZhangXinHao;
    //
    private int yanDaoDieFaFanKuiXinHao;
    //
    private int diDianYaBaoJingXinHao;
    //
    private int gaoDianYaBaoJingXinHao;
    //
    private int queXiangBaoJingXinHao;
    //
    private int queShuiDianJi2;
    //
    private int waiBuLianSuoXinHao;
    //
    private int chaoDiYaBaoHuXinHao;
    //
    private int ranShaoQiDaHuo;
    //
    private int ranShaoQiSanDuanHuo;
    //
    private int ranShaoQiHuoLiZengJia;
    //
    private int ranShaoQiHuoLiJianShao;
    //
    private int jiShuiBengZhu;
    //
    private int jiShuiBengBei;
    //
    private int jiShuiLiangZengJia;
    //
    private int jiShuiLiangJianShao;
    //
    private int xunHuanBeng;
    //
    private int xunHuanBengBei;
    //
    private int baoJingShuChu;
    //
    private int jiaReZu1;
    //
    private int jiaReZu2;
    //
    private int jiaReZu3;
    //
    private int jiaReZu4;
    //
    private int jiaReZu5;
    //
    private int jiaReZu6 ;
    //
    private int jiaReZu7;
    //
    private int jiaReZu8;
    //
    private int jiaReZu9;
    //
    private int jiaReZu10;
    //
    private int jiaReZu11;
    //
    private int jiaReZu12;
    //
    private int jiaReZu13;
    //
    private int jiaReZu14;
    //
    private int jiaReZu15;
    //
    private int jiaReZu16;
    //
    private int jiaReZu17;
    //
    private int jiaReZu18;
    //
    private int jiaReZu19;
    //
    private int jiaReZu20;
    //
    private int jiaReZu21;
    //
    private int jiaReZu22;
    //
    private int jiaReZu23;
    //
    private int jiaReZu24;
    //
    private int jiaReZu25;
    //
    private int jiaReZu26;
    //
    private int jiaReZu27;
    //
    private int jiaReZu28;
    //
    private int jiaReZu29;
    //
    private int jiaReZu30;
    //
    private int yinFengJi;
    //
    private int yinFengLiangZengJia;
    //
    private int yinFengLiangJianShao;
    //
    private int guFengJi;
    //
    private int guFengLiangZengJia;
    //
    private int guFengLiangJianShao;
    //
    private int eciGuFengJi;
    //
    private int eciGuFengLiangZengJia;
    //
    private int eciGuFengLiangJianShao;
    //
    private int luPaiHuoJinLiaoJiZhengZhuan;
    //
    private int luPaiFanZhuan;
    //
    private int dianHuoQi;
    //
    private int jiaYaoBeng;
    //
    private int alarmCount;
    //
    private int errorCount;

    public static String getKeyDeviceNo() {
        return KEY_DEVICE_NO;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public int getRunstatus() {
        return runstatus;
    }

    public void setRunstatus(int runstatus) {
        this.runstatus = runstatus;
    }

    public int getRunDays() {
        return runDays;
    }

    public void setRunDays(int runDays) {
        this.runDays = runDays;
    }

    public int getRunHours() {
        return runHours;
    }

    public void setRunHours(int runHours) {
        this.runHours = runHours;
    }

    public long getComeDate() {
        return comeDate;
    }

    public void setComeDate(long comeDate) {
        this.comeDate = comeDate;
    }

    public float getFocusItem1() {
        return focusItem1;
    }

    public void setFocusItem1(float focusItem1) {
        this.focusItem1 = focusItem1;
    }

    public float getFocusItem2() {
        return focusItem2;
    }

    public void setFocusItem2(float focusItem2) {
        this.focusItem2 = focusItem2;
    }

    public float getFocusItem3() {
        return focusItem3;
    }

    public void setFocusItem3(float focusItem3) {
        this.focusItem3 = focusItem3;
    }

    public String getFocusItem1Text() {
        return focusItem1Text;
    }

    public void setFocusItem1Text(String focusItem1Text) {
        this.focusItem1Text = focusItem1Text;
    }

    public String getFocusItem2Text() {
        return focusItem2Text;
    }

    public void setFocusItem2Text(String focusItem2Text) {
        this.focusItem2Text = focusItem2Text;
    }

    public String getFocusItem3Text() {
        return focusItem3Text;
    }

    public void setFocusItem3Text(String focusItem3Text) {
        this.focusItem3Text = focusItem3Text;
    }

    public int getChuKouWenDuGao() {
        return chuKouWenDuGao;
    }

    public void setChuKouWenDuGao(int chuKouWenDuGao) {
        this.chuKouWenDuGao = chuKouWenDuGao;
    }

    public int getChaoYa() {
        return chaoYa;
    }

    public void setChaoYa(int chaoYa) {
        this.chaoYa = chaoYa;
    }

    public int getLuShuiWenDuError() {
        return luShuiWenDuError;
    }

    public void setLuShuiWenDuError(int luShuiWenDuError) {
        this.luShuiWenDuError = luShuiWenDuError;
    }

    public int getGaoShuiWeiBaoJingDianJi() {
        return gaoShuiWeiBaoJingDianJi;
    }

    public void setGaoShuiWeiBaoJingDianJi(int gaoShuiWeiBaoJingDianJi) {
        this.gaoShuiWeiBaoJingDianJi = gaoShuiWeiBaoJingDianJi;
    }

    public int getLouDianBaoJingXinHao() {
        return louDianBaoJingXinHao;
    }

    public void setLouDianBaoJingXinHao(int louDianBaoJingXinHao) {
        this.louDianBaoJingXinHao = louDianBaoJingXinHao;
    }

    public int getRanShaoQiQiTing() {
        return ranShaoQiQiTing;
    }

    public void setRanShaoQiQiTing(int ranShaoQiQiTing) {
        this.ranShaoQiQiTing = ranShaoQiQiTing;
    }

    public int getChuZhaJi() {
        return chuZhaJi;
    }

    public void setChuZhaJi(int chuZhaJi) {
        this.chuZhaJi = chuZhaJi;
    }

    public int getPaiWuFa() {
        return paiWuFa;
    }

    public void setPaiWuFa(int paiWuFa) {
        this.paiWuFa = paiWuFa;
    }

    public int getLuShuiWenDu() {
        return luShuiWenDu;
    }

    public void setLuShuiWenDu(int luShuiWenDu) {
        this.luShuiWenDu = luShuiWenDu;
    }

    public int getRanLiaoWenDu() {
        return ranLiaoWenDu;
    }

    public void setRanLiaoWenDu(int ranLiaoWenDu) {
        this.ranLiaoWenDu = ranLiaoWenDu;
    }

    public float getJiShuiYaLi() {
        return jiShuiYaLi;
    }

    public void setJiShuiYaLi(float jiShuiYaLi) {
        this.jiShuiYaLi = jiShuiYaLi;
    }

    public int getXunHuanShuChuLiangSetting() {
        return xunHuanShuChuLiangSetting;
    }

    public void setXunHuanShuChuLiangSetting(int xunHuanShuChuLiangSetting) {
        this.xunHuanShuChuLiangSetting = xunHuanShuChuLiangSetting;
    }

    public float getJiShuiWenDu() {
        return jiShuiWenDu;
    }

    public void setJiShuiWenDu(float jiShuiWenDu) {
        this.jiShuiWenDu = jiShuiWenDu;
    }

    public float getZhengQiYaLi() {
        return zhengQiYaLi;
    }

    public void setZhengQiYaLi(float zhengQiYaLi) {
        this.zhengQiYaLi = zhengQiYaLi;
    }

    public int getKaiBengWenDuSetting() {
        return kaiBengWenDuSetting;
    }

    public void setKaiBengWenDuSetting(int kaiBengWenDuSetting) {
        this.kaiBengWenDuSetting = kaiBengWenDuSetting;
    }

    public int getGuanBengWenDuSetting() {
        return guanBengWenDuSetting;
    }

    public void setGuanBengWenDuSetting(int guanBengWenDuSetting) {
        this.guanBengWenDuSetting = guanBengWenDuSetting;
    }

    public int getLuBiBaoJingWenDuSetting() {
        return luBiBaoJingWenDuSetting;
    }

    public void setLuBiBaoJingWenDuSetting(int luBiBaoJingWenDuSetting) {
        this.luBiBaoJingWenDuSetting = luBiBaoJingWenDuSetting;
    }

    public int getPaiYanWenDuGao() {
        return paiYanWenDuGao;
    }

    public void setPaiYanWenDuGao(int paiYanWenDuGao) {
        this.paiYanWenDuGao = paiYanWenDuGao;
    }

    public int getLuShuiWenDuGao() {
        return luShuiWenDuGao;
    }

    public void setLuShuiWenDuGao(int luShuiWenDuGao) {
        this.luShuiWenDuGao = luShuiWenDuGao;
    }

    public int getPaiYanWenDuSetting() {
        return paiYanWenDuSetting;
    }

    public void setPaiYanWenDuSetting(int paiYanWenDuSetting) {
        this.paiYanWenDuSetting = paiYanWenDuSetting;
    }

    public int getBaoJingWenDuSetting() {
        return baoJingWenDuSetting;
    }

    public void setBaoJingWenDuSetting(int baoJingWenDuSetting) {
        this.baoJingWenDuSetting = baoJingWenDuSetting;
    }

    public int getTingLuWenDuSetting() {
        return tingLuWenDuSetting;
    }

    public void setTingLuWenDuSetting(int tingLuWenDuSetting) {
        this.tingLuWenDuSetting = tingLuWenDuSetting;
    }

    public int getMuBiaoWenDuSetting() {
        return muBiaoWenDuSetting;
    }

    public void setMuBiaoWenDuSetting(int muBiaoWenDuSetting) {
        this.muBiaoWenDuSetting = muBiaoWenDuSetting;
    }

    public int getQiLuWenDuSetting() {
        return qiLuWenDuSetting;
    }

    public void setQiLuWenDuSetting(int qiLuWenDuSetting) {
        this.qiLuWenDuSetting = qiLuWenDuSetting;
    }

    public int getZhuanHuoHuiChaSetting() {
        return zhuanHuoHuiChaSetting;
    }

    public void setZhuanHuoHuiChaSetting(int zhuanHuoHuiChaSetting) {
        this.zhuanHuoHuiChaSetting = zhuanHuoHuiChaSetting;
    }

    public int getQiLuHuiChaSetting() {
        return qiLuHuiChaSetting;
    }

    public void setQiLuHuiChaSetting(int qiLuHuiChaSetting) {
        this.qiLuHuiChaSetting = qiLuHuiChaSetting;
    }

    public float getBaoJingYaLiSetting() {
        return baoJingYaLiSetting;
    }

    public void setBaoJingYaLiSetting(float baoJingYaLiSetting) {
        this.baoJingYaLiSetting = baoJingYaLiSetting;
    }

    public float getTingLuYaLiSetting() {
        return tingLuYaLiSetting;
    }

    public void setTingLuYaLiSetting(float tingLuYaLiSetting) {
        this.tingLuYaLiSetting = tingLuYaLiSetting;
    }

    public float getMuBiaoYaLiSetting() {
        return muBiaoYaLiSetting;
    }

    public void setMuBiaoYaLiSetting(float muBiaoYaLiSetting) {
        this.muBiaoYaLiSetting = muBiaoYaLiSetting;
    }

    public float getQiLuYaLiSetting() {
        return qiLuYaLiSetting;
    }

    public void setQiLuYaLiSetting(float qiLuYaLiSetting) {
        this.qiLuYaLiSetting = qiLuYaLiSetting;
    }

    public float getZhuanHuoHuiChaYaLiSetting() {
        return zhuanHuoHuiChaYaLiSetting;
    }

    public void setZhuanHuoHuiChaYaLiSetting(float zhuanHuoHuiChaYaLiSetting) {
        this.zhuanHuoHuiChaYaLiSetting = zhuanHuoHuiChaYaLiSetting;
    }

    public float getQiLuHuiChaYaLiSetting() {
        return qiLuHuiChaYaLiSetting;
    }

    public void setQiLuHuiChaYaLiSetting(float qiLuHuiChaYaLiSetting) {
        this.qiLuHuiChaYaLiSetting = qiLuHuiChaYaLiSetting;
    }

    public int getQianYanShiSetting() {
        return qianYanShiSetting;
    }

    public void setQianYanShiSetting(int qianYanShiSetting) {
        this.qianYanShiSetting = qianYanShiSetting;
    }

    public int getHouYanShiSetting() {
        return houYanShiSetting;
    }

    public void setHouYanShiSetting(int houYanShiSetting) {
        this.houYanShiSetting = houYanShiSetting;
    }

    public int getQianChuiSaoSetting() {
        return qianChuiSaoSetting;
    }

    public void setQianChuiSaoSetting(int qianChuiSaoSetting) {
        this.qianChuiSaoSetting = qianChuiSaoSetting;
    }

    public int getHouChuiSaoSetting() {
        return houChuiSaoSetting;
    }

    public void setHouChuiSaoSetting(int houChuiSaoSetting) {
        this.houChuiSaoSetting = houChuiSaoSetting;
    }

    public int getLuTangChuKouBaoJingWenDuSetting() {
        return luTangChuKouBaoJingWenDuSetting;
    }

    public void setLuTangChuKouBaoJingWenDuSetting(int luTangChuKouBaoJingWenDuSetting) {
        this.luTangChuKouBaoJingWenDuSetting = luTangChuKouBaoJingWenDuSetting;
    }

    public int getBaoHuWenDuSetting() {
        return baoHuWenDuSetting;
    }

    public void setBaoHuWenDuSetting(int baoHuWenDuSetting) {
        this.baoHuWenDuSetting = baoHuWenDuSetting;
    }

    public int getBenTiPaiYanWenDuBaoJingZhiSetting() {
        return benTiPaiYanWenDuBaoJingZhiSetting;
    }

    public void setBenTiPaiYanWenDuBaoJingZhiSetting(int benTiPaiYanWenDuBaoJingZhiSetting) {
        this.benTiPaiYanWenDuBaoJingZhiSetting = benTiPaiYanWenDuBaoJingZhiSetting;
    }

    public int getQiDongShiJian1Setting() {
        return qiDongShiJian1Setting;
    }

    public void setQiDongShiJian1Setting(int qiDongShiJian1Setting) {
        this.qiDongShiJian1Setting = qiDongShiJian1Setting;
    }

    public int getTingZhiShiJian1Setting() {
        return tingZhiShiJian1Setting;
    }

    public void setTingZhiShiJian1Setting(int tingZhiShiJian1Setting) {
        this.tingZhiShiJian1Setting = tingZhiShiJian1Setting;
    }

    public int getQiDongShiJian2Setting() {
        return qiDongShiJian2Setting;
    }

    public void setQiDongShiJian2Setting(int qiDongShiJian2Setting) {
        this.qiDongShiJian2Setting = qiDongShiJian2Setting;
    }

    public int getTingZhiShiJian2Setting() {
        return tingZhiShiJian2Setting;
    }

    public void setTingZhiShiJian2Setting(int tingZhiShiJian2Setting) {
        this.tingZhiShiJian2Setting = tingZhiShiJian2Setting;
    }

    public int getQiDongShiJian3Setting() {
        return qiDongShiJian3Setting;
    }

    public void setQiDongShiJian3Setting(int qiDongShiJian3Setting) {
        this.qiDongShiJian3Setting = qiDongShiJian3Setting;
    }

    public int getTingZhiShiJian3Setting() {
        return tingZhiShiJian3Setting;
    }

    public void setTingZhiShiJian3Setting(int tingZhiShiJian3Setting) {
        this.tingZhiShiJian3Setting = tingZhiShiJian3Setting;
    }

    public int getQiDongShiJian4Setting() {
        return qiDongShiJian4Setting;
    }

    public void setQiDongShiJian4Setting(int qiDongShiJian4Setting) {
        this.qiDongShiJian4Setting = qiDongShiJian4Setting;
    }

    public int getTingZhiShiJian4Setting() {
        return tingZhiShiJian4Setting;
    }

    public void setTingZhiShiJian4Setting(int tingZhiShiJian4Setting) {
        this.tingZhiShiJian4Setting = tingZhiShiJian4Setting;
    }

    public int getQiDongShiJian5Setting() {
        return qiDongShiJian5Setting;
    }

    public void setQiDongShiJian5Setting(int qiDongShiJian5Setting) {
        this.qiDongShiJian5Setting = qiDongShiJian5Setting;
    }

    public int getTingZhiShiJian5Setting() {
        return tingZhiShiJian5Setting;
    }

    public void setTingZhiShiJian5Setting(int tingZhiShiJian5Setting) {
        this.tingZhiShiJian5Setting = tingZhiShiJian5Setting;
    }

    public int getQiDongShiJian6Setting() {
        return qiDongShiJian6Setting;
    }

    public void setQiDongShiJian6Setting(int qiDongShiJian6Setting) {
        this.qiDongShiJian6Setting = qiDongShiJian6Setting;
    }

    public int getTingZhiShiJian6Setting() {
        return tingZhiShiJian6Setting;
    }

    public void setTingZhiShiJian6Setting(int tingZhiShiJian6Setting) {
        this.tingZhiShiJian6Setting = tingZhiShiJian6Setting;
    }

    public int getJiXianDiShuiWei() {
        return jiXianDiShuiWei;
    }

    public void setJiXianDiShuiWei(int jiXianDiShuiWei) {
        this.jiXianDiShuiWei = jiXianDiShuiWei;
    }

    public int getDiShuiWei() {
        return diShuiWei;
    }

    public void setDiShuiWei(int diShuiWei) {
        this.diShuiWei = diShuiWei;
    }

    public int getGaoShuiWei() {
        return gaoShuiWei;
    }

    public void setGaoShuiWei(int gaoShuiWei) {
        this.gaoShuiWei = gaoShuiWei;
    }

    public int getShuiWeiXinHaoLuoJiCuo() {
        return shuiWeiXinHaoLuoJiCuo;
    }

    public void setShuiWeiXinHaoLuoJiCuo(int shuiWeiXinHaoLuoJiCuo) {
        this.shuiWeiXinHaoLuoJiCuo = shuiWeiXinHaoLuoJiCuo;
    }

    public int getLuBiWenDuGao() {
        return luBiWenDuGao;
    }

    public void setLuBiWenDuGao(int luBiWenDuGao) {
        this.luBiWenDuGao = luBiWenDuGao;
    }

    public int getFuYaZhengQiWenDuGao() {
        return fuYaZhengQiWenDuGao;
    }

    public void setFuYaZhengQiWenDuGao(int fuYaZhengQiWenDuGao) {
        this.fuYaZhengQiWenDuGao = fuYaZhengQiWenDuGao;
    }

    public int getRanShaoQiGuZhang() {
        return ranShaoQiGuZhang;
    }

    public void setRanShaoQiGuZhang(int ranShaoQiGuZhang) {
        this.ranShaoQiGuZhang = ranShaoQiGuZhang;
    }

    public int getRanQiXieLou() {
        return ranQiXieLou;
    }

    public void setRanQiXieLou(int ranQiXieLou) {
        this.ranQiXieLou = ranQiXieLou;
    }

    public int getRanQiYaLiDi() {
        return ranQiYaLiDi;
    }

    public void setRanQiYaLiDi(int ranQiYaLiDi) {
        this.ranQiYaLiDi = ranQiYaLiDi;
    }

    public int getRanQiYaLiYiChang() {
        return ranQiYaLiYiChang;
    }

    public void setRanQiYaLiYiChang(int ranQiYaLiYiChang) {
        this.ranQiYaLiYiChang = ranQiYaLiYiChang;
    }

    public int getRanQiYaLiGao() {
        return ranQiYaLiGao;
    }

    public void setRanQiYaLiGao(int ranQiYaLiGao) {
        this.ranQiYaLiGao = ranQiYaLiGao;
    }

    public int getJiShuiBianPinQiGuZhang() {
        return jiShuiBianPinQiGuZhang;
    }

    public void setJiShuiBianPinQiGuZhang(int jiShuiBianPinQiGuZhang) {
        this.jiShuiBianPinQiGuZhang = jiShuiBianPinQiGuZhang;
    }

    public int getXunHuanBianPinQiGuZhang() {
        return xunHuanBianPinQiGuZhang;
    }

    public void setXunHuanBianPinQiGuZhang(int xunHuanBianPinQiGuZhang) {
        this.xunHuanBianPinQiGuZhang = xunHuanBianPinQiGuZhang;
    }

    public int getYinFengBianPinQiGuZhang() {
        return yinFengBianPinQiGuZhang;
    }

    public void setYinFengBianPinQiGuZhang(int yinFengBianPinQiGuZhang) {
        this.yinFengBianPinQiGuZhang = yinFengBianPinQiGuZhang;
    }

    public int getGuFengBianPinQiGuZhang() {
        return guFengBianPinQiGuZhang;
    }

    public void setGuFengBianPinQiGuZhang(int guFengBianPinQiGuZhang) {
        this.guFengBianPinQiGuZhang = guFengBianPinQiGuZhang;
    }

    public int getEciGuFengBianPinQiGuZhang() {
        return eciGuFengBianPinQiGuZhang;
    }

    public void setEciGuFengBianPinQiGuZhang(int eciGuFengBianPinQiGuZhang) {
        this.eciGuFengBianPinQiGuZhang = eciGuFengBianPinQiGuZhang;
    }

    public int getLuPaiBianPinQiGuZhang() {
        return luPaiBianPinQiGuZhang;
    }

    public void setLuPaiBianPinQiGuZhang(int luPaiBianPinQiGuZhang) {
        this.luPaiBianPinQiGuZhang = luPaiBianPinQiGuZhang;
    }

    public int getJiShuiBengGuZhang() {
        return jiShuiBengGuZhang;
    }

    public void setJiShuiBengGuZhang(int jiShuiBengGuZhang) {
        this.jiShuiBengGuZhang = jiShuiBengGuZhang;
    }

    public int getXunHuanBengGuZhang() {
        return xunHuanBengGuZhang;
    }

    public void setXunHuanBengGuZhang(int xunHuanBengGuZhang) {
        this.xunHuanBengGuZhang = xunHuanBengGuZhang;
    }

    public int getXunHuanXiTongQianYa() {
        return xunHuanXiTongQianYa;
    }

    public void setXunHuanXiTongQianYa(int xunHuanXiTongQianYa) {
        this.xunHuanXiTongQianYa = xunHuanXiTongQianYa;
    }

    public int getDiDianYa() {
        return diDianYa;
    }

    public void setDiDianYa(int diDianYa) {
        this.diDianYa = diDianYa;
    }

    public int getGaoDianYa() {
        return gaoDianYa;
    }

    public void setGaoDianYa(int gaoDianYa) {
        this.gaoDianYa = gaoDianYa;
    }

    public int getQueXiang() {
        return queXiang;
    }

    public void setQueXiang(int queXiang) {
        this.queXiang = queXiang;
    }

    public int getLouDian() {
        return louDian;
    }

    public void setLouDian(int louDian) {
        this.louDian = louDian;
    }

    public int getBianSongQiGuoYaBaoHu() {
        return bianSongQiGuoYaBaoHu;
    }

    public void setBianSongQiGuoYaBaoHu(int bianSongQiGuoYaBaoHu) {
        this.bianSongQiGuoYaBaoHu = bianSongQiGuoYaBaoHu;
    }

    public int getGuanJianCanShuYiChang() {
        return guanJianCanShuYiChang;
    }

    public void setGuanJianCanShuYiChang(int guanJianCanShuYiChang) {
        this.guanJianCanShuYiChang = guanJianCanShuYiChang;
    }

    public int getSheDingCanShuYiChang() {
        return sheDingCanShuYiChang;
    }

    public void setSheDingCanShuYiChang(int sheDingCanShuYiChang) {
        this.sheDingCanShuYiChang = sheDingCanShuYiChang;
    }

    public int getShiZhongGuZhang() {
        return shiZhongGuZhang;
    }

    public void setShiZhongGuZhang(int shiZhongGuZhang) {
        this.shiZhongGuZhang = shiZhongGuZhang;
    }

    public int getCunChuQiGuZhang() {
        return cunChuQiGuZhang;
    }

    public void setCunChuQiGuZhang(int cunChuQiGuZhang) {
        this.cunChuQiGuZhang = cunChuQiGuZhang;
    }

    public int getWaiBuLianSuo() {
        return waiBuLianSuo;
    }

    public void setWaiBuLianSuo(int waiBuLianSuo) {
        this.waiBuLianSuo = waiBuLianSuo;
    }

    public int getQueYou() {
        return queYou;
    }

    public void setQueYou(int queYou) {
        this.queYou = queYou;
    }

    public int getDiYouWei() {
        return diYouWei;
    }

    public void setDiYouWei(int diYouWei) {
        this.diYouWei = diYouWei;
    }

    public int getBenTiPaiYanWenDuGao() {
        return benTiPaiYanWenDuGao;
    }

    public void setBenTiPaiYanWenDuGao(int benTiPaiYanWenDuGao) {
        this.benTiPaiYanWenDuGao = benTiPaiYanWenDuGao;
    }

    public int getBenTiPaiYanWenDuError() {
        return benTiPaiYanWenDuError;
    }

    public void setBenTiPaiYanWenDuError(int benTiPaiYanWenDuError) {
        this.benTiPaiYanWenDuError = benTiPaiYanWenDuError;
    }

    public int getPaiYanWenDuError() {
        return paiYanWenDuError;
    }

    public void setPaiYanWenDuError(int paiYanWenDuError) {
        this.paiYanWenDuError = paiYanWenDuError;
    }

    public int getChuKouWenDuError() {
        return chuKouWenDuError;
    }

    public void setChuKouWenDuError(int chuKouWenDuError) {
        this.chuKouWenDuError = chuKouWenDuError;
    }

    public int getRuKouWenDuError() {
        return ruKouWenDuError;
    }

    public void setRuKouWenDuError(int ruKouWenDuError) {
        this.ruKouWenDuError = ruKouWenDuError;
    }

    public int getJieNengQiChuKouWenDuError() {
        return jieNengQiChuKouWenDuError;
    }

    public void setJieNengQiChuKouWenDuError(int jieNengQiChuKouWenDuError) {
        this.jieNengQiChuKouWenDuError = jieNengQiChuKouWenDuError;
    }

    public int getJieNengQiRuKouWenDuError() {
        return jieNengQiRuKouWenDuError;
    }

    public void setJieNengQiRuKouWenDuError(int jieNengQiRuKouWenDuError) {
        this.jieNengQiRuKouWenDuError = jieNengQiRuKouWenDuError;
    }

    public int getJiShuiWenDuError() {
        return jiShuiWenDuError;
    }

    public void setJiShuiWenDuError(int jiShuiWenDuError) {
        this.jiShuiWenDuError = jiShuiWenDuError;
    }

    public int getLuTangWenDuError() {
        return luTangWenDuError;
    }

    public void setLuTangWenDuError(int luTangWenDuError) {
        this.luTangWenDuError = luTangWenDuError;
    }

    public int getLuTangChuKouWenDuError() {
        return luTangChuKouWenDuError;
    }

    public void setLuTangChuKouWenDuError(int luTangChuKouWenDuError) {
        this.luTangChuKouWenDuError = luTangChuKouWenDuError;
    }

    public int getLuBiWenDuError() {
        return luBiWenDuError;
    }

    public void setLuBiWenDuError(int luBiWenDuError) {
        this.luBiWenDuError = luBiWenDuError;
    }

    public int getRanLiaoWenDuError() {
        return ranLiaoWenDuError;
    }

    public void setRanLiaoWenDuError(int ranLiaoWenDuError) {
        this.ranLiaoWenDuError = ranLiaoWenDuError;
    }

    public int getKongYuQiChuKouReFengWenDuError() {
        return kongYuQiChuKouReFengWenDuError;
    }

    public void setKongYuQiChuKouReFengWenDuError(int kongYuQiChuKouReFengWenDuError) {
        this.kongYuQiChuKouReFengWenDuError = kongYuQiChuKouReFengWenDuError;
    }

    public int getFuYaZhengQiWenDuError() {
        return fuYaZhengQiWenDuError;
    }

    public void setFuYaZhengQiWenDuError(int fuYaZhengQiWenDuError) {
        this.fuYaZhengQiWenDuError = fuYaZhengQiWenDuError;
    }

    public int getGuoReZhengQiWenDuError() {
        return guoReZhengQiWenDuError;
    }

    public void setGuoReZhengQiWenDuError(int guoReZhengQiWenDuError) {
        this.guoReZhengQiWenDuError = guoReZhengQiWenDuError;
    }

    public int getHuiLu1WenDuError() {
        return huiLu1WenDuError;
    }

    public void setHuiLu1WenDuError(int huiLu1WenDuError) {
        this.huiLu1WenDuError = huiLu1WenDuError;
    }

    public int getHuiLu2WenDuError() {
        return huiLu2WenDuError;
    }

    public void setHuiLu2WenDuError(int huiLu2WenDuError) {
        this.huiLu2WenDuError = huiLu2WenDuError;
    }

    public int getHuiLu3WenDuError() {
        return huiLu3WenDuError;
    }

    public void setHuiLu3WenDuError(int huiLu3WenDuError) {
        this.huiLu3WenDuError = huiLu3WenDuError;
    }

    public int getHuiLu4WenDuError() {
        return huiLu4WenDuError;
    }

    public void setHuiLu4WenDuError(int huiLu4WenDuError) {
        this.huiLu4WenDuError = huiLu4WenDuError;
    }

    public int getHuiLu5WenDuError() {
        return huiLu5WenDuError;
    }

    public void setHuiLu5WenDuError(int huiLu5WenDuError) {
        this.huiLu5WenDuError = huiLu5WenDuError;
    }

    public int getShiWaiWenDuError() {
        return shiWaiWenDuError;
    }

    public void setShiWaiWenDuError(int shiWaiWenDuError) {
        this.shiWaiWenDuError = shiWaiWenDuError;
    }

    public int getZhengQiYaLiError() {
        return zhengQiYaLiError;
    }

    public void setZhengQiYaLiError(int zhengQiYaLiError) {
        this.zhengQiYaLiError = zhengQiYaLiError;
    }

    public int getJiShuiYaLiError() {
        return jiShuiYaLiError;
    }

    public void setJiShuiYaLiError(int jiShuiYaLiError) {
        this.jiShuiYaLiError = jiShuiYaLiError;
    }

    public int getChuKouYaLiError() {
        return chuKouYaLiError;
    }

    public void setChuKouYaLiError(int chuKouYaLiError) {
        this.chuKouYaLiError = chuKouYaLiError;
    }

    public int getRuKouYaLiError() {
        return ruKouYaLiError;
    }

    public void setRuKouYaLiError(int ruKouYaLiError) {
        this.ruKouYaLiError = ruKouYaLiError;
    }

    public int getLuTangYaLiError() {
        return luTangYaLiError;
    }

    public void setLuTangYaLiError(int luTangYaLiError) {
        this.luTangYaLiError = luTangYaLiError;
    }

    public int getLuTangChuKouYaLiError() {
        return luTangChuKouYaLiError;
    }

    public void setLuTangChuKouYaLiError(int luTangChuKouYaLiError) {
        this.luTangChuKouYaLiError = luTangChuKouYaLiError;
    }

    public int getRanQiYaLiError() {
        return ranQiYaLiError;
    }

    public void setRanQiYaLiError(int ranQiYaLiError) {
        this.ranQiYaLiError = ranQiYaLiError;
    }

    public int getYiCiFengYaError() {
        return yiCiFengYaError;
    }

    public void setYiCiFengYaError(int yiCiFengYaError) {
        this.yiCiFengYaError = yiCiFengYaError;
    }

    public int getEciFengYaError() {
        return eciFengYaError;
    }

    public void setEciFengYaError(int eciFengYaError) {
        this.eciFengYaError = eciFengYaError;
    }

    public int getShunShiRanLiaoLiangError() {
        return shunShiRanLiaoLiangError;
    }

    public void setShunShiRanLiaoLiangError(int shunShiRanLiaoLiangError) {
        this.shunShiRanLiaoLiangError = shunShiRanLiaoLiangError;
    }

    public int getShunShiZhengQiLiuLiangError() {
        return shunShiZhengQiLiuLiangError;
    }

    public void setShunShiZhengQiLiuLiangError(int shunShiZhengQiLiuLiangError) {
        this.shunShiZhengQiLiuLiangError = shunShiZhengQiLiuLiangError;
    }

    public int getShunShiJiShuiLiuLiangError() {
        return shunShiJiShuiLiuLiangError;
    }

    public void setShunShiJiShuiLiuLiangError(int shunShiJiShuiLiuLiangError) {
        this.shunShiJiShuiLiuLiangError = shunShiJiShuiLiuLiangError;
    }

    public int getShunShiXunHuanLiuLiangError() {
        return shunShiXunHuanLiuLiangError;
    }

    public void setShunShiXunHuanLiuLiangError(int shunShiXunHuanLiuLiangError) {
        this.shunShiXunHuanLiuLiangError = shunShiXunHuanLiuLiangError;
    }

    public int getShunShiBuShuiLiuLiangError() {
        return shunShiBuShuiLiuLiangError;
    }

    public void setShunShiBuShuiLiuLiangError(int shunShiBuShuiLiuLiangError) {
        this.shunShiBuShuiLiuLiangError = shunShiBuShuiLiuLiangError;
    }

    public int getGuoLuYeWeiError() {
        return guoLuYeWeiError;
    }

    public void setGuoLuYeWeiError(int guoLuYeWeiError) {
        this.guoLuYeWeiError = guoLuYeWeiError;
    }

    public int getShuiXiangYeWeiError() {
        return shuiXiangYeWeiError;
    }

    public void setShuiXiangYeWeiError(int shuiXiangYeWeiError) {
        this.shuiXiangYeWeiError = shuiXiangYeWeiError;
    }

    public int getPaiYanYangHanLiangError() {
        return paiYanYangHanLiangError;
    }

    public void setPaiYanYangHanLiangError(int paiYanYangHanLiangError) {
        this.paiYanYangHanLiangError = paiYanYangHanLiangError;
    }

    public int getLuPaiSuDuFanKuiError() {
        return luPaiSuDuFanKuiError;
    }

    public void setLuPaiSuDuFanKuiError(int luPaiSuDuFanKuiError) {
        this.luPaiSuDuFanKuiError = luPaiSuDuFanKuiError;
    }

    public int getYinFengShuChuFanKuiError() {
        return yinFengShuChuFanKuiError;
    }

    public void setYinFengShuChuFanKuiError(int yinFengShuChuFanKuiError) {
        this.yinFengShuChuFanKuiError = yinFengShuChuFanKuiError;
    }

    public int getGuFengShuChuFanKuiError() {
        return guFengShuChuFanKuiError;
    }

    public void setGuFengShuChuFanKuiError(int guFengShuChuFanKuiError) {
        this.guFengShuChuFanKuiError = guFengShuChuFanKuiError;
    }

    public int getJiShuiShuChuFanKuiError() {
        return jiShuiShuChuFanKuiError;
    }

    public void setJiShuiShuChuFanKuiError(int jiShuiShuChuFanKuiError) {
        this.jiShuiShuChuFanKuiError = jiShuiShuChuFanKuiError;
    }

    public int getBenTiPaiYanWenDu() {
        return benTiPaiYanWenDu;
    }

    public void setBenTiPaiYanWenDu(int benTiPaiYanWenDu) {
        this.benTiPaiYanWenDu = benTiPaiYanWenDu;
    }

    public int getPaiYanWenDu() {
        return paiYanWenDu;
    }

    public void setPaiYanWenDu(int paiYanWenDu) {
        this.paiYanWenDu = paiYanWenDu;
    }

    public int getChuKouWenDu() {
        return chuKouWenDu;
    }

    public void setChuKouWenDu(int chuKouWenDu) {
        this.chuKouWenDu = chuKouWenDu;
    }

    public int getRuKouWenDu() {
        return ruKouWenDu;
    }

    public void setRuKouWenDu(int ruKouWenDu) {
        this.ruKouWenDu = ruKouWenDu;
    }

    public int getJieNengQiChuKouWenDu() {
        return jieNengQiChuKouWenDu;
    }

    public void setJieNengQiChuKouWenDu(int jieNengQiChuKouWenDu) {
        this.jieNengQiChuKouWenDu = jieNengQiChuKouWenDu;
    }

    public int getJieNengQiRuKouWenDu() {
        return jieNengQiRuKouWenDu;
    }

    public void setJieNengQiRuKouWenDu(int jieNengQiRuKouWenDu) {
        this.jieNengQiRuKouWenDu = jieNengQiRuKouWenDu;
    }

    public int getLuTangWenDu() {
        return luTangWenDu;
    }

    public void setLuTangWenDu(int luTangWenDu) {
        this.luTangWenDu = luTangWenDu;
    }

    public int getLuTangChuKouWenDu() {
        return luTangChuKouWenDu;
    }

    public void setLuTangChuKouWenDu(int luTangChuKouWenDu) {
        this.luTangChuKouWenDu = luTangChuKouWenDu;
    }

    public int getLuBiWenDu() {
        return luBiWenDu;
    }

    public void setLuBiWenDu(int luBiWenDu) {
        this.luBiWenDu = luBiWenDu;
    }

    public int getKongYuQiChuKouReFengWenDu() {
        return kongYuQiChuKouReFengWenDu;
    }

    public void setKongYuQiChuKouReFengWenDu(int kongYuQiChuKouReFengWenDu) {
        this.kongYuQiChuKouReFengWenDu = kongYuQiChuKouReFengWenDu;
    }

    public int getFuYaZhengQiWenDu() {
        return fuYaZhengQiWenDu;
    }

    public void setFuYaZhengQiWenDu(int fuYaZhengQiWenDu) {
        this.fuYaZhengQiWenDu = fuYaZhengQiWenDu;
    }

    public int getGuoReZhengQiWenDu() {
        return guoReZhengQiWenDu;
    }

    public void setGuoReZhengQiWenDu(int guoReZhengQiWenDu) {
        this.guoReZhengQiWenDu = guoReZhengQiWenDu;
    }

    public int getHuiLu1WenDu() {
        return huiLu1WenDu;
    }

    public void setHuiLu1WenDu(int huiLu1WenDu) {
        this.huiLu1WenDu = huiLu1WenDu;
    }

    public int getHuiLu2WenDu() {
        return huiLu2WenDu;
    }

    public void setHuiLu2WenDu(int huiLu2WenDu) {
        this.huiLu2WenDu = huiLu2WenDu;
    }

    public int getHuiLu3WenDu() {
        return huiLu3WenDu;
    }

    public void setHuiLu3WenDu(int huiLu3WenDu) {
        this.huiLu3WenDu = huiLu3WenDu;
    }

    public int getHuiLu4WenDu() {
        return huiLu4WenDu;
    }

    public void setHuiLu4WenDu(int huiLu4WenDu) {
        this.huiLu4WenDu = huiLu4WenDu;
    }

    public int getHuiLu5WenDu() {
        return huiLu5WenDu;
    }

    public void setHuiLu5WenDu(int huiLu5WenDu) {
        this.huiLu5WenDu = huiLu5WenDu;
    }

    public int getShiWaiWenDu() {
        return shiWaiWenDu;
    }

    public void setShiWaiWenDu(int shiWaiWenDu) {
        this.shiWaiWenDu = shiWaiWenDu;
    }

    public float getChuKouYaLi() {
        return chuKouYaLi;
    }

    public void setChuKouYaLi(float chuKouYaLi) {
        this.chuKouYaLi = chuKouYaLi;
    }

    public float getRuKouYaLi() {
        return ruKouYaLi;
    }

    public void setRuKouYaLi(float ruKouYaLi) {
        this.ruKouYaLi = ruKouYaLi;
    }

    public float getLuTangYaLi() {
        return luTangYaLi;
    }

    public void setLuTangYaLi(float luTangYaLi) {
        this.luTangYaLi = luTangYaLi;
    }

    public float getLuTangChuKouYaLi() {
        return luTangChuKouYaLi;
    }

    public void setLuTangChuKouYaLi(float luTangChuKouYaLi) {
        this.luTangChuKouYaLi = luTangChuKouYaLi;
    }

    public float getRanQiYaLi() {
        return ranQiYaLi;
    }

    public void setRanQiYaLi(float ranQiYaLi) {
        this.ranQiYaLi = ranQiYaLi;
    }

    public float getYiCiFengYa() {
        return yiCiFengYa;
    }

    public void setYiCiFengYa(float yiCiFengYa) {
        this.yiCiFengYa = yiCiFengYa;
    }

    public float getEciFengYa() {
        return eciFengYa;
    }

    public void setEciFengYa(float eciFengYa) {
        this.eciFengYa = eciFengYa;
    }

    public int getShunShiRanLiaoLiang() {
        return shunShiRanLiaoLiang;
    }

    public void setShunShiRanLiaoLiang(int shunShiRanLiaoLiang) {
        this.shunShiRanLiaoLiang = shunShiRanLiaoLiang;
    }

    public int getShunShiZhengQiLiuLiang() {
        return shunShiZhengQiLiuLiang;
    }

    public void setShunShiZhengQiLiuLiang(int shunShiZhengQiLiuLiang) {
        this.shunShiZhengQiLiuLiang = shunShiZhengQiLiuLiang;
    }

    public int getShunShiJiShuiLiuLiang() {
        return shunShiJiShuiLiuLiang;
    }

    public void setShunShiJiShuiLiuLiang(int shunShiJiShuiLiuLiang) {
        this.shunShiJiShuiLiuLiang = shunShiJiShuiLiuLiang;
    }

    public int getShunShiXunHuanLiuLiang() {
        return shunShiXunHuanLiuLiang;
    }

    public void setShunShiXunHuanLiuLiang(int shunShiXunHuanLiuLiang) {
        this.shunShiXunHuanLiuLiang = shunShiXunHuanLiuLiang;
    }

    public int getShunShiBuShuiLiuLiang() {
        return shunShiBuShuiLiuLiang;
    }

    public void setShunShiBuShuiLiuLiang(int shunShiBuShuiLiuLiang) {
        this.shunShiBuShuiLiuLiang = shunShiBuShuiLiuLiang;
    }

    public int getGuoLuYeWei() {
        return guoLuYeWei;
    }

    public void setGuoLuYeWei(int guoLuYeWei) {
        this.guoLuYeWei = guoLuYeWei;
    }

    public int getShuiXiangYeWei() {
        return shuiXiangYeWei;
    }

    public void setShuiXiangYeWei(int shuiXiangYeWei) {
        this.shuiXiangYeWei = shuiXiangYeWei;
    }

    public float getPaiYanYangHanLiang() {
        return paiYanYangHanLiang;
    }

    public void setPaiYanYangHanLiang(float paiYanYangHanLiang) {
        this.paiYanYangHanLiang = paiYanYangHanLiang;
    }

    public int getLuPaiSuDuFanKui() {
        return luPaiSuDuFanKui;
    }

    public void setLuPaiSuDuFanKui(int luPaiSuDuFanKui) {
        this.luPaiSuDuFanKui = luPaiSuDuFanKui;
    }

    public int getYinFengShuChuFanKui() {
        return yinFengShuChuFanKui;
    }

    public void setYinFengShuChuFanKui(int yinFengShuChuFanKui) {
        this.yinFengShuChuFanKui = yinFengShuChuFanKui;
    }

    public int getGuFengShuChuFanKui() {
        return guFengShuChuFanKui;
    }

    public void setGuFengShuChuFanKui(int guFengShuChuFanKui) {
        this.guFengShuChuFanKui = guFengShuChuFanKui;
    }

    public int getJiShuiShuChuFanKui() {
        return jiShuiShuChuFanKui;
    }

    public void setJiShuiShuChuFanKui(int jiShuiShuChuFanKui) {
        this.jiShuiShuChuFanKui = jiShuiShuChuFanKui;
    }

    public int getRanShaoShuChuLiangSetting() {
        return ranShaoShuChuLiangSetting;
    }

    public void setRanShaoShuChuLiangSetting(int ranShaoShuChuLiangSetting) {
        this.ranShaoShuChuLiangSetting = ranShaoShuChuLiangSetting;
    }

    public int getJiShuiShuChuLiangSetting() {
        return jiShuiShuChuLiangSetting;
    }

    public void setJiShuiShuChuLiangSetting(int jiShuiShuChuLiangSetting) {
        this.jiShuiShuChuLiangSetting = jiShuiShuChuLiangSetting;
    }

    public int getYinFengShuChuLiangSetting() {
        return yinFengShuChuLiangSetting;
    }

    public void setYinFengShuChuLiangSetting(int yinFengShuChuLiangSetting) {
        this.yinFengShuChuLiangSetting = yinFengShuChuLiangSetting;
    }

    public int getGuFengShuChuLiangSetting() {
        return guFengShuChuLiangSetting;
    }

    public void setGuFengShuChuLiangSetting(int guFengShuChuLiangSetting) {
        this.guFengShuChuLiangSetting = guFengShuChuLiangSetting;
    }

    public int getEciGuFengShuChuLiangSetting() {
        return eciGuFengShuChuLiangSetting;
    }

    public void setEciGuFengShuChuLiangSetting(int eciGuFengShuChuLiangSetting) {
        this.eciGuFengShuChuLiangSetting = eciGuFengShuChuLiangSetting;
    }

    public int getLuPaiHuoJinLiaoShuChuLiangSetting() {
        return luPaiHuoJinLiaoShuChuLiangSetting;
    }

    public void setLuPaiHuoJinLiaoShuChuLiangSetting(int luPaiHuoJinLiaoShuChuLiangSetting) {
        this.luPaiHuoJinLiaoShuChuLiangSetting = luPaiHuoJinLiaoShuChuLiangSetting;
    }

    public int getJiXianDiShuiWeiBaoJingDianJi() {
        return jiXianDiShuiWeiBaoJingDianJi;
    }

    public void setJiXianDiShuiWeiBaoJingDianJi(int jiXianDiShuiWeiBaoJingDianJi) {
        this.jiXianDiShuiWeiBaoJingDianJi = jiXianDiShuiWeiBaoJingDianJi;
    }

    public int getDiShuiWeiBaoJingDianJi() {
        return diShuiWeiBaoJingDianJi;
    }

    public void setDiShuiWeiBaoJingDianJi(int diShuiWeiBaoJingDianJi) {
        this.diShuiWeiBaoJingDianJi = diShuiWeiBaoJingDianJi;
    }

    public int getDiShuiWeiDianJi() {
        return diShuiWeiDianJi;
    }

    public void setDiShuiWeiDianJi(int diShuiWeiDianJi) {
        this.diShuiWeiDianJi = diShuiWeiDianJi;
    }

    public int getZhongShuiWeiDianJi() {
        return zhongShuiWeiDianJi;
    }

    public void setZhongShuiWeiDianJi(int zhongShuiWeiDianJi) {
        this.zhongShuiWeiDianJi = zhongShuiWeiDianJi;
    }

    public int getGaoShuiWeiDianJi() {
        return gaoShuiWeiDianJi;
    }

    public void setGaoShuiWeiDianJi(int gaoShuiWeiDianJi) {
        this.gaoShuiWeiDianJi = gaoShuiWeiDianJi;
    }

    public int getShuiXiangDiWeiDianJi() {
        return shuiXiangDiWeiDianJi;
    }

    public void setShuiXiangDiWeiDianJi(int shuiXiangDiWeiDianJi) {
        this.shuiXiangDiWeiDianJi = shuiXiangDiWeiDianJi;
    }

    public int getShuiXiangGaoWeiDianJi() {
        return shuiXiangGaoWeiDianJi;
    }

    public void setShuiXiangGaoWeiDianJi(int shuiXiangGaoWeiDianJi) {
        this.shuiXiangGaoWeiDianJi = shuiXiangGaoWeiDianJi;
    }

    public int getJiXianDiYeWeiBaoJingXinHao() {
        return jiXianDiYeWeiBaoJingXinHao;
    }

    public void setJiXianDiYeWeiBaoJingXinHao(int jiXianDiYeWeiBaoJingXinHao) {
        this.jiXianDiYeWeiBaoJingXinHao = jiXianDiYeWeiBaoJingXinHao;
    }

    public int getDiBaoJingXinHao() {
        return diBaoJingXinHao;
    }

    public void setDiBaoJingXinHao(int diBaoJingXinHao) {
        this.diBaoJingXinHao = diBaoJingXinHao;
    }

    public int getKongBengXinHao() {
        return kongBengXinHao;
    }

    public void setKongBengXinHao(int kongBengXinHao) {
        this.kongBengXinHao = kongBengXinHao;
    }

    public int getGaoBaoJingXinHao() {
        return gaoBaoJingXinHao;
    }

    public void setGaoBaoJingXinHao(int gaoBaoJingXinHao) {
        this.gaoBaoJingXinHao = gaoBaoJingXinHao;
    }

    public int getChaoYaBaoJingXinHao() {
        return chaoYaBaoJingXinHao;
    }

    public void setChaoYaBaoJingXinHao(int chaoYaBaoJingXinHao) {
        this.chaoYaBaoJingXinHao = chaoYaBaoJingXinHao;
    }

    public int getFuHeDiaoJieYaLiXinHao() {
        return fuHeDiaoJieYaLiXinHao;
    }

    public void setFuHeDiaoJieYaLiXinHao(int fuHeDiaoJieYaLiXinHao) {
        this.fuHeDiaoJieYaLiXinHao = fuHeDiaoJieYaLiXinHao;
    }

    public int getQiTingKongZhiYaLiXinHao() {
        return qiTingKongZhiYaLiXinHao;
    }

    public void setQiTingKongZhiYaLiXinHao(int qiTingKongZhiYaLiXinHao) {
        this.qiTingKongZhiYaLiXinHao = qiTingKongZhiYaLiXinHao;
    }

    public int getYaLiBiaoDiZhen() {
        return yaLiBiaoDiZhen;
    }

    public void setYaLiBiaoDiZhen(int yaLiBiaoDiZhen) {
        this.yaLiBiaoDiZhen = yaLiBiaoDiZhen;
    }

    public int getYaLiBiaoGaoZhen() {
        return yaLiBiaoGaoZhen;
    }

    public void setYaLiBiaoGaoZhen(int yaLiBiaoGaoZhen) {
        this.yaLiBiaoGaoZhen = yaLiBiaoGaoZhen;
    }

    public int getLuBiChaoWenXinHao() {
        return luBiChaoWenXinHao;
    }

    public void setLuBiChaoWenXinHao(int luBiChaoWenXinHao) {
        this.luBiChaoWenXinHao = luBiChaoWenXinHao;
    }

    public int getRanShaoQiGuZhangBaoJingXinHao() {
        return ranShaoQiGuZhangBaoJingXinHao;
    }

    public void setRanShaoQiGuZhangBaoJingXinHao(int ranShaoQiGuZhangBaoJingXinHao) {
        this.ranShaoQiGuZhangBaoJingXinHao = ranShaoQiGuZhangBaoJingXinHao;
    }

    public int getRanQiXieLouBaoJingXinHao() {
        return ranQiXieLouBaoJingXinHao;
    }

    public void setRanQiXieLouBaoJingXinHao(int ranQiXieLouBaoJingXinHao) {
        this.ranQiXieLouBaoJingXinHao = ranQiXieLouBaoJingXinHao;
    }

    public int getRanQiYaLiDiBaoJingXinHao() {
        return ranQiYaLiDiBaoJingXinHao;
    }

    public void setRanQiYaLiDiBaoJingXinHao(int ranQiYaLiDiBaoJingXinHao) {
        this.ranQiYaLiDiBaoJingXinHao = ranQiYaLiDiBaoJingXinHao;
    }

    public int getRanQiYaLiYiChangBaoJingXinHao() {
        return ranQiYaLiYiChangBaoJingXinHao;
    }

    public void setRanQiYaLiYiChangBaoJingXinHao(int ranQiYaLiYiChangBaoJingXinHao) {
        this.ranQiYaLiYiChangBaoJingXinHao = ranQiYaLiYiChangBaoJingXinHao;
    }

    public int getRanQiYaLiGaoBaoJingXinHao() {
        return ranQiYaLiGaoBaoJingXinHao;
    }

    public void setRanQiYaLiGaoBaoJingXinHao(int ranQiYaLiGaoBaoJingXinHao) {
        this.ranQiYaLiGaoBaoJingXinHao = ranQiYaLiGaoBaoJingXinHao;
    }

    public int getXunHuanBengDongZuoFanKuiXinHao() {
        return xunHuanBengDongZuoFanKuiXinHao;
    }

    public void setXunHuanBengDongZuoFanKuiXinHao(int xunHuanBengDongZuoFanKuiXinHao) {
        this.xunHuanBengDongZuoFanKuiXinHao = xunHuanBengDongZuoFanKuiXinHao;
    }

    public int getXunHuanBengDongZuoFanKuiXinHaoBei() {
        return xunHuanBengDongZuoFanKuiXinHaoBei;
    }

    public void setXunHuanBengDongZuoFanKuiXinHaoBei(int xunHuanBengDongZuoFanKuiXinHaoBei) {
        this.xunHuanBengDongZuoFanKuiXinHaoBei = xunHuanBengDongZuoFanKuiXinHaoBei;
    }

    public int getJiShuiBengDongZuoFanKuiXinHao() {
        return jiShuiBengDongZuoFanKuiXinHao;
    }

    public void setJiShuiBengDongZuoFanKuiXinHao(int jiShuiBengDongZuoFanKuiXinHao) {
        this.jiShuiBengDongZuoFanKuiXinHao = jiShuiBengDongZuoFanKuiXinHao;
    }

    public int getJiShuiBengDongZuoFanKuiXinHaoBei() {
        return jiShuiBengDongZuoFanKuiXinHaoBei;
    }

    public void setJiShuiBengDongZuoFanKuiXinHaoBei(int jiShuiBengDongZuoFanKuiXinHaoBei) {
        this.jiShuiBengDongZuoFanKuiXinHaoBei = jiShuiBengDongZuoFanKuiXinHaoBei;
    }

    public int getYinFengJiDongZuoFanKuiXinHao() {
        return yinFengJiDongZuoFanKuiXinHao;
    }

    public void setYinFengJiDongZuoFanKuiXinHao(int yinFengJiDongZuoFanKuiXinHao) {
        this.yinFengJiDongZuoFanKuiXinHao = yinFengJiDongZuoFanKuiXinHao;
    }

    public int getGuFengJiDongZuoFanKuiXinHao() {
        return guFengJiDongZuoFanKuiXinHao;
    }

    public void setGuFengJiDongZuoFanKuiXinHao(int guFengJiDongZuoFanKuiXinHao) {
        this.guFengJiDongZuoFanKuiXinHao = guFengJiDongZuoFanKuiXinHao;
    }

    public int getEciGuFengJiDongZuoFanKuiXinHao() {
        return eciGuFengJiDongZuoFanKuiXinHao;
    }

    public void setEciGuFengJiDongZuoFanKuiXinHao(int eciGuFengJiDongZuoFanKuiXinHao) {
        this.eciGuFengJiDongZuoFanKuiXinHao = eciGuFengJiDongZuoFanKuiXinHao;
    }

    public int getChuZhaJiDongZuoFanKuiXinHao() {
        return chuZhaJiDongZuoFanKuiXinHao;
    }

    public void setChuZhaJiDongZuoFanKuiXinHao(int chuZhaJiDongZuoFanKuiXinHao) {
        this.chuZhaJiDongZuoFanKuiXinHao = chuZhaJiDongZuoFanKuiXinHao;
    }

    public int getJiShuiBianPinQiGuZhangXinHao() {
        return jiShuiBianPinQiGuZhangXinHao;
    }

    public void setJiShuiBianPinQiGuZhangXinHao(int jiShuiBianPinQiGuZhangXinHao) {
        this.jiShuiBianPinQiGuZhangXinHao = jiShuiBianPinQiGuZhangXinHao;
    }

    public int getYinFengBianPinQiGuZhangXinHao() {
        return yinFengBianPinQiGuZhangXinHao;
    }

    public void setYinFengBianPinQiGuZhangXinHao(int yinFengBianPinQiGuZhangXinHao) {
        this.yinFengBianPinQiGuZhangXinHao = yinFengBianPinQiGuZhangXinHao;
    }

    public int getGuFengBianPinQiGuZhangXinHao() {
        return guFengBianPinQiGuZhangXinHao;
    }

    public void setGuFengBianPinQiGuZhangXinHao(int guFengBianPinQiGuZhangXinHao) {
        this.guFengBianPinQiGuZhangXinHao = guFengBianPinQiGuZhangXinHao;
    }

    public int getLuPaiBianPinQiGuZhangXinHao() {
        return luPaiBianPinQiGuZhangXinHao;
    }

    public void setLuPaiBianPinQiGuZhangXinHao(int luPaiBianPinQiGuZhangXinHao) {
        this.luPaiBianPinQiGuZhangXinHao = luPaiBianPinQiGuZhangXinHao;
    }

    public int getYanDaoDieFaFanKuiXinHao() {
        return yanDaoDieFaFanKuiXinHao;
    }

    public void setYanDaoDieFaFanKuiXinHao(int yanDaoDieFaFanKuiXinHao) {
        this.yanDaoDieFaFanKuiXinHao = yanDaoDieFaFanKuiXinHao;
    }

    public int getDiDianYaBaoJingXinHao() {
        return diDianYaBaoJingXinHao;
    }

    public void setDiDianYaBaoJingXinHao(int diDianYaBaoJingXinHao) {
        this.diDianYaBaoJingXinHao = diDianYaBaoJingXinHao;
    }

    public int getGaoDianYaBaoJingXinHao() {
        return gaoDianYaBaoJingXinHao;
    }

    public void setGaoDianYaBaoJingXinHao(int gaoDianYaBaoJingXinHao) {
        this.gaoDianYaBaoJingXinHao = gaoDianYaBaoJingXinHao;
    }

    public int getQueXiangBaoJingXinHao() {
        return queXiangBaoJingXinHao;
    }

    public void setQueXiangBaoJingXinHao(int queXiangBaoJingXinHao) {
        this.queXiangBaoJingXinHao = queXiangBaoJingXinHao;
    }

    public int getQueShuiDianJi2() {
        return queShuiDianJi2;
    }

    public void setQueShuiDianJi2(int queShuiDianJi2) {
        this.queShuiDianJi2 = queShuiDianJi2;
    }

    public int getWaiBuLianSuoXinHao() {
        return waiBuLianSuoXinHao;
    }

    public void setWaiBuLianSuoXinHao(int waiBuLianSuoXinHao) {
        this.waiBuLianSuoXinHao = waiBuLianSuoXinHao;
    }

    public int getChaoDiYaBaoHuXinHao() {
        return chaoDiYaBaoHuXinHao;
    }

    public void setChaoDiYaBaoHuXinHao(int chaoDiYaBaoHuXinHao) {
        this.chaoDiYaBaoHuXinHao = chaoDiYaBaoHuXinHao;
    }

    public int getRanShaoQiDaHuo() {
        return ranShaoQiDaHuo;
    }

    public void setRanShaoQiDaHuo(int ranShaoQiDaHuo) {
        this.ranShaoQiDaHuo = ranShaoQiDaHuo;
    }

    public int getRanShaoQiSanDuanHuo() {
        return ranShaoQiSanDuanHuo;
    }

    public void setRanShaoQiSanDuanHuo(int ranShaoQiSanDuanHuo) {
        this.ranShaoQiSanDuanHuo = ranShaoQiSanDuanHuo;
    }

    public int getRanShaoQiHuoLiZengJia() {
        return ranShaoQiHuoLiZengJia;
    }

    public void setRanShaoQiHuoLiZengJia(int ranShaoQiHuoLiZengJia) {
        this.ranShaoQiHuoLiZengJia = ranShaoQiHuoLiZengJia;
    }

    public int getRanShaoQiHuoLiJianShao() {
        return ranShaoQiHuoLiJianShao;
    }

    public void setRanShaoQiHuoLiJianShao(int ranShaoQiHuoLiJianShao) {
        this.ranShaoQiHuoLiJianShao = ranShaoQiHuoLiJianShao;
    }

    public int getJiShuiBengZhu() {
        return jiShuiBengZhu;
    }

    public void setJiShuiBengZhu(int jiShuiBengZhu) {
        this.jiShuiBengZhu = jiShuiBengZhu;
    }

    public int getJiShuiBengBei() {
        return jiShuiBengBei;
    }

    public void setJiShuiBengBei(int jiShuiBengBei) {
        this.jiShuiBengBei = jiShuiBengBei;
    }

    public int getJiShuiLiangZengJia() {
        return jiShuiLiangZengJia;
    }

    public void setJiShuiLiangZengJia(int jiShuiLiangZengJia) {
        this.jiShuiLiangZengJia = jiShuiLiangZengJia;
    }

    public int getJiShuiLiangJianShao() {
        return jiShuiLiangJianShao;
    }

    public void setJiShuiLiangJianShao(int jiShuiLiangJianShao) {
        this.jiShuiLiangJianShao = jiShuiLiangJianShao;
    }

    public int getXunHuanBeng() {
        return xunHuanBeng;
    }

    public void setXunHuanBeng(int xunHuanBeng) {
        this.xunHuanBeng = xunHuanBeng;
    }

    public int getXunHuanBengBei() {
        return xunHuanBengBei;
    }

    public void setXunHuanBengBei(int xunHuanBengBei) {
        this.xunHuanBengBei = xunHuanBengBei;
    }

    public int getBaoJingShuChu() {
        return baoJingShuChu;
    }

    public void setBaoJingShuChu(int baoJingShuChu) {
        this.baoJingShuChu = baoJingShuChu;
    }

    public int getJiaReZu1() {
        return jiaReZu1;
    }

    public void setJiaReZu1(int jiaReZu1) {
        this.jiaReZu1 = jiaReZu1;
    }

    public int getJiaReZu2() {
        return jiaReZu2;
    }

    public void setJiaReZu2(int jiaReZu2) {
        this.jiaReZu2 = jiaReZu2;
    }

    public int getJiaReZu3() {
        return jiaReZu3;
    }

    public void setJiaReZu3(int jiaReZu3) {
        this.jiaReZu3 = jiaReZu3;
    }

    public int getJiaReZu4() {
        return jiaReZu4;
    }

    public void setJiaReZu4(int jiaReZu4) {
        this.jiaReZu4 = jiaReZu4;
    }

    public int getJiaReZu5() {
        return jiaReZu5;
    }

    public void setJiaReZu5(int jiaReZu5) {
        this.jiaReZu5 = jiaReZu5;
    }

    public int getJiaReZu6() {
        return jiaReZu6;
    }

    public void setJiaReZu6(int jiaReZu6) {
        this.jiaReZu6 = jiaReZu6;
    }

    public int getJiaReZu7() {
        return jiaReZu7;
    }

    public void setJiaReZu7(int jiaReZu7) {
        this.jiaReZu7 = jiaReZu7;
    }

    public int getJiaReZu8() {
        return jiaReZu8;
    }

    public void setJiaReZu8(int jiaReZu8) {
        this.jiaReZu8 = jiaReZu8;
    }

    public int getJiaReZu9() {
        return jiaReZu9;
    }

    public void setJiaReZu9(int jiaReZu9) {
        this.jiaReZu9 = jiaReZu9;
    }

    public int getJiaReZu10() {
        return jiaReZu10;
    }

    public void setJiaReZu10(int jiaReZu10) {
        this.jiaReZu10 = jiaReZu10;
    }

    public int getJiaReZu11() {
        return jiaReZu11;
    }

    public void setJiaReZu11(int jiaReZu11) {
        this.jiaReZu11 = jiaReZu11;
    }

    public int getJiaReZu12() {
        return jiaReZu12;
    }

    public void setJiaReZu12(int jiaReZu12) {
        this.jiaReZu12 = jiaReZu12;
    }

    public int getJiaReZu13() {
        return jiaReZu13;
    }

    public void setJiaReZu13(int jiaReZu13) {
        this.jiaReZu13 = jiaReZu13;
    }

    public int getJiaReZu14() {
        return jiaReZu14;
    }

    public void setJiaReZu14(int jiaReZu14) {
        this.jiaReZu14 = jiaReZu14;
    }

    public int getJiaReZu15() {
        return jiaReZu15;
    }

    public void setJiaReZu15(int jiaReZu15) {
        this.jiaReZu15 = jiaReZu15;
    }

    public int getJiaReZu16() {
        return jiaReZu16;
    }

    public void setJiaReZu16(int jiaReZu16) {
        this.jiaReZu16 = jiaReZu16;
    }

    public int getJiaReZu17() {
        return jiaReZu17;
    }

    public void setJiaReZu17(int jiaReZu17) {
        this.jiaReZu17 = jiaReZu17;
    }

    public int getJiaReZu18() {
        return jiaReZu18;
    }

    public void setJiaReZu18(int jiaReZu18) {
        this.jiaReZu18 = jiaReZu18;
    }

    public int getJiaReZu19() {
        return jiaReZu19;
    }

    public void setJiaReZu19(int jiaReZu19) {
        this.jiaReZu19 = jiaReZu19;
    }

    public int getJiaReZu20() {
        return jiaReZu20;
    }

    public void setJiaReZu20(int jiaReZu20) {
        this.jiaReZu20 = jiaReZu20;
    }

    public int getJiaReZu21() {
        return jiaReZu21;
    }

    public void setJiaReZu21(int jiaReZu21) {
        this.jiaReZu21 = jiaReZu21;
    }

    public int getJiaReZu22() {
        return jiaReZu22;
    }

    public void setJiaReZu22(int jiaReZu22) {
        this.jiaReZu22 = jiaReZu22;
    }

    public int getJiaReZu23() {
        return jiaReZu23;
    }

    public void setJiaReZu23(int jiaReZu23) {
        this.jiaReZu23 = jiaReZu23;
    }

    public int getJiaReZu24() {
        return jiaReZu24;
    }

    public void setJiaReZu24(int jiaReZu24) {
        this.jiaReZu24 = jiaReZu24;
    }

    public int getJiaReZu25() {
        return jiaReZu25;
    }

    public void setJiaReZu25(int jiaReZu25) {
        this.jiaReZu25 = jiaReZu25;
    }

    public int getJiaReZu26() {
        return jiaReZu26;
    }

    public void setJiaReZu26(int jiaReZu26) {
        this.jiaReZu26 = jiaReZu26;
    }

    public int getJiaReZu27() {
        return jiaReZu27;
    }

    public void setJiaReZu27(int jiaReZu27) {
        this.jiaReZu27 = jiaReZu27;
    }

    public int getJiaReZu28() {
        return jiaReZu28;
    }

    public void setJiaReZu28(int jiaReZu28) {
        this.jiaReZu28 = jiaReZu28;
    }

    public int getJiaReZu29() {
        return jiaReZu29;
    }

    public void setJiaReZu29(int jiaReZu29) {
        this.jiaReZu29 = jiaReZu29;
    }

    public int getJiaReZu30() {
        return jiaReZu30;
    }

    public void setJiaReZu30(int jiaReZu30) {
        this.jiaReZu30 = jiaReZu30;
    }

    public int getYinFengJi() {
        return yinFengJi;
    }

    public void setYinFengJi(int yinFengJi) {
        this.yinFengJi = yinFengJi;
    }

    public int getYinFengLiangZengJia() {
        return yinFengLiangZengJia;
    }

    public void setYinFengLiangZengJia(int yinFengLiangZengJia) {
        this.yinFengLiangZengJia = yinFengLiangZengJia;
    }

    public int getYinFengLiangJianShao() {
        return yinFengLiangJianShao;
    }

    public void setYinFengLiangJianShao(int yinFengLiangJianShao) {
        this.yinFengLiangJianShao = yinFengLiangJianShao;
    }

    public int getGuFengJi() {
        return guFengJi;
    }

    public void setGuFengJi(int guFengJi) {
        this.guFengJi = guFengJi;
    }

    public int getGuFengLiangZengJia() {
        return guFengLiangZengJia;
    }

    public void setGuFengLiangZengJia(int guFengLiangZengJia) {
        this.guFengLiangZengJia = guFengLiangZengJia;
    }

    public int getGuFengLiangJianShao() {
        return guFengLiangJianShao;
    }

    public void setGuFengLiangJianShao(int guFengLiangJianShao) {
        this.guFengLiangJianShao = guFengLiangJianShao;
    }

    public int getEciGuFengJi() {
        return eciGuFengJi;
    }

    public void setEciGuFengJi(int eciGuFengJi) {
        this.eciGuFengJi = eciGuFengJi;
    }

    public int getEciGuFengLiangZengJia() {
        return eciGuFengLiangZengJia;
    }

    public void setEciGuFengLiangZengJia(int eciGuFengLiangZengJia) {
        this.eciGuFengLiangZengJia = eciGuFengLiangZengJia;
    }

    public int getEciGuFengLiangJianShao() {
        return eciGuFengLiangJianShao;
    }

    public void setEciGuFengLiangJianShao(int eciGuFengLiangJianShao) {
        this.eciGuFengLiangJianShao = eciGuFengLiangJianShao;
    }

    public int getLuPaiHuoJinLiaoJiZhengZhuan() {
        return luPaiHuoJinLiaoJiZhengZhuan;
    }

    public void setLuPaiHuoJinLiaoJiZhengZhuan(int luPaiHuoJinLiaoJiZhengZhuan) {
        this.luPaiHuoJinLiaoJiZhengZhuan = luPaiHuoJinLiaoJiZhengZhuan;
    }

    public int getLuPaiFanZhuan() {
        return luPaiFanZhuan;
    }

    public void setLuPaiFanZhuan(int luPaiFanZhuan) {
        this.luPaiFanZhuan = luPaiFanZhuan;
    }

    public int getDianHuoQi() {
        return dianHuoQi;
    }

    public void setDianHuoQi(int dianHuoQi) {
        this.dianHuoQi = dianHuoQi;
    }

    public int getJiaYaoBeng() {
        return jiaYaoBeng;
    }

    public void setJiaYaoBeng(int jiaYaoBeng) {
        this.jiaYaoBeng = jiaYaoBeng;
    }

    public void setAlarmCount(int alarmCount) {
        this.alarmCount = alarmCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    /**
     * 生成设备快照
     *
     * @return DeviceSnapshot
     */
    public DeviceSnapshot getSnapshot() {
        return DeviceSnapshot.getDeviceSnapshot(this);
    }

    public int getAlarmCount() {
        return paiYanWenDuGao + luShuiWenDuGao + chuKouWenDuGao + chaoYa + jiXianDiShuiWei + diShuiWei + gaoShuiWei + shuiWeiXinHaoLuoJiCuo + luBiWenDuGao + fuYaZhengQiWenDuGao + ranShaoQiGuZhang + ranQiXieLou +
                ranQiYaLiDi + ranQiYaLiYiChang + ranQiYaLiGao + jiShuiBianPinQiGuZhang + xunHuanBianPinQiGuZhang + yinFengBianPinQiGuZhang + guFengBianPinQiGuZhang + eciGuFengBianPinQiGuZhang +
                luPaiBianPinQiGuZhang + jiShuiBengGuZhang + xunHuanBengGuZhang + xunHuanXiTongQianYa + diDianYa + gaoDianYa + queXiang + louDian+ bianSongQiGuoYaBaoHu + guanJianCanShuYiChang + sheDingCanShuYiChang +
                shiZhongGuZhang + cunChuQiGuZhang + waiBuLianSuo + queYou + diYouWei + benTiPaiYanWenDuGao;
    }

    public int getErrorCount() {
        return benTiPaiYanWenDuError + paiYanWenDuError + luShuiWenDuError + chuKouWenDuError + ruKouWenDuError + jieNengQiChuKouWenDuError + jieNengQiRuKouWenDuError + jiShuiWenDuError + luTangWenDuError +
                luTangChuKouWenDuError + luBiWenDuError + ranLiaoWenDuError + kongYuQiChuKouReFengWenDuError + fuYaZhengQiWenDuError + guoReZhengQiWenDuError + huiLu1WenDuError + huiLu2WenDuError + huiLu3WenDuError +
                huiLu4WenDuError + huiLu5WenDuError + shiWaiWenDuError + zhengQiYaLiError + jiShuiYaLiError + chuKouYaLiError + ruKouYaLiError + luTangYaLiError + luTangChuKouYaLiError + ranQiYaLiError + yiCiFengYaError +
                eciFengYaError + shunShiRanLiaoLiangError + shunShiZhengQiLiuLiangError + shunShiJiShuiLiuLiangError + shunShiXunHuanLiuLiangError + shunShiBuShuiLiuLiangError + guoLuYeWeiError + shuiXiangYeWeiError +
                paiYanYangHanLiangError + luPaiSuDuFanKuiError + yinFengShuChuFanKuiError + guFengShuChuFanKuiError + jiShuiShuChuFanKuiError;
    }
}
