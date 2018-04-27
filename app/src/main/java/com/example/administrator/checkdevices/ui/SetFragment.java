package com.example.administrator.checkdevices.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.NotificationCompat;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseFragment;
import com.example.administrator.checkdevices.model.QDItemDescription;
import com.example.administrator.checkdevices.utils.Constant;
import com.example.administrator.checkdevices.utils.SPUtils;
import com.example.administrator.checkdevices.widget.CustomerDialog;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wd on 2017/10/16.
 *
 * @author wd
 * @date 2017/10/16
 * @describe TODO
 * @package reli.kdzt.com.gongretong.view
 */

public class SetFragment extends BaseFragment {
    private Context mContext;
     @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;
    private QDItemDescription mQDItemDescription;

    private void initTopBar() {
      /* mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });*/
        mTopBar.setTitle("设置");
    }

    @Override
    protected View onCreateView() {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_set, null);
        ButterKnife.bind(this, root);
        mContext=getContext();

        initTopBar();

        initGroupListView();

        return root;
    }

    private void initGroupListView() {
        QMUICommonListItemView nameItem = mGroupListView.createItemView(getResources().getString(R.string.name));
        String username="";
        if(SPUtils.contains(getActivity().getApplicationContext(),"account")){
            username=(String)SPUtils.get(getActivity().getApplicationContext(),"account",Constant.user_name);
        }
        if(username.equals("")){
            username=Constant.user_name;
        }
        nameItem.setDetailText(username);
        nameItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        /*QMUICommonListItemView weixinItem = mGroupListView.createItemView(getResources().getString(R.string.weixin));
        weixinItem.setDetailText("微信名");
        weixinItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);*/


        QMUICommonListItemView telItem = mGroupListView.createItemView(getResources().getString(R.string.tel));
        String tel_num="";
        if(SPUtils.contains(getActivity().getApplicationContext(),"tel")){
            tel_num=(String)SPUtils.get(getActivity().getApplicationContext(),"tel",Constant.tel);
        }
        if(tel_num.equals("")){
            tel_num=Constant.tel;
        }
        telItem.setDetailText(tel_num);
        telItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView psdItem = mGroupListView.createItemView(getResources().getString(R.string.change_psd));
        psdItem.setOrientation(QMUICommonListItemView.VERTICAL);
        psdItem.setDetailText("点击修改密码");
        psdItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        final QMUICommonListItemView warnItem = mGroupListView.createItemView(getResources().getString(R.string.warn_type));
        warnItem.setDetailText("无");
        warnItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView set_paramItem = mGroupListView.createItemView(getResources().getString(R.string.set_param));
        set_paramItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        QMUICommonListItemView aboutItem = mGroupListView.createItemView(getResources().getString(R.string.about));
        aboutItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

        /*QMUICommonListItemView quitItem = mGroupListView.createItemView(getResources().getString(R.string.quit));
        quitItem.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);*/





        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof QMUICommonListItemView) {
                    QMUICommonListItemView view=(QMUICommonListItemView)v;
                    CharSequence text = ((QMUICommonListItemView) v).getText();
                    if(text.equals(getResources().getString(R.string.name))){
                        showEditeDialog(4,view);
//                        ChangePwdActivity.start(getActivity(),4);
                    }else if(text.equals(getResources().getString(R.string.weixin))){
                        showEditeDialog(3,view);
//                        ChangePwdActivity.start(getActivity(),3);
                    }else if(text.equals(getResources().getString(R.string.tel))){
                        showEditeDialog(2,view);
//                        ChangePwdActivity.start(getActivity(),2);
                    }else if(text.equals(getResources().getString(R.string.change_psd))){
                        showEditeDialog(1,view);
//                        ChangePwdActivity.start(getActivity(),1);
                    }else if(text.equals(getResources().getString(R.string.warn_type))){
//                        warn();
                       final String[] items = new String[]{"无","震动", "响铃","震动+响铃"};
                        new QMUIDialog.MenuDialogBuilder(getActivity())
                                .addItems(items, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        warnItem.setDetailText(items[which]);
                                        switch (which){
                                            case 0:
                                                Constant.warn_type=0;
                                                break;
                                            case 1:
                                                Constant.warn_type=1;
                                                break;
                                            case 2:
                                                Constant.warn_type=2;
                                                break;
                                            case 3:
                                                Constant.warn_type=3;
                                                break;
                                            default:
                                                break;
                                        }
//                                        Toast.makeText(getActivity(), "你选择了 " + items[which], Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                })
                                .show();
//                        showWarnDialog();
                    }else if(text.equals(getResources().getString(R.string.set_param))){
                        ParamSetActivity.start(getActivity());
                    }
                    else if(text.equals(getResources().getString(R.string.about))){
                        AboutActivity.start(getActivity());
                    }else if(text.equals(getResources().getString(R.string.quit))){
                        showMessageNegativeDialog();
                    }
//                    Toast.makeText(getActivity(), text + " is Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        };

        QMUIGroupListView.newSection(getContext())
                .setTitle("用户信息")
                .addItemView(nameItem, onClickListener)
//                .addItemView(weixinItem, onClickListener)
                .addItemView(telItem, onClickListener)
                .addItemView(psdItem, onClickListener)
                .addItemView(warnItem, onClickListener)

                .addTo(mGroupListView);

        QMUIGroupListView.newSection(getContext())
                .setTitle("系统信息")
                .addItemView(set_paramItem,onClickListener)
                .addItemView(aboutItem,onClickListener)
//                .addItemView(quitItem,onClickListener)
                .addTo(mGroupListView);
    }

    private void showEditeDialog(final int type,final QMUICommonListItemView view) {
        String message="";
        String hint_message="";
        String hint_message2="";
        String hint_message3="";
        TransformationMethod mTransformationMethod=null;//PasswordTransformationMethod 密码
        int inputType=InputType.TYPE_CLASS_TEXT;
        switch (type){
            case 1:
                message="修改密码";
                hint_message="请输入原密码";
                hint_message2="请输入新密码";
                hint_message3="请确认新密码";
                mTransformationMethod= PasswordTransformationMethod.getInstance();
                break;
            case 2:
                message="修改手机号";
                hint_message="请输入原手机号";
                hint_message2="请输入新手机号";
                hint_message3="请确认新手机号";
                break;
            case 3:
                message="修改微信";
                hint_message="请输入原微信号";
                hint_message2="请输入新微信号";
                hint_message3="请确认新微信号";
                break;
            case 4:
                message="修改用户名";
                hint_message="请输入原用户名";
                hint_message2="请输入新用户名";
                hint_message3="请确认新用户号";
                break;
        }
        final CustomerDialog.EditTextDialogBuilder builder=new CustomerDialog.EditTextDialogBuilder(getActivity());
        builder.setTitle(message)
//                .setPlaceholder(R.layout.activity_change_pwd)
                .setPlaceholder(hint_message)
                .setPlaceholder2(hint_message2)
                .setPlaceholder3(hint_message3)
                .setInputType(inputType)
                .setTransformationMethod(mTransformationMethod)
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        CharSequence text = builder.getEditText().getText();
                        CharSequence text2=builder.getEditText2().getText();
                        CharSequence text3=builder.getEditText3().getText();
                        if((text==null||text.length()<=0)||(text2==null||text2.length()<=0)||(text3==null||text3.length()<=0)){
                            Toast.makeText(getActivity(), "有输入项未输入，请确认！" , Toast.LENGTH_SHORT).show();
                            return;
                        }else if(!(text.toString()).equals(view.getDetailText().toString())){
                            Toast.makeText(getActivity(), "原有值输入不正确，请确认！" , Toast.LENGTH_SHORT).show();
                        }
                        else if(!(text2.toString()).equals(text3.toString())){
                            Toast.makeText(getActivity(), "两次输入的新内容不一致，请确认！" , Toast.LENGTH_SHORT).show();
                        }else{
                            if(type==4){
                                SPUtils.put(getActivity().getApplicationContext(),"account",text2.toString());
                            }else if(type==2){
                                SPUtils.put(getActivity().getApplicationContext(),"tel",text2.toString());
                            }
                            if(type!=1)view.setDetailText(text2.toString());
                            dialog.dismiss();
                        }

                    }
                })
                .show();
    }
    public static SetFragment getInstance() {
        SetFragment mf = new SetFragment();
        return mf;
    }
    private void showWarnDialog(){
        warn();
        /*final String[] items = new String[]{"响铃", "震动"};
        new QMUIDialog.MenuDialogBuilder(getActivity())
                .addItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "你选择了 " + items[which], Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                })
                .show();*/
    }
    //退出
    private void showMessageNegativeDialog() {
        new QMUIDialog.MessageDialogBuilder(getActivity())
                .setTitle("提示")
                .setMessage("确定要退出应用吗？")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction(0, "确定", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        /*Toast.makeText(getActivity(), "删除成功", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();*/
                        System.exit(0);
                    }
                })
                .show();
    }


    private void warn(){
        NotificationManager manager=(NotificationManager) getActivity().getSystemService(mContext.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext);
        builder.setTicker("提示内容");//通知弹出时状态栏的提示文本
        builder.setContentInfo("补充内容");
        builder.setContentTitle("Title");//通知标题
        builder.setContentText("主内容区");
        builder.setSmallIcon(R.drawable.qmui_icon_notify_info);//通知小图标
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_SOUND);//设置声音/震动等
        builder.setWhen(System.currentTimeMillis());//设置时间，设置为系统当前的时间
        /*Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pendingIntent);*/
        Notification notification = builder.build();
        /**
         * vibrate属性是一个长整型的数组，用于设置手机静止和振动的时长，以毫秒为单位。
         * 参数中下标为0的值表示手机静止的时长，下标为1的值表示手机振动的时长， 下标为2的值又表示手机静止的时长，以此类推。
         */
       /* long[] vibrates = { 0, 1000, 1000, 1000 };
        notification.vibrate = vibrates;

        *//**
         * 手机处于锁屏状态时， LED灯就会不停地闪烁， 提醒用户去查看手机,下面是绿色的灯光一 闪一闪的效果
         *//*
        notification.ledARGB = Color.GREEN;// 控制 LED 灯的颜色，一般有红绿蓝三种颜色可选
        notification.ledOnMS = 1000;// 指定 LED 灯亮起的时长，以毫秒为单位
        notification.ledOffMS = 1000;// 指定 LED 灯暗去的时长，也是以毫秒为单位
        notification.flags = Notification.FLAG_SHOW_LIGHTS;// 指定通知的一些行为，其中就包括显示*/
        // LED 灯这一选项



//                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//                notification.sound = uri;
//                notification.defaults = Notification.DEFAULT_ALL;
        //通过NotificationManager发送通知
        manager.notify(1, notification);
    }
}
