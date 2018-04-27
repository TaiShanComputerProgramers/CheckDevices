package com.example.administrator.checkdevices.base;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment2 extends Fragment {
    private View mLayoutView;
    private Unbinder unbinder;
    private long time_jiange=5;
    private static final String STATE_SAVE_IS_HIDDEN="STATE_SAVE_IS_HIDDEN";
    protected String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    protected String[] mParties = new String[] {
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

    protected Typeface mTfRegular;
    protected Typeface mTfLight;

    /**
     * 初始化布局
     * @return 布局文件的id。
     */
    public abstract int getLayoutRes();

    /**
     * 初始化视图
     */
    public abstract void initView(View view);

    /**
     * 如果Fragment创建需要数据，在这里接收传进来的数据。
     * 如果没有这个抽象方法就空实现。
     */
    protected abstract void managerArguments();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        QMUIStatusBarHelper.translucent(getActivity());
        mTfRegular = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
        mTfLight = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf");
        if (getArguments() != null) {
            managerArguments();
        }
    }
    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder!=null&&getTag()!=null)unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //防重叠
        if(savedInstanceState!=null){
            boolean isSupportHidden=savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction fragementTransaction=getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                fragementTransaction.hide(this);
            } else {
                fragementTransaction.show(this);
            }
            fragementTransaction.commit();
        }
        //20160727 修复该方法多次调用 bug
        if (mLayoutView != null) {
            ViewGroup parent = (ViewGroup) mLayoutView.getParent();
            if (parent != null) {
                parent.removeView(mLayoutView);
            }
        } else {
            mLayoutView = getCreateView(inflater, container);
            unbinder= ButterKnife.bind(this, mLayoutView);
//            StateBarTranslucentUtils.setStateBarTranslucent(getActivity());
            initView(mLayoutView);     //初始化布局
        }

        return mLayoutView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN,isHidden());
    }

    /**
     * 获取Fragment布局文件的View
     *
     * @param inflater
     * @param container
     * @return
     */
    private View getCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    /**
     * 获取当前Fragment状态
     *
     * @return true为正常 false为未加载或正在删除
     */
    private boolean getStatus() {
        return (isAdded() && !isRemoving());
    }



    @Override
    public Context getContext() {
        return getActivity();
    }

    public void onResume() {
        super.onResume();
//        startSendData();

    }
    public void onPause() {
        super.onPause();
    }

    public abstract String getUmengFragmentName();



}
