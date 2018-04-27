package com.example.administrator.checkdevices.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/30.
 */

public class CustomerDialog extends Dialog {
        public CustomerDialog(Context context) {
            this(context, com.qmuiteam.qmui.R.style.QMUI_Dialog);
        }

        public CustomerDialog(Context context, int styleRes) {
            super(context, styleRes);
            init();
        }

        private void init() {
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initDialogWidth();
        }

        private void initDialogWidth() {
            Window window = getWindow();
            if (window == null) {
                return;
            }
            window.setDimAmount(0.6f); // 部分刷机会导致背景透明，这里保证一次
            WindowManager.LayoutParams wmlp = window.getAttributes();
            wmlp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            window.setAttributes(wmlp);
        }
        /**
         * 带输入框的对话框 Builder
         */
        public static class EditTextDialogBuilder extends QMUIDialogBuilder<CustomerDialog.EditTextDialogBuilder> {
            protected String mPlaceholder;
            protected String mPlaceholder2;
            protected String mPlaceholder3;
            protected TransformationMethod mTransformationMethod;
            protected LinearLayout mMainLayout;
            protected EditText mEditText;
            protected EditText mEditText2;
            protected EditText mEditText3;
            protected ImageView mRightImageView;
            protected ImageView mRightImageView2;
            protected ImageView mRightImageView3;
            private int mInputType = InputType.TYPE_CLASS_TEXT;

            public EditTextDialogBuilder(Context context) {
                super(context);
                mEditText = new EditText(mContext);
                mEditText.setHintTextColor(QMUIResHelper.getAttrColor(mContext, com.qmuiteam.qmui.R.attr.qmui_config_color_gray_3));
                mEditText.setTextColor(QMUIResHelper.getAttrColor(mContext, com.qmuiteam.qmui.R.attr.qmui_config_color_black));
                mEditText.setTextSize(TypedValue.COMPLEX_UNIT_PX, QMUIResHelper.getAttrDimen(mContext, com.qmuiteam.qmui.R.attr.qmui_dialog_content_message_text_size));
                mEditText.setFocusable(true);
                mEditText.setFocusableInTouchMode(true);
                mEditText.setImeOptions(EditorInfo.IME_ACTION_GO);
                mEditText.setGravity(Gravity.CENTER_VERTICAL);
                mEditText.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_input);

                mRightImageView = new ImageView(mContext);
                mRightImageView.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_right_icon);
                mRightImageView.setVisibility(View.GONE);

