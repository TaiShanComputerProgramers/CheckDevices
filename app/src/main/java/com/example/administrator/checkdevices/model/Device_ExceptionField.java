package com.example.administrator.checkdevices.model;

import com.example.administrator.checkdevices.model.entities.meta.ByteField;

/**
 * Created by wd on 2018/4/24.
 *
 * @author wd
 * @date 2018/4/24
 * @describe TODO
 * @package com.example.administrator.checkdevices.model
 */

public class Device_ExceptionField {
    //基本信息
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
    private String ex_bianpinqiguzhangbaojing;//变频器故障报警
    private String ex_meishuiwendugaobaojing;//媒水温度高报警
    private String ex_1haoguoluguzhang;//1号锅炉故障
    private String ex_2haoguoluguzhang;//2号锅炉故障
    private String ex_3haoguoluguzhang;//3号锅炉故障
    private String ex_4haoguoluguzhang;//4号锅炉故障
    private String ex_5haoguoluguzhang;//5号锅炉故障
    private String ex_6haoguoluguzhang;//6号锅炉故障
    private String ex_7haoguoluguzhang;//7号锅炉故障
    private String ex_8haoguoluguzhang;//8号锅炉故障


    private String ex_bushuibianpinqiguzhangbaojing;//补水变频器故障报警
    private String ex_shuiliukaiguanbaohubaojing;//水流开关保护报警
    private String ex_rukouwendudibaojing;//入口温度低报警
    private String ex_xunhuanbengbianpinqiguzhang;//循环泵变频器故障
    private String ex_ecixunhuanbengbianpinqiguzhang;//二次循环泵变频器故障
    private String ex_reshuibengbianpinqiguzhang;//热水泵变频器故障
    private String ex_buyoubengbianpinqiguzhang;//补油泵变频器故障
    private String ex_ecigufengbianpinqiguzhang;//二次鼓风变频器故障
    private String ex_songliaojibianpinqiguzhang;//送料机变频器故障
    private String ex_zhenkongbengbianpinqiguzhang;//真空泵变频器故障
    private String ex_lengningbengbianpinqiguzhang;//冷凝泵变频器故障


    private String ex_bushuibengguzhang;//补水泵故障
    private String ex_buyoubengguzhang;//补油泵故障
    private String ex_lengningbengguzhang;//冷凝泵故障
    private String ex_reshuibengguzhang;//热水泵故障
    private String ex_zhenkongbengguzhang;//真空泵故障

    private String ex_ecixunhuanbengguzhang;//二次循环泵故障
    private String ex_huilu1xunhuanbengguzhang;//回路1循环泵故障
    private String ex_huilu2xunhuanbengguzhang;//回路2循环泵故障
    private String ex_huilu3xunhuanbengguzhang;//回路3循环泵故障
    private String ex_huilu4xunhuanbengguzhang;//回路4循环泵故障
    private String ex_huilu5xunhuanbengguzhang;//回路5循环泵故障

    private String ex_huilu1wendugaobaojing;//回路1温度高报警

    private String ex_huilu2wendugaobaojing;//回路2温度高报警
    private String ex_huilu3wendugaobaojing;//回路3温度高报警
    private String ex_huilu4wendugaobaojing;//回路4温度高报警
    private String ex_huilu5wendugaobaojing;//回路5温度高报警
    private String ex_panguan1wendugaobaojing;//盘管1温度高报警

    private String ex_panguan2wendugaobaojing;//盘管2温度高报警
    private String ex_panguan3wendugaobaojing;//盘管3温度高报警
    private String ex_panguan4wendugaobaojing;//盘管4温度高报警
    private String ex_panguan5wendugaobaojing;//盘管5温度高报警
    private String ex_panguan6wendugaobaojing;//盘管6温度高报警

    private String ex_panguan7wendugaobaojing;//盘管7温度高报警
    private String ex_panguan8wendugaobaojing;//盘管8温度高报警
    private String ex_panguan9wendugaobaojing;//盘管9温度高报警
    private String ex_panguan10wendugaobaojing;//盘管10温度高报警
    private String ex_shanzhengguanchaoyabaojing;//闪蒸罐超压报警

    private String ex_lengningguanchaoyabaojing;//冷凝罐超压报警
    private String ex_pengzhangguanchaoyabaojing;//膨胀罐超压报警
    private String ex_shanzhengguanyeweigaobaojing;//闪蒸罐液位高报警
    private String ex_shanzhengguanyeweidibaojing;//闪蒸罐液位低报警
    private String ex_lengningguanyeweigaobaojing;//冷凝罐液位高报警
    private String ex_lengningguanyeweidibaojing;//冷凝罐液位低报警
    private String ex_pengzhangguanyeweigaobaojing;//膨胀罐液位高报警
    private String ex_pengzhangguanyeweidibaojing;//膨胀罐液位低报警
    private String ex_jinchukouyachadibaojing;//进出口压差低报警
    private String ex_bentipaiyanwenduchuanganqiguzhang;//本体排烟温度传感器故障

