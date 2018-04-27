package com.example.administrator.checkdevices.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseCompatActivity;
import com.example.administrator.checkdevices.model.entities.Res;
import com.example.administrator.checkdevices.network.Network;
import com.example.administrator.checkdevices.network.ProgressSubscriber;
import com.example.administrator.checkdevices.network.SubscriberOnNextListener;
import com.example.administrator.checkdevices.utils.ToastUtil;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePwdActivity extends BaseCompatActivity {
    @BindView(R.id.tv_oldpwd)
    TextView tv_oldpwd;
    @BindView(R.id.tv_newpwd)
    TextView tv_newpwd;
    @BindView(R.id.tv_newpwd2)
    TextView tv_newpwd2;
    @BindView(R.id.bt_ok)
    QMUIRoundButton bt_ok;
    @BindView(R.id.et_oldpwd)
    EditText et_oldpwd;
    @BindView(R.id.et_newpwd)
    EditText et_newpwd;
    @BindView(R.id.et_newpwd2)
    EditText et_newpwd2;
    private static int type=0;
    private QMUITipDialog tipDialog;
    private SubscriberOnNextListener getLoginOnNext;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_change_pwd);
    }

    @Override
    public void initView() {
       switch (type){
           case 1://修改密码
               tv_oldpwd.setText("原密码：");
               tv_newpwd.setText("新密码：");
               tv_newpwd2.setText("确认密码：");
               et_oldpwd.setHint("请输入原密码");
               et_newpwd.setHint("请输入新密码");
               et_newpwd2.setHint("请确认新密码");
               break;
           case 2://修改手机
               tv_oldpwd.setText("原手机号：");
               tv_newpwd.setText("新手机号：");
               tv_newpwd2.setText("确认手机号：");
               et_oldpwd.setHint("请输入原手机号");
               et_newpwd.setHint("请输入新手机号");
               et_newpwd2.setHint("请确认新手机号");
               break;
           case 3://修改微信
               tv_oldpwd.setText("原微信号：");
               tv_newpwd.setText("新微信号：");
               tv_newpwd2.setText("确认微信号：");
               et_oldpwd.setHint("请输入原微信号");
               et_newpwd.setHint("请输入新微信号");
               et_newpwd2.setHint("请确认新微信号");
               break;
           case 4://修改用户名
               tv_oldpwd.setText("原用户名：");
               tv_newpwd.setText("新用户名：");
               tv_newpwd2.setText("确认用户名：");
               et_oldpwd.setHint("请输入原用户名");
               et_newpwd.setHint("请输入新用户名");
               et_newpwd2.setHint("请确认新用户名");
           default:
               break;
       }
        getLoginOnNext=new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                if(o instanceof String){
                    String  res=(String)o;
                    if(res.equals("ok")){
//                        ToastUtil.showToast(ChangePwdActivity.this,R.string.operator_success);
                    }else{
//                        ToastUtil.showToast(ChangePwdActivity.this,R.string.operator_fail);
                    }
                }
            }
            @Override
            public void onComplete(Object o) {
//                ToastUtil.showToast(ChangePwdActivity.this,"lll");
            }
        };
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public static void start(Context context,int type){
        setType(type);
        Intent intent = new Intent(context, ChangePwdActivity.class);
        context.startActivity(intent);

    }

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        ChangePwdActivity.type = type;
    }
    @OnClick(R.id.bt_ok)
    public void changOperator(){
        String param1=et_oldpwd.getText().toString();
        String param2=et_newpwd.getText().toString();
        String param3=et_newpwd2.getText().toString();
        if(param1.equals("")||param2.equals("")||param3.equals("")){
            ToastUtil.showToast(this,"有未输入项，请确认！");
            return;
        }
        switch (type){
            case 1:
                if(!param2.equals(param3))ToastUtil.showToast(this,"两次输入新密码不相同！");
//                Network.getInstance().changePwd(new ProgressSubscriber<String>(getLoginOnNext,ChangePwdActivity.this),param1,param2);
                break;
            case 2:
                if(!param2.equals(param3))ToastUtil.showToast(this,"两次输入新手机号不相同！");
                break;
            case 3:
                if(!param2.equals(param3))ToastUtil.showToast(this,"两次输入新微信号不相同！");
                break;
            case 4:
                if(!param2.equals(param3))ToastUtil.showToast(this,"两次输入用户名不相同！");
                break;
            default:
                break;
        }
    }
}
