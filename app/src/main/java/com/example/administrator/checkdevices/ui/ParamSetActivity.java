package com.example.administrator.checkdevices.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseCompatActivity;
import com.example.administrator.checkdevices.utils.Constant;
import com.example.administrator.checkdevices.utils.SPUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;

/**
 * 关于界面
 *
 * Created by Kayo on 2016/12/18.
 */
public class ParamSetActivity extends BaseCompatActivity {
    @BindView(R.id.topbar) QMUITopBar mTopBar;
//    @BindView(R.id.editText_ip_sql)
//    EditText editText_ip_sql;
    @BindView(R.id.editText_fasognjiange) EditText editText_fasognjiange;


    @Override
    public void initContentView() {
        setContentView(R.layout.device_param_set);
    }

    @Override
    public void initView() {
        initTopBar();
        initData();
    }

    @Override
    public void initPresenter() {

    }
    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                initData2();
                onBackPressed();
            }
        });

        mTopBar.setTitle(getResources().getString(R.string.set_param));
    }

    public static void start(Context context){
        Intent intent = new Intent(context, ParamSetActivity.class);
        context.startActivity(intent);

    }
    private void initData(){
        String jiange="";
        /*if(SPUtils.contains(getApplicationContext(),"ip_sql")){
            url=(String) SPUtils.get(getApplicationContext(),"ip_sql",Constant.sql_url);
        }*/
        if(SPUtils.contains(getApplicationContext(),"fasong_jiange")){
            jiange=Long.toString((long)(SPUtils.get(getApplicationContext(),"fasong_jiange",Constant.fasong_jiange)));
        }
//        if(url.equals(""))url=Constant.sql_url;
        if(jiange.equals(""))jiange=Long.toString(Constant.fasong_jiange);
//        editText_ip_sql.setText(url);
        editText_fasognjiange.setText(jiange);
    }

    private boolean initData2(){
        boolean flag=false;
        String fasong_jiange=editText_fasognjiange.getText().toString();
        /*if(ip.equals("")){
            Toast.makeText(this,"请设置ip地址",Toast.LENGTH_LONG).show();
            return flag;
        }*/
        if(fasong_jiange.equals("")){
            Toast.makeText(this,"请设置发送间隔时间",Toast.LENGTH_LONG).show();
            return flag;
        }

//        SPUtils.put(getApplicationContext(),"ip_sql",editText_ip_sql.getText());
        SPUtils.put(getApplicationContext(),"fasong_jiange", Long.parseLong(editText_fasognjiange.getText().toString()));
//        Constant.sql_url=(String)SPUtils.get(getApplicationContext(),"ip_sql","");
        Constant.fasong_jiange=(long) SPUtils.get(getApplicationContext(),"fasong_jiange",Long.parseLong("60"));

          /*  DevClient devClient= DevClient.getInstance(getApplicationContext());
            devClient.stopSendMessageThread();
            devClient.startSendMessageThread(Constant.devices);*/
        return true;

    }

    @Override
    public void onBackPressed() {
        initData2();
        super.onBackPressed();
    }
}
