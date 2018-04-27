package com.example.administrator.checkdevices.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.widget.AppCompatCheckBox;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseCompatActivity;
import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.model.entities.Res_login2;
import com.example.administrator.checkdevices.model.login_devices;
import com.example.administrator.checkdevices.network.Network;
import com.example.administrator.checkdevices.network.ProgressSubscriber;
import com.example.administrator.checkdevices.network.SubscriberOnNextListener;
import com.example.administrator.checkdevices.updateversion.AppUpdateManager;
import com.example.administrator.checkdevices.updateversion.CProgressDialogUtils;
import com.example.administrator.checkdevices.updateversion.DownloadService;
import com.example.administrator.checkdevices.updateversion.HProgressDialogUtils;
import com.example.administrator.checkdevices.updateversion.OkGoUpdateHttpUtil;
import com.example.administrator.checkdevices.updateversion.UpdateAppBean;
import com.example.administrator.checkdevices.updateversion.UpdateCallback;
import com.example.administrator.checkdevices.utils.Constant;
import com.example.administrator.checkdevices.utils.DeviceAdapterUtil;
import com.example.administrator.checkdevices.utils.NetUtils;
import com.example.administrator.checkdevices.utils.SPUtils;
import com.example.administrator.checkdevices.utils.ToastUtil;
import com.qmuiteam.qmui.util.QMUIPackageHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import okhttp3.ResponseBody;

public class LoginActivity extends BaseCompatActivity {
    @BindView(R.id.loginButton)
    Button login_button;
    @BindView(R.id.nameEditText)
    EditText et_account;
    @BindView(R.id.passwordEditText)
    EditText et_password;
    @BindView(R.id.checkbox_remember)
    AppCompatCheckBox checkBox_remeber;
    @BindView(R.id.checkbox_autologin)
    AppCompatCheckBox checkBox_autologin;
    @BindView(R.id.btn_login_state)
    TextView app_version;
    private SubscriberOnNextListener getLoginOnNext;
    String  version_dq="";//当前版本号
    private boolean isShowDownloadProgress;
    @Override
    public void initContentView() {
        QMUIStatusBarHelper.translucent(this);
        setContentView(R.layout.login_activity);
        updateDiy3();
    }
    @Override
    public void initView() {
        getLoginOnNext=new SubscriberOnNextListener() {
            @Override
            public void onNext(Object o) {
                if(o instanceof Res_login2){
                    Res_login2 res=(Res_login2) o;
                    if(res.getCode().equals("1")){
                        login2(res);
                    }else{
                        ToastUtil.showToast(LoginActivity.this,R.string.instapager_email_or_password_incorrect);
                    }
                }
            }
            @Override
            public void onComplete(Object o) {
            }
        };
        app_version.setText("泰安步科赛尔电气有限公司（v "+QMUIPackageHelper.getAppVersion(this)+"）");
        if((Boolean) SPUtils.get(getApplicationContext(),"remember",false))checkBox_remeber.setChecked(true);
        if((Boolean)SPUtils.get(getApplicationContext(),"auto_login",false))checkBox_autologin.setChecked(true);
        if(SPUtils.contains(getApplicationContext(),"fasong_jiange")){
            Constant.fasong_jiange=(long)(SPUtils.get(getApplicationContext(),"fasong_jiange",Constant.fasong_jiange));
        }
        if(SPUtils.contains(getApplicationContext(),"account"))et_account.setText((String)SPUtils.get(getApplicationContext(),"account",""));
        if(checkBox_remeber.isChecked()&&SPUtils.contains(getApplicationContext(),"password"))et_password.setText((String)SPUtils.get(getApplicationContext(),"password",""));
        if(checkBox_autologin.isChecked())login();
    }
    @OnClick(R.id.loginButton)
    public void login(){
       String username=et_account.getText().toString();
        String password=et_password.getText().toString();
        if(username.equals("")||password.equals("")){
            Toast.makeText(this,R.string.instapager_email_or_password_input,Toast.LENGTH_LONG).show();
            return;
        }
        if(NetUtils.isNetworkConnected(getApplicationContext()))Network.getInstance().login(new ProgressSubscriber<Res_login2>(getLoginOnNext,LoginActivity.this,true),username,password);
    }
    @OnCheckedChanged(R.id.checkbox_remember)
    public void remeber(){
        if(checkBox_remeber.isChecked()){
            SPUtils.put(getApplicationContext(),"remember",true);
        }else{
            SPUtils.put(getApplicationContext(),"remember",false);
        }
    }
    @OnCheckedChanged(R.id.checkbox_autologin)
    public void auto_login(){
        if(checkBox_autologin.isChecked()){
            SPUtils.put(getApplicationContext(),"auto_login",true);
        }else{
            SPUtils.put(getApplicationContext(),"auto_login",false);
        }
    }

