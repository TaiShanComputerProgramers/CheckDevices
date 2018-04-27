package com.example.administrator.checkdevices.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.base.BaseCompatActivity;
import com.qmuiteam.qmui.util.QMUIPackageHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;

/**
 * 关于界面
 *
 * Created by Kayo on 2016/11/18.
 */
public class AboutActivity extends BaseCompatActivity {

    @BindView(R.id.topbar) QMUITopBar mTopBar;
    @BindView(R.id.version) TextView mVersionTextView;
    @BindView(R.id.about_list) QMUIGroupListView mAboutGroupListView;
    @BindView(R.id.copyright) TextView mCopyrightTextView;


    @Override
    public void initContentView() {
        setContentView(R.layout.fragment_about);
    }

    @Override
    public void initView() {
        initTopBar();
        mVersionTextView.setText(QMUIPackageHelper.getAppVersion(this));
        QMUIGroupListView.newSection(this)
                .addItemView(mAboutGroupListView.createItemView(getResources().getString(R.string.about_item_homepage)), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "http://www.bkse.cn/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .addTo(mAboutGroupListView);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.CHINA);
        String currentYear = dateFormat.format(new java.util.Date());
        mCopyrightTextView.setText(String.format(getResources().getString(R.string.about_copyright), currentYear));
    }

    @Override
    public void initPresenter() {

    }
    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mTopBar.setTitle(getResources().getString(R.string.about_title));
    }

    public static void start(Context context){
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);

    }
}