    private String ex_paiyanwenduchuanganqiguzhang;//排烟温度传感器故障
    private String ex_lushuiwenduchuanganqiguzhang;//炉水温度传感器故障
    private String ex_chukouwenduchuanganqiguzhang;//出口温度传感器故障
    private String ex_rukouwenduchuanganqiguzhang;//入口温度传感器故障
    private String ex_jienengqirukouwenduchuanganqiguzhang;//节能器入口温度传感器故障
    private String ex_jishuiwenduchuanganqiguzhang;//给水温度传感器故障
    private String ex_lutangwenduchuanganqiguzhang;//炉膛温度传感器故障
    private String ex_lutangchukouwenduchuanganqiguzhang;//炉膛出口温度传感器故障
    private String ex_lubiwenduchuanganqiguzhang;//炉壁温度传感器故障
    private String ex_ranliaowenduchuanganqiguzhang;//燃料温度传感器故障
    private String ex_refengwenduchuanganqiguzhang;//热风温度传感器故障
    private String ex_fuyazhengqiwenduchuanganqiguzhang;//负压蒸汽温度传感器故障
    private String ex_guorezhengqiwenduchuanganqiguzhang;//过热蒸汽温度传感器故障
    private String ex_huilu1wenduchuanganqiguzhang;//回路1温度传感器故障
    private String ex_huilu2wenduchuanganqiguzhang;//回路2温度传感器故障
    private String ex_huilu3wenduchuanganqiguzhang;//回路3温度传感器故障
    private String ex_huilu4wenduchuanganqiguzhang;//回路4温度传感器故障
    private String ex_huilu5wenduchuanganqiguzhang;//回路5温度传感器故障
    private String ex_shiwaiwenduchuanganqiguzhang;//室外温度传感器故障
    private String ex_zhengqiyalichuanganqiguzhang;//蒸汽压力传感器故障
    private String ex_jishuiyalichuanganqiguzhang;//给水压力传感器故障
    private String ex_chukouyalichuanganqiguzhang;//出口压力传感器故障
    private String ex_rukouyalichuanganqiguzhang;//入口压力传感器故障
    private String ex_lutangyalichuanganqiguzhang;//炉膛压力传感器故障
    private String ex_lutangchukouyalichuanganqiguzhang;//炉膛出口压力传感器故障
    private String ex_ranqiyalichuanganqiguzhang;//燃气压力传感器故障
    private String ex_yicifengyachuanganqiguzhang;//一次风压传感器故障
    private String ex_ecifengyachuanganqiguzhang;//二次风压传感器故障
    private String ex_ranliaoliangchuanganqiguzhang;//燃料量传感器故障
    private String ex_zhengqiliuliangchuanganqiguzhang;//蒸汽流量传感器故障
    private String ex_jishuiliuliangchuanganqiguzhang;//给水流量传感器故障
    private String ex_xunhuanliuliangchuanganqiguzhang;//循环流量传感器故障
    private String ex_bushuiliuliangchuanganqiguzhang;//补水流量传感器故障







    private String ex_guoluyeweichuanganqiguzhang;//锅炉液位传感器故障
    private String ex_shuixiangyeweichuanganqiguzhang;//水箱液位传感器故障
    private String ex_paiyanyanghanliangchuanganqiguzhang;//排烟氧含量传感器故障
    private String ex_lupaisudufankuichuanganqiguzhang;//炉排速度反馈传感器故障
    private String ex_yinfengshuchufankuichuanganqiguzhang;//引风输出反馈传感器故障
    private String ex_gufengshuchufankuichuanganqiguzhang;//鼓风输出反馈传感器故障


    private String ex_jishuishuchufankuichuanganqiguzhang;//给水输出反馈传感器故障
    private String ex_meishuiwenduchuanganqiguzhang;//媒水温度传感器故障
    private String ex_shuixiangwenduchuanganqiguzhang;//水箱温度传感器故障
    private String ex_pengzhangguanyeweichuanganqiguzhang;//膨胀罐液位传感器故障
    private String ex_shanzhengguanyeweichuanganqiguzhang;//闪蒸罐液位传感器故障
    private String ex_lengningyeguanyeweichuanganqiguzhang;//冷凝液罐液位传感器故障

    private String ex_chuguanyeweichuanganqiguzhang;//储罐液位传感器故障
    private String ex_pengzhangguanwenduchuanganqiguzhang;//膨胀罐温度传感器故障
    private String ex_shanzhengguanwenduchuanganqiguzhang;//闪蒸罐温度传感器故障
    private String ex_lengningyeguanwenduchuanganqiguzhang;//冷凝液罐温度传感器故障
    private String ex_chuguanwenduchuanganqiguzhang;//储罐温度传感器故障
    private String ex_guoluyalichuanganqiguzhang;//锅炉压力传感器故障

    private String ex_guorezhengqiyalichuanganqiguzhang;//过热蒸汽压力传感器故障
    private String ex_paiyanchuyalichuanganqiguzhang;//排烟处压力传感器故障
    private String ex_fengshifengyachuanganqiguzhang;//风室风压传感器故障
    private String ex_yinfengjidianliuchuanganqiguzhang;//引风机电流传感器故障
    private String ex_gufengjidianliuchuanganqiguzhang;//鼓风机电流传感器故障
    private String ex_jiliaojisudufankuichuanganqiguzhang;//给料机速度反馈传感器故障

    private String ex_panguan1wenduchuanganqiguzhang;//盘管1温度传感器故障
    private String ex_panguan2wenduchuanganqiguzhang;//盘管2温度传感器故障
    private String ex_panguan3wenduchuanganqiguzhang;//盘管3温度传感器故障
    private String ex_panguan4wenduchuanganqiguzhang;//盘管4温度传感器故障
    private String ex_panguan5wenduchuanganqiguzhang;//盘管5温度传感器故障
    private String ex_panguan6wenduchuanganqiguzhang;//盘管6温度传感器故障

    private String ex_panguan7wenduchuanganqiguzhang;//盘管7温度传感器故障
    private String ex_panguan8wenduchuanganqiguzhang;//盘管8温度传感器故障
    private String ex_panguan9wenduchuanganqiguzhang;//盘管9温度传感器故障
    private String ex_panguan10wenduchuanganqiguzhang;//盘管10温度传感器故障


}