    @Override
    public void initPresenter()   {

    }
    private void login2(Res_login2 res){
//        List<login_devices>list=res.getDevices();
//        login_devices login_devices=list.get(0);
//        login_devices.setDeviceNo("T01800NJZJ0000000003");
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, MainFragmentActivity
                .class);
        intent.putExtra("res",res);
        startActivity(intent);
        String msg=res.getMsg();
        if(checkBox_remeber.isChecked())SPUtils.put(getApplicationContext(),"password",et_password.getText());
        if(!checkBox_remeber.isChecked()&&SPUtils.contains(getApplicationContext(),"password"))SPUtils.remove(getApplicationContext(),"password");
        SPUtils.put(getApplicationContext(),"account",et_account.getText());
        ToastUtil.showToast(LoginActivity.this,msg);
        finish();

    }

    /**
     * 初始化参数
     */
    private void initParam(){
        if(SPUtils.contains(this.getApplicationContext(),"waran_type")){
            int warn_type=(int)SPUtils.get(this.getApplicationContext(),"warn_type",Constant.warn_type);
            if(warn_type!=-1){
                Constant.warn_type=warn_type;
            }
        }else{
            SPUtils.put(this.getApplicationContext(),"warn_type",Constant.warn_type);
        }
    }
    /**
     * 版本更新
     */
    private void diyUpdate() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        version_dq=QMUIPackageHelper.getAppVersion(this);

        Map<String, String> params = new HashMap<String, String>();
        new AppUpdateManager
                .Builder()
                .setActivity(this)
                .setHttpManager(new OkGoUpdateHttpUtil())
                .setUpdateUrl(Constant.getVersionUrl)
                .setPost(false)
                .setParams(params)
                .setTargetPath(path)
                .build()
                .checkNewApp(new UpdateCallback() {
                    /**
                     * 解析json,自定义协议
                     *
                     * @param json 服务器返回的json
                     * @return UpdateAppBean
                     */
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        Pattern p= Pattern.compile("\t|\r|\n");
                        Matcher m=p.matcher(json);
                        json=m.replaceAll("");
                        UpdateAppBean updateAppBean = new UpdateAppBean();
                        updateAppBean.setNewVersion(json);
                        updateAppBean.setApkFileUrl(Constant.downUrl);
                        updateAppBean.setUpdate("Yes");
                        updateAppBean.setUpdateLog("该版本修复了部分bug及缺陷!");
                        return updateAppBean;
                    }

                    /**
                     * 有新版本
                     *
                     * @param updateApp        新版本信息
                     * @param updateAppManager app更新管理器
                     */
                    @Override
                    public void hasNewApp(UpdateAppBean updateApp, AppUpdateManager updateAppManager) {
                        //强制更新，
                        if (updateApp.isConstraint()) {

                        } else {

                        }
                        int a=NetUtils.compareVersion(version_dq,updateApp.getNewVersion());
                        if(a<0)
                        //自定义对话框
                        showDiyDialog(updateApp, updateAppManager);
                    }

                    /**
                     * 网络请求之前
                     */
                    @Override
                    public void onBefore() {
                        CProgressDialogUtils.showProgressDialog(LoginActivity.this);
                    }

                    /**
                     * 网路请求之后
                     */
                    @Override
                    public void onAfter() {
                        CProgressDialogUtils.cancelProgressDialog(LoginActivity.this);
                    }

                    /**
                     * 没有新版本
                     */
                    @Override
                    public void noNewApp(String error) {
                        Toast.makeText(LoginActivity.this, "没有新版本", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * 自定义接口协议+自定义对话框+显示进度对话框
     *
     */
    public void updateDiy3() {
//        显示下载进度
        isShowDownloadProgress = true;
        diyUpdate();
    }

    /**
     * 自定义对话框
     *
     * @param updateApp
     * @param updateAppManager
     */
    private void showDiyDialog(final UpdateAppBean updateApp, final AppUpdateManager updateAppManager) {
        new AlertDialog.Builder(this)
                .setTitle(String.format("有新的版本，是否需要升级？", updateApp.getNewVersion()))
                .setMessage("")
                .setPositiveButton("升级", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //显示下载进度
                        if (isShowDownloadProgress) {
                            updateAppManager.download(new DownloadService.DownloadCallback() {
                                @Override
                                public void onStart() {
                                    HProgressDialogUtils.showHorizontalProgressDialog(LoginActivity.this, "下载进度", false);
                                }

                                /**
                                 * 进度
                                 *
                                 * @param progress  进度 0.00 -1.00 ，总大小
                                 * @param totalSize 总大小 单位B
                                 */
                                @Override
                                public void onProgress(float progress, long totalSize) {
                                    HProgressDialogUtils.setProgress(Math.round(progress * 100));
                                }

                                /**
                                 *
                                 * @param total 总大小 单位B
                                 */
                                @Override
                                public void setMax(long total) {

                                }


                                @Override
                                public boolean onFinish(File file) {
                                    HProgressDialogUtils.cancel();
                                    return true;
                                }

                                @Override
                                public void onError(String msg) {
                                    Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                                    HProgressDialogUtils.cancel();

                                }

                                @Override
                                public boolean onInstallAppAndAppOnForeground(File file) {
                                    return false;
                                }
                            });
                        } else {
                            //不显示下载进度
                            updateAppManager.download();
                        }


                        dialog.dismiss();
                    }
                })
                .setNegativeButton("暂不升级", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
