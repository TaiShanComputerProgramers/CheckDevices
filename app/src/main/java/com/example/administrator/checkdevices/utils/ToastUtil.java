package com.example.administrator.checkdevices.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Toast;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

public class ToastUtil {
	private static ProgressDialog progressDialog;
	public static void showToast(Context context, String msg) {
         Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	
	public static void showToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
	}

	/**
	 *成功提示
	 * @param context
	 * @param message
	 */
	public static void showSuccessTip(Context context,String message){
		final QMUITipDialog tipDialog = new QMUITipDialog.Builder(context)
				.setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
				.setTipWord(message)
				.create();
		tipDialog.show();
		Handler handler=new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run() {
				tipDialog.dismiss();
			}
		},1000);
	}
	/**
	 *失败提示
	 * @param context
	 * @param message
	 */
	public static void showFailTip(Context context,String message){
		final QMUITipDialog tipDialog2 = new QMUITipDialog.Builder(context)
				.setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
				.setTipWord(message)
				.create();
		tipDialog2.show();
		Handler handler=new Handler();
		handler.postDelayed(new Runnable(){
			@Override
			public void run() {
				tipDialog2.dismiss();
			}
		},1000);
	}

	public static void cancleProgressDialog() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.cancel();
			progressDialog = null;
		}
	}

	public static void showProgressDialog(Context context, String message) {
		if(progressDialog==null)progressDialog = new ProgressDialog(context);
		progressDialog.setMessage(message);
		progressDialog.setCanceledOnTouchOutside(false);
		progressDialog.setCancelable(false);
		progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {

			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if (KeyEvent.KEYCODE_BACK == keyCode) {
					cancleProgressDialog();
				}
				return false;
			}
		});
		if (!progressDialog.isShowing()) {
			progressDialog.show();
		}
	}
	
}