                mEditText2 = new EditText(mContext);
                mEditText2.setHintTextColor(QMUIResHelper.getAttrColor(mContext, com.qmuiteam.qmui.R.attr.qmui_config_color_gray_3));
                mEditText2.setTextColor(QMUIResHelper.getAttrColor(mContext, com.qmuiteam.qmui.R.attr.qmui_config_color_black));
                mEditText2.setTextSize(TypedValue.COMPLEX_UNIT_PX, QMUIResHelper.getAttrDimen(mContext, com.qmuiteam.qmui.R.attr.qmui_dialog_content_message_text_size));
                mEditText2.setFocusable(true);
                mEditText2.setFocusableInTouchMode(true);
                mEditText2.setImeOptions(EditorInfo.IME_ACTION_GO);
                mEditText2.setGravity(Gravity.CENTER_VERTICAL);
                mEditText2.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_input);

                mRightImageView2 = new ImageView(mContext);
                mRightImageView2.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_right_icon);
                mRightImageView2.setVisibility(View.GONE);

                mEditText3 = new EditText(mContext);
                mEditText3.setHintTextColor(QMUIResHelper.getAttrColor(mContext, com.qmuiteam.qmui.R.attr.qmui_config_color_gray_3));
                mEditText3.setTextColor(QMUIResHelper.getAttrColor(mContext, com.qmuiteam.qmui.R.attr.qmui_config_color_black));
                mEditText3.setTextSize(TypedValue.COMPLEX_UNIT_PX, QMUIResHelper.getAttrDimen(mContext, com.qmuiteam.qmui.R.attr.qmui_dialog_content_message_text_size));
                mEditText3.setFocusable(true);
                mEditText3.setFocusableInTouchMode(true);
                mEditText3.setImeOptions(EditorInfo.IME_ACTION_GO);
                mEditText3.setGravity(Gravity.CENTER_VERTICAL);
                mEditText3.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_input);

                mRightImageView3 = new ImageView(mContext);
                mRightImageView3.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_right_icon);
                mRightImageView3.setVisibility(View.GONE);
            }

            /**
             * 设置输入框的 placeholder
             */
            public EditTextDialogBuilder setPlaceholder(String placeholder) {
                this.mPlaceholder = placeholder;
                return this;
            }
            /**
             * 设置输入框的 placeholder
             */
            public EditTextDialogBuilder setPlaceholder2(String placeholder) {
                this.mPlaceholder2 = placeholder;
                return this;
            }
            /**
             * 设置输入框的 placeholder
             */
            public EditTextDialogBuilder setPlaceholder3(String placeholder) {
                this.mPlaceholder3 = placeholder;
                return this;
            }

            /**
             * 设置输入框的 placeholder
             */
            public EditTextDialogBuilder setPlaceholder(int resId) {
                return setPlaceholder(mContext.getResources().getString(resId));
            }

            /**
             * 设置 EditText 的 transformationMethod
             */
            public EditTextDialogBuilder setTransformationMethod(TransformationMethod transformationMethod) {
                mTransformationMethod = transformationMethod;
                return this;
            }

            /**
             * 设置 EditText 的 inputType
             */
            public EditTextDialogBuilder setInputType(int inputType) {
                mInputType = inputType;
                return this;
            }

            @Override
            protected void onCreateContent(com.qmuiteam.qmui.widget.dialog.QMUIDialog dialog, ViewGroup parent) {
                mMainLayout = new LinearLayout(mContext);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.topMargin = QMUIResHelper.getAttrDimen(mContext, hasTitle() ? com.qmuiteam.qmui.R.attr.qmui_dialog_edit_content_padding_top : com.qmuiteam.qmui.R.attr.qmui_dialog_content_padding_top_when_no_title);
                lp.leftMargin = QMUIResHelper.getAttrDimen(mContext, com.qmuiteam.qmui.R.attr.qmui_dialog_padding_horizontal);
                lp.rightMargin = QMUIResHelper.getAttrDimen(mContext, com.qmuiteam.qmui.R.attr.qmui_dialog_padding_horizontal);
                lp.bottomMargin = QMUIResHelper.getAttrDimen(mContext, com.qmuiteam.qmui.R.attr.qmui_dialog_edit_content_padding_bottom);
//                mMainLayout.setBackgroundResource(com.qmuiteam.qmui.R.drawable.qmui_edittext_bg_border_bottom);
                mMainLayout.setLayoutParams(lp);
                mMainLayout.setOrientation(LinearLayout.VERTICAL);

                if (mTransformationMethod != null) {
                    mEditText.setTransformationMethod(mTransformationMethod);
                    mEditText2.setTransformationMethod(mTransformationMethod);
                    mEditText3.setTransformationMethod(mTransformationMethod);
                } else {
                    mEditText.setInputType(mInputType);
                    mEditText2.setInputType(mInputType);
                    mEditText3.setInputType(mInputType);
                }

                mEditText.setBackgroundResource(com.qmuiteam.qmui.R.drawable.qmui_edittext_bg_border_bottom);
                mEditText.setPadding(0, 0, 0, QMUIDisplayHelper.dpToPx(5));
                RelativeLayout.LayoutParams editLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                editLp.addRule(RelativeLayout.LEFT_OF, mRightImageView.getId());
                editLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
                mEditText2.setBackgroundResource(com.qmuiteam.qmui.R.drawable.qmui_edittext_bg_border_bottom);
                mEditText2.setPadding(0, 0, 0, QMUIDisplayHelper.dpToPx(5));
                RelativeLayout.LayoutParams editLp2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                editLp.addRule(RelativeLayout.LEFT_OF, mRightImageView2.getId());
                editLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
                mEditText3.setBackgroundResource(com.qmuiteam.qmui.R.drawable.qmui_edittext_bg_border_bottom);
                mEditText3.setPadding(0, 0, 0, QMUIDisplayHelper.dpToPx(5));
                RelativeLayout.LayoutParams editLp3 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                editLp.addRule(RelativeLayout.LEFT_OF, mRightImageView3.getId());
                editLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

                if (mPlaceholder != null) {
                    mEditText.setHint(mPlaceholder);
                }
                if(mPlaceholder2!=null)
                    mEditText2.setHint(mPlaceholder2);
                if(mPlaceholder3!=null)
                    mEditText3.setHint(mPlaceholder3);
                mMainLayout.addView(mEditText, createEditTextLayoutParams(mRightImageView));
                mMainLayout.addView(mRightImageView, createRightIconLayoutParams());

                mMainLayout.addView(mEditText2, createEditTextLayoutParams(mRightImageView2));
                mMainLayout.addView(mRightImageView2, createRightIconLayoutParams());

                mMainLayout.addView(mEditText3, createEditTextLayoutParams(mRightImageView3));
                mMainLayout.addView(mRightImageView3, createRightIconLayoutParams());

                parent.addView(mMainLayout);
            }

            protected LinearLayout.LayoutParams createEditTextLayoutParams(ImageView view) {
                LinearLayout.LayoutParams editLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                editLp.addRule(RelativeLayout.LEFT_OF, view.getId());
//                editLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
                editLp.topMargin=QMUIResHelper.getAttrDimen(mContext, hasTitle() ? com.qmuiteam.qmui.R.attr.qmui_dialog_edit_content_padding_top : com.qmuiteam.qmui.R.attr.qmui_dialog_content_padding_top_when_no_title);
                return editLp;
            }

            protected RelativeLayout.LayoutParams createRightIconLayoutParams() {
                RelativeLayout.LayoutParams rightIconLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                rightIconLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                rightIconLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
                rightIconLp.leftMargin = QMUIDisplayHelper.dpToPx(5);
                return rightIconLp;
            }

            @Override
            protected void onAfter(com.qmuiteam.qmui.widget.dialog.QMUIDialog dialog, LinearLayout parent) {
                super.onAfter(dialog, parent);
                dialog.setOnDismissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ((InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
                    }
                });
                mEditText.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mEditText.requestFocus();
                        ((InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(mEditText, 0);
                    }
                }, 300);
            }

            public EditText getEditText() {
                return mEditText;
            }
            public EditText getEditText2() {
                return mEditText2;
            }
            public EditText getEditText3() {
                return mEditText3;
            }

            public ImageView getRightImageView() {
                return mRightImageView;
            }
        }



        /**
         * 自定义对话框内容区域的 Builder
         */
        public static class CustomDialogBuilder extends QMUIDialogBuilder {

            private int mLayoutId;

            public CustomDialogBuilder(Context context) {
                super(context);
            }

            /**
             * 设置内容区域的 layoutResId
             */
            public CustomDialogBuilder setLayout(@LayoutRes int layoutResId) {
                mLayoutId = layoutResId;
                return this;
            }

            @Override
            protected void onCreateContent(com.qmuiteam.qmui.widget.dialog.QMUIDialog dialog, ViewGroup parent) {
                parent.addView(LayoutInflater.from(mContext).inflate(mLayoutId, parent, false));
            }
        }
    }

