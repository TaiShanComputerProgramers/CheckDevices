package com.example.administrator.checkdevices.viewbinder;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Vibrator;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.adapter.TreeNode;
import com.example.administrator.checkdevices.adapter.TreeViewBinder;
import com.example.administrator.checkdevices.interfaces.OnItemClickListener;
import com.example.administrator.checkdevices.model.Device;
import com.example.administrator.checkdevices.model.Device_BaseInfo;
import com.example.administrator.checkdevices.model.Device_MockField;
import com.example.administrator.checkdevices.model.Device_SettingField;
import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.model.entities.meta.DeviceFieldForUI;
import com.example.administrator.checkdevices.utils.NetUtils;

import java.util.HashMap;
import java.util.List;

import static android.content.Context.VIBRATOR_SERVICE;


/**
 * Created by tlh on 2016/10/1 :)
 */

public class DeviceItemBinder extends TreeViewBinder<DeviceItemBinder.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private Context context;
    private SoundPool soundPool;
    private HashMap<Integer,Integer> spMap;
    private int playID;
    private Vibrator vibrator;
    private Device_t item;
    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public void bindView(final ViewHolder holder, int position, TreeNode node) {
        final Device_t fileNode = (Device_t) node.getContent();
        HashMap<String,DeviceFieldForUI> map_baseinfo=fileNode.getBaseDeviceInfo();
        HashMap<String,DeviceFieldForUI> map_mock=fileNode.getMockFiled();
        HashMap<String,DeviceFieldForUI> map_set=fileNode.getSettingFiled();

        DeviceFieldForUI rl_type=map_baseinfo.get(Device_BaseInfo.ba_ranliaoleixing);
        DeviceFieldForUI jz_type=map_baseinfo.get(Device_BaseInfo.ba_jiezhileixing);
        DeviceFieldForUI item1=map_baseinfo.get(Device_BaseInfo.ba_guolushuiweizhuangtai);//锅炉水位状态
        DeviceFieldForUI item2=map_baseinfo.get(Device_BaseInfo.ba_guoluyalizhuangtai);//锅炉压力状态
        DeviceFieldForUI item3=map_baseinfo.get(Device_BaseInfo.ba_shuixiangshuiweizhuangtai);//水箱水位状态
        if(item1!=null&&NetUtils.isNumeric(item1.getValue())) {
                int a=Integer.parseInt(item1.getValue());
                String sw_status="";
                switch (a){
                    case 0:
                        sw_status="缺水";
                        break;
                    case 1:
                        sw_status="低报警";
                        break;
                    case 2:
                        sw_status="低位";
                        break;
                    case 3:
                        sw_status="中位";
                        break;
                    case 4:
                        sw_status="高位";
                        break;
                    case 5:
                        sw_status="超高位";
                        break;
                    case 6:
                        sw_status="逻辑错";
                        break;

                }
                item1.setValue(sw_status);
        }
        if(item2!=null&&NetUtils.isNumeric(item2.getValue())) {
            int a=Integer.parseInt(item2.getValue());
            String sw_status="";
            switch (a){
                case 0:
                    sw_status="常压";
                    break;
                case 1:
                    sw_status="低压";
                    break;
                case 2:
                    sw_status="中压";
                    break;
                case 3:
                    sw_status="高压";
                    break;
                case 4:
                    sw_status="超压";
                    break;
            }
            item2.setValue(sw_status);
        }
        if(item3!=null&&NetUtils.isNumeric(item3.getValue())) {
            int a=Integer.parseInt(item3.getValue());
            String sw_status="";
            switch (a){
                case 0:
                    sw_status="缺水";
                    break;
                case 1:
                    sw_status="低报警";
                    break;
                case 2:
                    sw_status="低位";
                    break;
                case 3:
                    sw_status="中位";
                    break;
                case 4:
                    sw_status="高位";
                    break;
                case 5:
                    sw_status="超高位";
                    break;
                case 6:
                    sw_status="逻辑错";
                    break;

            }
            item3.setValue(sw_status);
        }
        DeviceFieldForUI item4=map_mock.get(Device_MockField.mo_zhengqiyali);//蒸汽压力
        DeviceFieldForUI item5=map_mock.get(Device_MockField.mo_paiyanwendu);//排烟温度
        DeviceFieldForUI item6=map_mock.get(Device_MockField.mo_chukouwendu);//出口温度
        DeviceFieldForUI item7=map_mock.get(Device_MockField.mo_rukouwendu);//入口温度
        DeviceFieldForUI item8=map_mock.get(Device_MockField.mo_meishuiwendu);//媒水温度
        DeviceFieldForUI item9=map_set.get(Device_SettingField.se_jiarezushu);//加热组

        initData(holder,item4,item5,item6,item7,item8,item9,item1,item2,item3);

        String rl="";
        String jz="";
        if(rl_type!=null)rl=rl_type.getValue();
        if(jz_type!=null)jz=jz_type.getValue();
        if(rl.equals("0")&&jz.equals("0")){ //模式5、9、12、14、15
//            initData(holder,item5,item6,item7,item8,item1,item2,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.reshui);
        }else if(rl.equals("0")&&jz.equals("1")){//模式1、2、3
//            initData(holder,item1,item2,item4,item5,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.plc);
        }else if(rl.equals("0")&&jz.equals("2")){//模式4
//            initData(holder,item5,item6,item7,null,null,null,null,null,null);
        }else if(rl.equals("1")&&jz.equals("0")){//模式11、19、20
//            initData(holder,item6,item7,item9,item3,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.reshui);
        }else if(rl.equals("1")&&jz.equals("1")){//模式10、21、22
//            initData(holder,item9,item4,item1,item2,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.plc);
        }else if(rl.equals("1")&&jz.equals("2")){

        }else if(rl.equals("2")&&jz.equals("0")){//模式18
//            initData(holder,item5,item6,item7,item2,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.reshui);
        }else if(rl.equals("2")&&jz.equals("1")){//模式16
//            initData(holder,item4,item5,item1,null,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.plc);
        }else if(rl.equals("2")&&jz.equals("2")){//模式17
//            initData(holder,item5,item6,item7,null,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.plc);
        }else if(rl.equals("3")&&jz.equals("0")){

        }else if(rl.equals("3")&&jz.equals("1")){

        }else if(rl.equals("3")&&jz.equals("2")){

        }else if(rl.equals("0")){//模式 6、7、8、13    6 燃油热风炉 0+ 7 燃油茶水炉（一段火）0+ 8 燃油茶水炉（二段火）0+  13 燃油微压茶水炉
//            initData(holder,item5,item6,item1,item3,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.plc);
        }else{
            initData(holder,null,null,null,null,null,null,null,null,null);
            holder.iv_bg.setBackgroundResource(R.mipmap.plc);
        }


        /*String ranl_type="";

        switch (Integer.parseInt(rl_type.getValue())){
            case 0:
                ranl_type="油气";
                break;
            case 1:
                ranl_type="电";
                break;
            case 2:
                ranl_type="煤";
                break;
            case 3:
                ranl_type="生物质";
                break;
        }
        String jzh_type="";
        switch (Integer.parseInt(jz_type.getValue())){
            case 0:
                jzh_type="热水";
                break;
            case 1:
                jzh_type="蒸汽";
                break;
            case 2:
                jzh_type="导热油";
                break;
        }*/
        int yx_status=-1;
        DeviceFieldForUI deviceFieldForUI=map_baseinfo.get(Device_BaseInfo.ba_yunxingzhuangtai);
        if(deviceFieldForUI!=null)yx_status=Integer.parseInt(deviceFieldForUI.getValue());
//        int yx_status=Integer.parseInt(map_baseinfo.get(Device_BaseInfo.ba_yunxingzhuangtai).getValue());
        String yunx_status="未知";
        switch (yx_status){
            case 0:
                yunx_status="关机";
                break;
            case 1:
                yunx_status="待机";
                break;
            case 2:
                yunx_status="运行";
                break;
            case 3:
                yunx_status="报警";
                break;
            default:
                yunx_status="未知";
                break;
        }
        /*int set_status=fileNode.get();
        String s_status="";
        switch (set_status){
            case 0:
                s_status="非设定状态";
                break;
            case 1:
                s_status="设定状态";
                break;

        }*/
        fileNode.setRunstatus(yx_status);
        holder.tv_device_name.setText(fileNode.getNickName()+" - "+yunx_status);
        holder.warn_mesage.setText(Integer.toString(fileNode.getExceptionCount()));




       /*if(fileNode.getDeviceNo().equals("NJZJ0000000000012345")||fileNode.getDeviceNo().equals("NJZJ0000000000012346")
               ||fileNode.getDeviceNo().equals("NJZJ0000000000012347")){
           holder.iv_bg.setBackgroundResource(R.mipmap.reshui);
       }else if(fileNode.getDeviceNo().equals("NJZJ0000000000012348")||fileNode.getDeviceNo().equals("NJZJ0000000000012349")){
           holder.iv_bg.setBackgroundResource(R.mipmap.plc);
          *//* if(fileNode.getFocusItem3Text()!=null&&!fileNode.getFocusItem3Text().equals("")){
               holder.tv_focu_text3.setText("水位状态"+":");
               holder.tv_zq_yali.setText("正常");
           }
           else {
               holder.tv_zq_yali.setText("");
               holder.tv_focu_text3.setText("");
           }*//*
       }*//*else if(fileNode.getDeviceNo().equals("NJZJ0000000000012349")){
           holder.iv_bg.setBackgroundResource(R.mipmap.plc);
       }*/
        holder.iv_waarn.setBackgroundResource(R.drawable.warn_normal);
        if(fileNode.getExceptionCount()>0){
            holder.iv_waarn.setBackgroundResource(R.drawable.warning);
            warn("收到"+fileNode.getExceptionCount()+"条报警信息");
        }
       holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onItemClickListener.onItemClick(fileNode,0);
           }
       });

    }
    private void initData(ViewHolder holder,DeviceFieldForUI item1,DeviceFieldForUI item2,DeviceFieldForUI item3,DeviceFieldForUI item4,DeviceFieldForUI item5,DeviceFieldForUI item6,DeviceFieldForUI item7,DeviceFieldForUI item8,DeviceFieldForUI item9){
        if(item1!=null&&item1.getValue()!=null&&!item1.getValue().equals("")&&!item1.getValue().contains("null")){
            holder.linearLayout_item1.setVisibility(View.VISIBLE);
            holder.tv_item1.setText(item1.getTitle());
            holder.tv_item1_value.setText(item1.getValue());
        }else {
            holder.linearLayout_item1.setVisibility(View.GONE);
        }
        if(item2!=null&&item2.getValue()!=null&&!item2.getValue().equals("")&&!item2.getValue().contains("null")){
            holder.linearLayout_item2.setVisibility(View.VISIBLE);
            holder.tv_item2.setText(item2.getTitle());
            holder.tv_item2_value.setText(item2.getValue());
        }else{
            holder.linearLayout_item2.setVisibility(View.GONE);
        }
        if(item3!=null&&item3.getValue()!=null&&!item3.getValue().equals("")&&!item3.getValue().contains("null")){
            holder.linearLayout_item3.setVisibility(View.VISIBLE);
            holder.tv_item3.setText(item3.getTitle());
            holder.tv_item3_value.setText(item3.getValue());
        }else{
            holder.linearLayout_item3.setVisibility(View.GONE);
        }
        if(item4!=null&&item4.getValue()!=null&&!item4.getValue().equals("")&&!item4.getValue().contains("null")){
            holder.linearLayout_item4.setVisibility(View.VISIBLE);
            holder.tv_item4.setText(item4.getTitle());
            holder.tv_item4_value.setText(item4.getValue());
        }else{
            holder.linearLayout_item4.setVisibility(View.GONE);
        }
        if(item5!=null&&item5.getValue()!=null&&!item5.getValue().equals("")&&!item5.getValue().contains("null")){
            holder.linearLayout_item5.setVisibility(View.VISIBLE);
            holder.tv_item5.setText(item5.getTitle());
            holder.tv_item5_value.setText(item5.getValue());
        }else{
            holder.linearLayout_item5.setVisibility(View.GONE);
        }
        if(item6!=null&&item6.getValue()!=null&&!item6.getValue().equals("")&&!item6.getValue().contains("null")){
            holder.linearLayout_item6.setVisibility(View.VISIBLE);
            holder.tv_item6.setText(item6.getTitle());
            holder.tv_item6_value.setText(item6.getValue());
        }else{
            holder.linearLayout_item6.setVisibility(View.GONE);
        }
        if(item7!=null&&item7.getValue()!=null&&!item7.getValue().equals("")&&!item7.getValue().contains("null")){
            holder.linearLayout_item7.setVisibility(View.VISIBLE);
            holder.tv_item7.setText(item7.getTitle());
            holder.tv_item7_value.setText(item7.getValue());
        }else{
            holder.linearLayout_item7.setVisibility(View.GONE);
        }
        if(item8!=null&&item8.getValue()!=null&&!item8.getValue().equals("")&&!item8.getValue().contains("null")){
            holder.linearLayout_item8.setVisibility(View.VISIBLE);
            holder.tv_item8.setText(item8.getTitle());
            holder.tv_item8_value.setText(item8.getValue());
        }else{
            holder.linearLayout_item8.setVisibility(View.GONE);
        }
        if(item9!=null&&item9.getValue()!=null&&!item9.getValue().equals("")&&!item9.getValue().contains("null")){
            holder.linearLayout_item9.setVisibility(View.VISIBLE);
            holder.tv_item9.setText(item9.getTitle());
            holder.tv_item9_value.setText(item9.getValue());
        }else{
            holder.linearLayout_item9.setVisibility(View.GONE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.device_item_list5;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {
        private LinearLayout container_content;
        private LinearLayout linearLayout_item1,linearLayout_item2,linearLayout_item3,linearLayout_item4,linearLayout_item5,linearLayout_item6,linearLayout_item7,linearLayout_item8,linearLayout_item9;
        private TextView tv_item1,tv_item2,tv_item3,tv_item4,tv_item5,tv_item6,tv_item7,tv_item8,tv_item9;
        private TextView tv_item1_value,tv_item2_value,tv_item3_value,tv_item4_value,tv_item5_value,tv_item6_value,tv_item7_value,tv_item8_value,tv_item9_value;
        private TextView tv_device_name;//设备名称
//        private TextView tv_rl_type;//燃料类型
//        private TextView tv_jz_type;//介质类型
        private TextView warn_mesage;
        private ImageView iv_waarn;
        private LinearLayout relativeLayout;
        private ImageView iv_bg;


        public ViewHolder(View rootView) {
            super(rootView);
            context=rootView.getContext();
            linearLayout_item1=(LinearLayout)rootView.findViewById(R.id.linear_item1);
            linearLayout_item2=(LinearLayout)rootView.findViewById(R.id.linear_item2);
            linearLayout_item3=(LinearLayout)rootView.findViewById(R.id.linear_item3);
            linearLayout_item4=(LinearLayout)rootView.findViewById(R.id.linear_item4);
            linearLayout_item5=(LinearLayout)rootView.findViewById(R.id.linear_item5);
            linearLayout_item6=(LinearLayout)rootView.findViewById(R.id.linear_item6);
            linearLayout_item7=(LinearLayout)rootView.findViewById(R.id.linear_item7);
            linearLayout_item8=(LinearLayout)rootView.findViewById(R.id.linear_item8);
            linearLayout_item9=(LinearLayout)rootView.findViewById(R.id.linear_item9);
            tv_item1=(TextView)rootView.findViewById(R.id.tv_item1);
            tv_item2=(TextView)rootView.findViewById(R.id.tv_item2);
            tv_item3=(TextView)rootView.findViewById(R.id.tv_item3);
            tv_item4=(TextView)rootView.findViewById(R.id.tv_item4);
            tv_item5=(TextView)rootView.findViewById(R.id.tv_item5);
            tv_item6=(TextView)rootView.findViewById(R.id.tv_item6);
            tv_item7=(TextView)rootView.findViewById(R.id.tv_item7);
            tv_item8=(TextView)rootView.findViewById(R.id.tv_item8);
            tv_item9=(TextView)rootView.findViewById(R.id.tv_item9);
            tv_item1_value=(TextView)rootView.findViewById(R.id.tv_item1_value);
            tv_item2_value=(TextView)rootView.findViewById(R.id.tv_item2_value);
            tv_item3_value=(TextView)rootView.findViewById(R.id.tv_item3_value);
            tv_item4_value=(TextView)rootView.findViewById(R.id.tv_item4_value);
            tv_item5_value=(TextView)rootView.findViewById(R.id.tv_item5_value);
            tv_item6_value=(TextView)rootView.findViewById(R.id.tv_item6_value);
            tv_item7_value=(TextView)rootView.findViewById(R.id.tv_item7_value);
            tv_item8_value=(TextView)rootView.findViewById(R.id.tv_item8_value);
            tv_item9_value=(TextView)rootView.findViewById(R.id.tv_item9_value);
            tv_device_name=(TextView)rootView.findViewById(R.id.tv_device_name);
            warn_mesage=(TextView)rootView.findViewById(R.id.tv_bj_xx);
            iv_waarn=(ImageView)rootView.findViewById(R.id.iv_warn);
            relativeLayout=(LinearLayout) rootView.findViewById(R.id.reliative_item);
            iv_bg=(ImageView)rootView.findViewById(R.id.iv_bg);
        }

    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    private  void playSounds(final int sound, final int number,boolean tag){
        if(soundPool==null)soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        spMap = new HashMap<Integer,Integer>();
        if(tag)spMap.put(1, soundPool.load(context.getApplicationContext(), R.raw.alarm, 1));
        else spMap.put(1,soundPool.load(context.getApplicationContext(),R.raw.alarm,1));
        AudioManager am = (AudioManager)context.getApplicationContext().getSystemService(context.getApplicationContext().AUDIO_SERVICE);

        float audioMaxVolumn = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float audioCurrentVolumn = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float volumnRatio = audioCurrentVolumn/audioMaxVolumn;
        if(!am.isMusicActive()){
            playID=soundPool.play(spMap.get(sound), volumnRatio, volumnRatio, 1, number, 1);
        }else{
//		        	int b=playID;
        }
    }
    /**
     * 关闭声音
     */
    private void stopSounds(){
        if(soundPool!=null){
            soundPool.stop(playID);
            soundPool.release();
        }
        spMap=null;
        soundPool=null;
    }

    /**
     * 通知
     */
    private void warn(String message){
        onItemClickListener.onItemClick(message,1);
    }
}
