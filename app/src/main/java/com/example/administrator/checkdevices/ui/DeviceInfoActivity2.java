package com.example.administrator.checkdevices.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.checkdevices.R;
import com.example.administrator.checkdevices.interfaces.OnReadThreadListener;
import com.example.administrator.checkdevices.model.Device_BaseInfo;
import com.example.administrator.checkdevices.model.QDItemDescription;
import com.example.administrator.checkdevices.model.entities.Device_t;
import com.example.administrator.checkdevices.model.entities.Res;
import com.example.administrator.checkdevices.model.entities.meta.DeviceFieldForUI;
import com.example.administrator.checkdevices.network.SubscriberOnNextListener;
import com.example.administrator.checkdevices.utils.Constant;
import com.example.administrator.checkdevices.utils.DevClient;
import com.example.administrator.checkdevices.utils.NetUtils;
import com.example.administrator.checkdevices.utils.ToastUtil;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeviceInfoActivity2 extends AppCompatActivity {
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;
    @BindView(R.id.tabSegment)
    QMUITabSegment mTabSegment;
    @BindView(R.id.contentViewPager)
    ViewPager mContentViewPager;
    private Device_t device_t;


    private OnReadThreadListener onReadThreadListener;
    private ProgressDialog mProgreeDialog;
    private SubscriberOnNextListener getLoginOnNext;

    private Map<ContentPage, View> mPageMap = new HashMap<>();
    private ContentPage mDestPage = ContentPage.Item1;
    private QDItemDescription mQDItemDescription;
    private final int TAB_COUNT = 3;
    private HomeAdapter mAdapter;
    private List<String> mDatas;//报警信息
    private PagerAdapter mPagerAdapter = new PagerAdapter() {
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getCount() {
            return ContentPage.SIZE;
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            ContentPage page = ContentPage.getPage(position);
            View view = getPageView(page);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            container.addView(view, params);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_info2);
        ButterKnife.bind(this);
//        initTopBar("");
        initTabAndPager();
//        StateBarTranslucentUtils.setStateBarTranslucent(this);
        initView();
    }

  /* @OnClick(R.id.iv_get_data)
   public void getData(){
        showProgress(true,"正在获取设备信息...");

//       if(NetUtils.isNetworkConnected(getApplicationContext())) Network.getInstance().getCity(new ProgressSubscriber<Res>(getLoginOnNext,DeviceInfoActivity.this),deviceItem.getName());
   }*/
    private void initTopBar(String title) {
       mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popBackStack();
                onBackPressed();
            }
        });
        mTopBar.setTitle(title);
    }
    public void initView() {
        Intent intent=getIntent();
        device_t=(Device_t) intent.getSerializableExtra("item");
        initTopBar(device_t.getNickName());
        onReadThreadListener=new OnReadThreadListener() {
            @Override
            public void onReadData(Object o) {
                if(o instanceof Device_t){
                    Device_t device=(Device_t) o;
                    if(device_t.getDeviceNo().equals(device.getDeviceNo())){
                        device_t=device;
                        mPagerAdapter.notifyDataSetChanged();
                    }
                }

            }
        };
    }


    private Toolbar.OnMenuItemClickListener onMenuItemClickListener=new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_select:
                    break;

            }
            return true;
        }
    } ;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DevClient devClient= DevClient.getInstance(getApplicationContext());
        if(devClient.getOnReadThreadListener()==null||!devClient.getOnReadThreadListener().equals(onReadThreadListener))
            devClient.setOnReadThreadListener(onReadThreadListener,true,device_t.getDeviceNo());
        devClient.startSendMessageThread(Constant.devices);
    }
    private void showProgress(boolean flag,String message){
        if(mProgreeDialog==null){
            mProgreeDialog=new ProgressDialog(this);
            mProgreeDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgreeDialog.setCancelable(false);
            mProgreeDialog.setCanceledOnTouchOutside(false);
            mProgreeDialog.setMessage(message);
        }
        mProgreeDialog.show();
    }
    private void hideProgress(){
        if(mProgreeDialog==null)return;
        if(mProgreeDialog.isShowing())mProgreeDialog.dismiss();
    }
    private void initTabAndPager() {
        mContentViewPager.setAdapter(mPagerAdapter);
        mContentViewPager.setCurrentItem(mDestPage.getPosition(), false);
        for (int i = 0; i < TAB_COUNT; i++) {
            if(i==0)
                mTabSegment.addTab(new QMUITabSegment.Tab(getString(R.string.item1)));
            else if(i==1){
                mTabSegment.addTab(new QMUITabSegment.Tab(getString(R.string.item3)));
            }else if(i==2){
                mTabSegment.addTab(new QMUITabSegment.Tab(getString(R.string.item2)));
            }
        }
        int space = QMUIDisplayHelper.dp2px(this, 16);
        mTabSegment.setHasIndicator(true);
        mTabSegment.setMode(QMUITabSegment.MODE_FIXED);
        mTabSegment.setItemSpaceInScrollMode(space);
        mTabSegment.setupWithViewPager(mContentViewPager, false);
        mTabSegment.setPadding(space, 0, space, 0);
    }

    private View getPageView(ContentPage page) {
        View view = mPageMap.get(page);
        switch (page){
            case Item1:
                /*LayoutInflater inflater=getLayoutInflater();
                view=inflater.inflate(R.layout.device_info_1,null);*/
//                view =initItem1();
                view = initItemOne();
                /*if(deviceItem.getDeviceNo().equals("NJZJ0000000000012345")||deviceItem.getDeviceNo().equals("NJZJ0000000000012346")
                        ||deviceItem.getDeviceNo().equals("NJZJ0000000000012347")){
                    view=initItem1Reshui();
                }else if(deviceItem.getDeviceNo().equals("NJZJ0000000000012348")||deviceItem.getDeviceNo().equals("NJZJ0000000000012349")){
                    view=initItem1Zhengqi();
                }*/
                mPageMap.put(page,view);
                break;
            case Item3:
                view = initItemThree();
                /*if(deviceItem.getDeviceNo().equals("NJZJ0000000000012345")||deviceItem.getDeviceNo().equals("NJZJ0000000000012346")
                        ||deviceItem.getDeviceNo().equals("NJZJ0000000000012347")){
                    view=initItem2Reshui();
                }else if(deviceItem.getDeviceNo().equals("NJZJ0000000000012348")||deviceItem.getDeviceNo().equals("NJZJ0000000000012349")){
                    view=initItem2Zhengqi();
                }*/
//                view=initItem2();
                mPageMap.put(page,view);
                break;
            case Item2:
                initData();
                LayoutInflater inflater3=getLayoutInflater();
                view=inflater3.inflate(R.layout.device_info_3,null);
                RecyclerView recyclerView=view.findViewById(R.id.warn_list);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new HomeAdapter());
                recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
                mPageMap.put(page,view);
                break;
            default:
                break;
        }

       if (view == null) {
            TextView textView = new TextView(this);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            textView.setTextColor(ContextCompat.getColor(this, R.color.red_500));
            textView.setText("这是第 " + (page.getPosition() + 1) + " 个 Item 的内容区");
            view = textView;
            mPageMap.put(page, view);
        }
        return view;
    }
    public enum ContentPage {
        Item1(0),
        Item2(1),
        Item3(2);
        public static final int SIZE = 3;
        private final int position;

        ContentPage(int pos) {
            position = pos;
        }

        public static ContentPage getPage(int position) {
            switch (position) {
                case 0:
                    return Item1;
                case 1:
                    return Item2;
                case 2:
                    return Item3;
                default:
                    return Item1;
            }
        }

        public int getPosition() {
            return position;
        }
    }
    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    DeviceInfoActivity2.this).inflate(R.layout.warn_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.warn_text.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView warn_text;
            ImageView warn_image;

            public MyViewHolder(View view)
            {
                super(view);
                warn_text = (TextView) view.findViewById(R.id.warn_text);
                warn_image=(ImageView)view.findViewById(R.id.warn_image);
            }
        }
    }
    private void  initData(){
        mDatas = new ArrayList<String>();
        HashMap<String,DeviceFieldForUI> map=device_t.getExceptionFiled();
        Iterator iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry=(Map.Entry)iterator.next();
            DeviceFieldForUI deviceFieldForUI=(DeviceFieldForUI) entry.getValue();
            if(deviceFieldForUI.getValue()!=null&&!deviceFieldForUI.getValue().equals("")&&deviceFieldForUI.getValue().equals("1")){
                mDatas.add(deviceFieldForUI.getTitle());
            }
        }

        /*if(deviceItem.getPaiYanWenDuGao()==1){
            mDatas.add(getString(R.string.py_wendu_gao));
        }
        if(deviceItem.getLuShuiWenDuGao()==1){
            mDatas.add(getString(R.string.ls_wendu_gao));
        }
        if(deviceItem.getChuKouWenDuGao()==1){
            mDatas.add(getString(R.string.ck_wendu_gao));
        }
        if(deviceItem.getChaoYa()==1){
            mDatas.add(getString(R.string.chaoya));
        }
        if(deviceItem.getJiXianDiShuiWei()==1){
            mDatas.add(getString(R.string.jixian_di_shuiwei));
        }
        if(deviceItem.getDiShuiWei()==1){
            mDatas.add(getString(R.string.di_shuiwei));
        }
        if(deviceItem.getGaoShuiWei()==1){
            mDatas.add(getString(R.string.gao_shuiwei));
        }
        if(deviceItem.getShuiWeiXinHaoLuoJiCuo()==1){
            mDatas.add(getString(R.string.shuiwei_xh_lj_error));
        }
        if(deviceItem.getLuBiWenDuGao()==1){
            mDatas.add(getString(R.string.lb_wendu_gao));
        }
        if(deviceItem.getFuYaZhengQiWenDuGao()==1){
            mDatas.add(getString(R.string.fy_zhengqi_wendu_gao));
        }
        if(deviceItem.getRanShaoQiGuZhang()==1){
            mDatas.add(getString(R.string.rsh_guzhang));
        }
        if(deviceItem.getRanQiXieLou()==1){
            mDatas.add(getString(R.string.rq_xielou));
        }
        if(deviceItem.getRanQiYaLiDi()==1){
            mDatas.add(getString(R.string.rq_yali_di));
        }
        if(deviceItem.getRanQiYaLiYiChang()==1){
            mDatas.add(getString(R.string.rq_yali_yichang));
        }
        if(deviceItem.getRanQiYaLiGao()==1){
            mDatas.add(getString(R.string.rq_yali_gao));
        }
        if(deviceItem.getJiShuiBianPinQiGuZhang()==1){
            mDatas.add(getString(R.string.gshui_bp_guzhang));
        }
        if(deviceItem.getXunHuanBianPinQiGuZhang()==1){
            mDatas.add(getString(R.string.xh_bp_guzhang));
        }
        if(deviceItem.getYinFengBianPinQiGuZhang()==1){
            mDatas.add(getString(R.string.yf_bp_guzhang));
        }
        if(deviceItem.getGuFengBianPinQiGuZhang()==1){
            mDatas.add(getString(R.string.gf_bp_guzhang));
        }
        if(deviceItem.getEciGuFengBianPinQiGuZhang()==1){
            mDatas.add(getString(R.string.er_gf_bp_guzhang));
        }
        if(deviceItem.getLuPaiBianPinQiGuZhang()==1){
            mDatas.add(getString(R.string.lp_bp_guzhang));
        }
        if(deviceItem.getJiShuiBengGuZhang()==1){
            mDatas.add(getString(R.string.gsb_guzhang));
        }
        if(deviceItem.getXunHuanBengGuZhang()==1){
            mDatas.add(getString(R.string.xhb_guzhang));
        }
        if(deviceItem.getXunHuanXiTongQianYa()==1){
            mDatas.add(getString(R.string.xh_qian_ya));
        }
        if(deviceItem.getDiDianYa()==1){
            mDatas.add(getString(R.string.di_dy));
        }
        if(deviceItem.getGaoDianYa()==1){
            mDatas.add(getString(R.string.gao_dy));
        }
        if(deviceItem.getQueXiang()==1){
            mDatas.add(getString(R.string.que_xiang));
        }
        if(deviceItem.getLouDian()==1){
            mDatas.add(getString(R.string.lou_dian));
        }
        if(deviceItem.getBianSongQiGuoYaBaoHu()==1){
            mDatas.add(getString(R.string.bsq_gy_baohu));
        }
        if(deviceItem.getGuanJianCanShuYiChang()==1){
            mDatas.add(getString(R.string.gj_param_yichang));
        }
        if(deviceItem.getSheDingCanShuYiChang()==1){
            mDatas.add(getString(R.string.sd_param_yichang));
        }
        if(deviceItem.getShiZhongGuZhang()==1){
            mDatas.add(getString(R.string.time_guzhang));
        }
        if(deviceItem.getCunChuQiGuZhang()==1){
            mDatas.add(getString(R.string.czq_guzhang));
        }
        if(deviceItem.getWaiBuLianSuo()==1){
            mDatas.add(getString(R.string.wb_liansuo));
        }
        if(deviceItem.getQueYou()==1){
            mDatas.add(getString(R.string.que_you));
        }
        if(deviceItem.getDiYouWei()==1){
            mDatas.add(getString(R.string.diyouwei));
        }
        if(deviceItem.getBenTiPaiYanWenDuGao()==1){
            mDatas.add(getString(R.string.bentipaiyanwendugao));
        }*/
       /* if(deviceItem.getBenTiPaiYanWenDuError()==1) {
            mDatas.add(getString(R.string.bentipaiyanwenduerror));
        }
        if(deviceItem.getPaiYanWenDuError()==1){
            mDatas.add(getString(R.string.paiyanwenduerror));
        }
        if(deviceItem.getLuShuiWenDuError()==1){
            mDatas.add(getString(R.string.lushuiwenduerror));
        }
        if(deviceItem.getChuKouWenDuError()==1){
            mDatas.add(getString(R.string.chukouwenduerror));
        }
        if(deviceItem.getRuKouWenDuError()==1){
            mDatas.add(getString(R.string.rukouwenduerror));
        }
        if(deviceItem.getJieNengQiChuKouWenDuError()==1){
            mDatas.add(getString(R.string.jienengqichukouwenduerror));
        }
        if(deviceItem.getJieNengQiRuKouWenDuError()==1){
            mDatas.add(getString(R.string.jienengqirukouwenduerror));
        }
        if(deviceItem.getJiShuiWenDuError()==1){
            mDatas.add(getString(R.string.jishuiwenduerror));
        }
        if(deviceItem.getLuTangWenDuError()==1){
            mDatas.add(getString(R.string.lutangwenduerror));
        }
        if(deviceItem.getLuTangChuKouWenDuError()==1){
            mDatas.add(getString(R.string.lutangchukouwenduerror));
        }
        if(deviceItem.getLuBiWenDuError()==1){
            mDatas.add(getString(R.string.lubiwenduerror));
        }
        if(deviceItem.getRanLiaoWenDuError()==1){
            mDatas.add(getString(R.string.ranliaowenduerror));
        }
        if(deviceItem.getKongYuQiChuKouReFengWenDuError()==1){
            mDatas.add(getString(R.string.kongyuqichukourefengwenduerror));
        }
        if(deviceItem.getFuYaZhengQiWenDuError()==1){
            mDatas.add(getString(R.string.fuyazhengqiwenduerror));
        }
        if(deviceItem.getGuoReZhengQiWenDuError()==1){
            mDatas.add(getString(R.string.guorezhengqiwenduerror));
        }
        if(deviceItem.getHuiLu1WenDuError()==1){
            mDatas.add(getString(R.string.huilu1wenduerror));
        }
        if(deviceItem.getHuiLu2WenDuError()==1){
            mDatas.add(getString(R.string.huilu2wenduerror));
        }
        if(deviceItem.getHuiLu3WenDuError()==1){
            mDatas.add(getString(R.string.huilu3wenduerror));
        }
        if(deviceItem.getHuiLu4WenDuError()==1){
            mDatas.add(getString(R.string.huilu4wenduerror));
        }
        if(deviceItem.getHuiLu5WenDuError()==1){
            mDatas.add(getString(R.string.huilu5wenduerror));
        }
        if(deviceItem.getShiWaiWenDuError()==1){
            mDatas.add(getString(R.string.shiwaiwenduerror));
        }
        if(deviceItem.getZhengQiYaLiError()==1){
            mDatas.add(getString(R.string.zhengqiyalierror));
        }
        if(deviceItem.getJiShuiYaLiError()==1){
            mDatas.add(getString(R.string.jishuiyalierror));
        }
        if(deviceItem.getChuKouYaLiError()==1){
            mDatas.add(getString(R.string.chukouyalierror));
        }
        if(deviceItem.getRuKouYaLiError()==1){
            mDatas.add(getString(R.string.rukouyalierror));
        }
        if(deviceItem.getLuTangYaLiError()==1){
            mDatas.add(getString(R.string.lutangyalierror));
        }
        if(deviceItem.getLuTangChuKouYaLiError()==1){
            mDatas.add(getString(R.string.lutangchukouyalierror));
        }
        if(deviceItem.getRanQiYaLiError()==1){
            mDatas.add(getString(R.string.ranqiyalierror));
        }
        if(deviceItem.getYiCiFengYaError()==1){
            mDatas.add(getString(R.string.yicifengyaerror));
        }

        if(deviceItem.getEciFengYaError()==1){
            mDatas.add(getString(R.string.ecifengyaerror));
        }
        if(deviceItem.getShunShiRanLiaoLiangError()==1){
            mDatas.add(getString(R.string.shunshiranliaoliangerror));
        }
        if(deviceItem.getShunShiZhengQiLiuLiangError()==1){
            mDatas.add(getString(R.string.shunshizhengqiliuliangerror));
        }
        if(deviceItem.getShunShiJiShuiLiuLiangError()==1){
            mDatas.add(getString(R.string.shunshijishuiliuliangerror));
        }
        if(deviceItem.getShunShiXunHuanLiuLiangError()==1){
            mDatas.add(getString(R.string.shunshixunhuanliuliangerror));
        }
        if(deviceItem.getShunShiBuShuiLiuLiangError()==1){
            mDatas.add(getString(R.string.shunshibushuiliuliangerror));
        }
        if(deviceItem.getGuoLuYeWeiError()==1){
            mDatas.add(getString(R.string.guoluyeweierror));
        }
        if(deviceItem.getShuiXiangYeWeiError()==1){
            mDatas.add(getString(R.string.shuixiangyeweierror));
        }
        if(deviceItem.getPaiYanYangHanLiangError()==1){
            mDatas.add(getString(R.string.paiyanyanghanliangerror));
        }
        if(deviceItem.getLuPaiSuDuFanKuiError()==1){
            mDatas.add(getString(R.string.lupaisudufankuierror));
        }
        if(deviceItem.getYinFengShuChuFanKuiError()==1){
            mDatas.add(getString(R.string.yinfengshuchufankuierror));
        }
        if(deviceItem.getGuFengShuChuFanKuiError()==1){
            mDatas.add(getString(R.string.gufengshuchufankuierror));
        }
        if(deviceItem.getJiShuiShuChuFanKuiError()==1){
            mDatas.add(getString(R.string.jishuishuchufankuierror));
        }*/




    }

    /**
     * 基本信息 （baseinfo+devicefield）
     * @return
     */
    private View initItemOne2(){
        HashMap<String,DeviceFieldForUI> map_bash=device_t.getBaseDeviceInfo();
        Iterator iterator=map_bash.entrySet().iterator();
        List<DeviceFieldForUI> list_bash=new ArrayList<>();
        while(iterator.hasNext()){
            Map.Entry entry=(Map.Entry)iterator.next();
            DeviceFieldForUI deviceFieldForUI=(DeviceFieldForUI) entry.getValue();
            if(deviceFieldForUI.getValue()!=null&&!deviceFieldForUI.getValue().equals("")&&!deviceFieldForUI.getValue().contains("null")&&deviceFieldForUI.getValue().equals("1")){
                list_bash.add(deviceFieldForUI);
            }
        }

        HashMap<String,DeviceFieldForUI> map_device=device_t.getDeviceFiled();
        Iterator iterator2=map_device.entrySet().iterator();
        while(iterator2.hasNext()){
            Map.Entry entry=(Map.Entry)iterator2.next();
            DeviceFieldForUI deviceFieldForUI=(DeviceFieldForUI) entry.getValue();
            if(deviceFieldForUI.getValue()!=null&&!deviceFieldForUI.getValue().equals("")&&!deviceFieldForUI.getValue().contains("null")&&deviceFieldForUI.getValue().equals("1")){
                list_bash.add(deviceFieldForUI);
            }
        }
      /*  LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.device_info_one,null);*/
//        LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.linear_item1);

        LinearLayout.LayoutParams lp_linearlayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(lp_linearlayout);//设置布局参数
        linearLayout.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局

        LinearLayout.LayoutParams lp_scrollview = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ScrollView scrollView=new ScrollView(this);
        scrollView.setLayoutParams(lp_scrollview);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout1.setPadding(16,16,16,16);
        linearLayout1.setLayoutParams(lp);//设置布局参数
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);// 设置子View的Linearlayout// 为垂直方向布局

        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT,1);
        LinearLayout linearLayout11 = new LinearLayout(this);
        lp1.setMargins(16,0,0,0);
        linearLayout11.setLayoutParams(lp1);//设置布局参数
        linearLayout11.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局
        //定义子View中两个元素的布局
        LinearLayout.LayoutParams vlp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv1 = new TextView(this);
        tv1.setLayoutParams(vlp);//设置TextView的布局
        tv1.setTextSize(14);
        tv1.setText(list_bash.get(0).getTitle());
        linearLayout11.addView(tv1);
        LinearLayout.LayoutParams vlp2 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv2 = new TextView(this);
        vlp2.setMargins(0,8,0,0);
        tv2.setLayoutParams(vlp2);
        tv2.setTextSize(18);
        tv2.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
        tv2.setText(list_bash.get(0).getValue());
        linearLayout11.addView(tv2);
        LinearLayout.LayoutParams lp12 = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT,1);
        LinearLayout linearLayout12 = new LinearLayout(this);
        lp1.setMargins(16,0,0,0);
        linearLayout12.setLayoutParams(lp12);//设置布局参数
        linearLayout12.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局
        LinearLayout.LayoutParams vlp21 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv21 = new TextView(this);
        tv21.setLayoutParams(vlp21);//设置TextView的布局
        tv21.setTextSize(14);
        tv21.setText(list_bash.get(1).getTitle());
        linearLayout12.addView(tv21);
        LinearLayout.LayoutParams vlp22 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv22 = new TextView(this);
        vlp22.setMargins(0,8,0,0);
        tv22.setLayoutParams(vlp22);
        tv22.setTextSize(18);
        tv22.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
        tv22.setText(list_bash.get(1).getValue());
        linearLayout12.addView(tv22);
        linearLayout1.addView(linearLayout11);
        linearLayout1.addView(linearLayout12);
        return linearLayout1;

    }


    /**
     * 基本信息 （baseinfo+devicefield）
     * @return
     */
    private View initItemOne(){
        HashMap<String,DeviceFieldForUI> map_bash=device_t.getBaseDeviceInfo();
        Iterator iterator=map_bash.entrySet().iterator();
        List<DeviceFieldForUI> list_bash=new ArrayList<>();
        while(iterator.hasNext()){
            Map.Entry entry=(Map.Entry)iterator.next();
            DeviceFieldForUI deviceFieldForUI=(DeviceFieldForUI) entry.getValue();
            if(deviceFieldForUI.getValue()!=null&&!deviceFieldForUI.getValue().equals("")&&!deviceFieldForUI.getValue().contains("null")){
                if(deviceFieldForUI.getName().equals(Device_BaseInfo.ba_guolushuiweizhuangtai)){
                    if(NetUtils.isNumeric(deviceFieldForUI.getValue())){
                        int a=Integer.parseInt(deviceFieldForUI.getValue());
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
                        deviceFieldForUI.setValue(sw_status);
                    }

                }else if(deviceFieldForUI.getName().equals(Device_BaseInfo.ba_jiezhileixing)){
                    if(NetUtils.isNumeric(deviceFieldForUI.getValue())){
                        int a=Integer.parseInt(deviceFieldForUI.getValue());
                        String jzh_type="";
                        switch (a){
                            case 0:
                                jzh_type="热水";
                                break;
                            case 1:
                                jzh_type="蒸汽";
                                break;
                            case 2:
                                jzh_type="导热油";
                                break;
                        }
                        deviceFieldForUI.setValue(jzh_type);
                    }
                }else if(deviceFieldForUI.getName().equals(Device_BaseInfo.ba_ranliaoleixing)){
                    if(NetUtils.isNumeric(deviceFieldForUI.getValue())){
                        int a=Integer.parseInt(deviceFieldForUI.getValue());
                        String ranl_type="";
                        switch (a){
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
                        deviceFieldForUI.setValue(ranl_type);
                    }

                }else if(deviceFieldForUI.getName().equals(Device_BaseInfo.ba_shuixiangshuiweizhuangtai)){
                    if(NetUtils.isNumeric(deviceFieldForUI.getValue())){
                        int a=Integer.parseInt(deviceFieldForUI.getValue());
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
                        deviceFieldForUI.setValue(sw_status);
                    }

                }else if(deviceFieldForUI.getName().equals(Device_BaseInfo.ba_guoluyalizhuangtai)){
                    if(NetUtils.isNumeric(deviceFieldForUI.getValue())){
                        int a=Integer.parseInt(deviceFieldForUI.getValue());
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
                        deviceFieldForUI.setValue(sw_status);
                    }

                }else if(deviceFieldForUI.getName().equals(Device_BaseInfo.ba_yunxingzhuangtai)){
                    if(NetUtils.isNumeric(deviceFieldForUI.getValue())){
                        int a=Integer.parseInt(deviceFieldForUI.getValue());
                        String yunx_status="";
                        switch (a){
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
                        deviceFieldForUI.setValue(yunx_status);
                    }

                }
                list_bash.add(deviceFieldForUI);
            }
        }

        HashMap<String,DeviceFieldForUI> map_device=device_t.getDeviceFiled();
        Iterator iterator2=map_device.entrySet().iterator();
        while(iterator2.hasNext()){
            Map.Entry entry=(Map.Entry)iterator2.next();
            DeviceFieldForUI deviceFieldForUI=(DeviceFieldForUI) entry.getValue();
            if(deviceFieldForUI.getValue()!=null&&!deviceFieldForUI.getValue().equals("")&&!deviceFieldForUI.getValue().contains("null")){
                String str=deviceFieldForUI.getValue();
                deviceFieldForUI.setValue(str.replaceAll("\\d+",""));
                list_bash.add(deviceFieldForUI);
            }
        }
      /*  LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.device_info_one,null);*/
//        LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.linear_item1);

        LinearLayout.LayoutParams lp_linearlayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(lp_linearlayout);//设置布局参数
        linearLayout.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局

        LinearLayout.LayoutParams lp_scrollview = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ScrollView scrollView=new ScrollView(this);
        scrollView.setLayoutParams(lp_scrollview);

        LinearLayout.LayoutParams lp_linearlayout0 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout0 = new LinearLayout(this);
        linearLayout0.setLayoutParams(lp_linearlayout0);//设置布局参数
        linearLayout0.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局


        LinearLayout linearLayout1=null;
        int px=NetUtils.dp2px(this,16);
        for(int i=0;i<list_bash.size();i++){
            if(i % 2==0){
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                linearLayout1 = new LinearLayout(this);
                linearLayout1.setLayoutParams(lp);//设置布局参数

                linearLayout1.setPadding(px,px,px,px);
                linearLayout1.setGravity(Gravity.CENTER);
//                linearLayout1.setPadding(16,16,16,16);
                linearLayout1.setOrientation(LinearLayout.HORIZONTAL);// 设置子View的Linearlayout// 为垂直方向布局
                linearLayout1.setDividerDrawable(ContextCompat.getDrawable(this,R.drawable.shape_divider));
                linearLayout1.setShowDividers(LinearLayout.SHOW_DIVIDER_END|LinearLayout.SHOW_DIVIDER_BEGINNING|LinearLayout.SHOW_DIVIDER_MIDDLE);

                LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout linearLayout11 = new LinearLayout(this);
                lp1.setMargins(px,0,0,0);
                linearLayout11.setLayoutParams(lp1);//设置布局参数
                linearLayout11.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局
                //定义子View中两个元素的布局
                LinearLayout.LayoutParams vlp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv1 = new TextView(this);
                tv1.setLayoutParams(vlp);//设置TextView的布局
                tv1.setTextSize(14);
                tv1.setText(list_bash.get(i).getTitle());
                linearLayout11.addView(tv1);
                LinearLayout.LayoutParams vlp2 = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv2 = new TextView(this);
                vlp2.setMargins(0,8,0,0);
                tv2.setLayoutParams(vlp2);
                tv2.setTextSize(18);
                tv2.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                tv2.setText(list_bash.get(i).getValue());
//                tv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                linearLayout11.addView(tv2);
                /*LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 5);
                View view1=new View(this);
                lp_view.setMargins(16,0,0,0);
                view1.setLayoutParams(lp_view);
                view1.setBackgroundColor(ContextCompat.getColor(this,R.color.view_gray_line));
                linearLayout11.addView(view1);*/
                linearLayout1.addView(linearLayout11);
                if(i+1==list_bash.size()){
                    linearLayout0.addView(linearLayout1);
                    LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, 1);
                    View view1=new View(this);
                    lp_view.setMargins(px,0,px,0);
                    view1.setLayoutParams(lp_view);
                    view1.setBackgroundColor(ContextCompat.getColor(this,R.color.gray));
//                    view1.setBackgroundResource(R.color.bar_blue);
                    linearLayout0.addView(view1);
                }

            }else if(i %2 ==1){
                //定义子View中两个元素的布局
                LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout linearLayout12 = new LinearLayout(this);
                lp1.setMargins(px,0,0,0);
                linearLayout12.setLayoutParams(lp1);//设置布局参数
                linearLayout12.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局
                LinearLayout.LayoutParams vlp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv1 = new TextView(this);
                tv1.setLayoutParams(vlp);//设置TextView的布局
                tv1.setTextSize(14);
                tv1.setText(list_bash.get(i).getTitle());
                linearLayout12.addView(tv1);
                LinearLayout.LayoutParams vlp2 = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv2 = new TextView(this);
                vlp2.setMargins(0,8,0,0);
                tv2.setLayoutParams(vlp2);
                tv2.setTextSize(18);
                tv2.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                tv2.setText(list_bash.get(i).getValue());
//                tv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                linearLayout12.addView(tv2);
             /*   LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);
                View view1=new View(this);
                lp_view.setMargins(16,0,0,0);
                view1.setLayoutParams(lp_view);
                view1.setBackgroundColor(ContextCompat.getColor(this,R.color.view_gray_line));
                linearLayout12.addView(view1)*/;
                if(linearLayout1!=null)linearLayout1.addView(linearLayout12);
                linearLayout0.addView(linearLayout1);
                LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);
                View view1=new View(this);
                lp_view.setMargins(px,0,px,0);
                view1.setLayoutParams(lp_view);
                view1.setBackgroundColor(ContextCompat.getColor(this,R.color.gray));
                linearLayout0.addView(view1);
               /* scrollView.addView(linearLayout0);
                linearLayout.addView(scrollView);*/
            }
        }
        scrollView.addView(linearLayout0);
        linearLayout.addView(scrollView);
        return  linearLayout;
    }

    /**
     * 设定参数信息
     * @return
     */
    private View initItemThree(){
        HashMap<String,DeviceFieldForUI> map_set=device_t.getSettingFiled();
        Iterator iterator=map_set.entrySet().iterator();
        List<DeviceFieldForUI> list_set=new ArrayList<>();
        while(iterator.hasNext()){
            Map.Entry entry=(Map.Entry)iterator.next();
            DeviceFieldForUI deviceFieldForUI=(DeviceFieldForUI) entry.getValue();
            if(deviceFieldForUI.getValue()!=null&&!deviceFieldForUI.getValue().equals("")&&!deviceFieldForUI.getValue().contains("null")){
                list_set.add(deviceFieldForUI);
            }
        }
        LinearLayout.LayoutParams lp_linearlayout = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(lp_linearlayout);//设置布局参数
        linearLayout.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局

        LinearLayout.LayoutParams lp_scrollview = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ScrollView scrollView=new ScrollView(this);
        scrollView.setLayoutParams(lp_scrollview);

        LinearLayout.LayoutParams lp_linearlayout0 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout0 = new LinearLayout(this);
        linearLayout0.setLayoutParams(lp_linearlayout0);//设置布局参数
        linearLayout0.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局

        int px=NetUtils.dp2px(this,16);
        LinearLayout linearLayout1=null;
        for(int i=0;i<list_set.size();i++){
            if(i % 2==0){
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                linearLayout1 = new LinearLayout(this);
                linearLayout1.setLayoutParams(lp);//设置布局参数
                linearLayout1.setPadding(px,px,px,px);
                linearLayout1.setOrientation(LinearLayout.HORIZONTAL);// 设置子View的Linearlayout// 为垂直方向布局
                linearLayout1.setDividerDrawable(ContextCompat.getDrawable(this,R.drawable.shape_divider));
                linearLayout1.setShowDividers(LinearLayout.SHOW_DIVIDER_END|LinearLayout.SHOW_DIVIDER_BEGINNING|LinearLayout.SHOW_DIVIDER_MIDDLE);

                LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout linearLayout11 = new LinearLayout(this);
                lp1.setMargins(px,0,0,0);
                linearLayout11.setLayoutParams(lp1);//设置布局参数
                linearLayout11.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局
                //定义子View中两个元素的布局
                LinearLayout.LayoutParams vlp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv1 = new TextView(this);
                tv1.setLayoutParams(vlp);//设置TextView的布局
                tv1.setTextSize(14);
                tv1.setText(list_set.get(i).getTitle());
                linearLayout11.addView(tv1);
                LinearLayout.LayoutParams vlp2 = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv2 = new TextView(this);
                vlp2.setMargins(0,8,0,0);
                tv2.setLayoutParams(vlp2);
                tv2.setTextSize(18);
                tv2.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                tv2.setText(list_set.get(i).getValue());
//                tv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                linearLayout11.addView(tv2);
                /*LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 5);
                View view1=new View(this);
                lp_view.setMargins(16,0,0,0);
                view1.setLayoutParams(lp_view);
                view1.setBackgroundColor(ContextCompat.getColor(this,R.color.view_gray_line));
                linearLayout11.addView(view1);*/
                linearLayout1.addView(linearLayout11);
                if(i+1==list_set.size()){
                    linearLayout0.addView(linearLayout1);
                    LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, 1);
                    View view1=new View(this);
                    lp_view.setMargins(px,0,px,0);
                    view1.setLayoutParams(lp_view);
                    view1.setBackgroundColor(ContextCompat.getColor(this,R.color.gray));
//                    view1.setBackgroundResource(R.color.bar_blue);
                    linearLayout0.addView(view1);
                }

            }else if(i %2 ==1){
                //定义子View中两个元素的布局
                LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.MATCH_PARENT,1);
                LinearLayout linearLayout12 = new LinearLayout(this);
                lp1.setMargins(px,0,0,0);
                linearLayout12.setLayoutParams(lp1);//设置布局参数
                linearLayout12.setOrientation(LinearLayout.VERTICAL);// 设置子View的Linearlayout// 为垂直方向布局
                LinearLayout.LayoutParams vlp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv1 = new TextView(this);
                tv1.setLayoutParams(vlp);//设置TextView的布局
                tv1.setTextSize(14);
                tv1.setText(list_set.get(i).getTitle());
                linearLayout12.addView(tv1);
                LinearLayout.LayoutParams vlp2 = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView tv2 = new TextView(this);
                vlp2.setMargins(0,8,0,0);
                tv2.setLayoutParams(vlp2);
                tv2.setTextSize(18);
                tv2.setTextColor(ContextCompat.getColor(this,R.color.colorPrimary));
                tv2.setText(list_set.get(i).getValue());
//                tv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
                linearLayout12.addView(tv2);
             /*   LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);
                View view1=new View(this);
                lp_view.setMargins(16,0,0,0);
                view1.setLayoutParams(lp_view);
                view1.setBackgroundColor(ContextCompat.getColor(this,R.color.view_gray_line));
                linearLayout12.addView(view1)*/;
                if(linearLayout1!=null)linearLayout1.addView(linearLayout12);
                linearLayout0.addView(linearLayout1);
                LinearLayout.LayoutParams lp_view = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 1);
                View view1=new View(this);
                lp_view.setMargins(px,0,px,0);
                view1.setLayoutParams(lp_view);
                view1.setBackgroundColor(ContextCompat.getColor(this,R.color.gray));
                linearLayout0.addView(view1);
               /* scrollView.addView(linearLayout0);
                linearLayout.addView(scrollView);*/
            }
        }
        scrollView.addView(linearLayout0);
        linearLayout.addView(scrollView);
        return  linearLayout;
    }

    private View initItem1(){
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.device_info_1,null);
        TextView tv_rl_type=(TextView)view.findViewById(R.id.tv_rl_type2);
        TextView tv_jz_type =(TextView)view.findViewById(R.id.tv_jz_type);
        TextView tv_yx_status=(TextView)view.findViewById(R.id.tv_yx_status);
        TextView tv_set_time=(TextView)view.findViewById(R.id.tv_set_time);
//        TextView tv_yx_days=(TextView)view.findViewById(R.id.tv_yx_days);
//        TextView tv_yx_hours=(TextView)view.findViewById(R.id.tv_yx_hours);
        TextView tv_ls_wendu=(TextView)view.findViewById(R.id.tv_ls_wendu);
        TextView tv_js_wendu=(TextView)view.findViewById(R.id.tv_js_wendu);
        TextView tv_zq_yali=(TextView)view.findViewById(R.id.tv_zq_yali);
        TextView tv_focu_text1=(TextView)view.findViewById(R.id.tv_focu_text1);
        TextView tv_focu_text2=(TextView)view.findViewById(R.id.tv_focu_text2);
        TextView tv_focu_text3=(TextView)view.findViewById(R.id.tv_focu_text3);
       /* if(deviceItem.getFocusItem3Text()!=null&&!deviceItem.getFocusItem3Text().equals(""))tv_focu_text3.setText(deviceItem.getFocusItem3Text());
        if(deviceItem.getFocusItem2Text()!=null&&!deviceItem.getFocusItem2Text().equals(""))tv_focu_text2.setText(deviceItem.getFocusItem2Text());
        if(deviceItem.getFocusItem1Text()!=null&&!deviceItem.getFocusItem1Text().equals(""))tv_focu_text1.setText(deviceItem.getFocusItem1Text());
        int rl_type=deviceItem.getPower();
        String ranl_type="";
        switch (rl_type){
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
        tv_rl_type.setText(ranl_type);*/
       /* int jz_type=deviceItem.getMedia();
        String jzh_type="";
        switch (jz_type){
            case 0:
                jzh_type="热水";
                break;
            case 1:
                jzh_type="蒸汽";
                break;
            case 2:
                jzh_type="导热油";
                break;
        }
        tv_jz_type.setText(jzh_type);*/
       /* int yx_status=deviceItem.getRunstatus();
        String yunx_status="";
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
        }*/
//        tv_yx_status.setText(yunx_status);
        /*tv_set_time.setText(SPUtils.DateToString(deviceItem.getComeDate()));
//        tv_yx_days.setText(Integer.toString(deviceItem.getRunDays()));
//        tv_yx_hours.setText(Integer.toString(deviceItem.getRunHours()));
        tv_ls_wendu.setText(Float.toString(deviceItem.getFocusItem1())+"℃");
        tv_js_wendu.setText(Float.toString(deviceItem.getFocusItem2())+"℃");
        tv_zq_yali.setText(Float.toString(deviceItem.getFocusItem3())+"MPa");*/
        return  view;
    }
    private View initItem1Zhengqi(){
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.device_info_12,null);
        TextView tv_zhengqi_yali=(TextView)view.findViewById(R.id.tv_zhengqiyali);
        TextView tv_py_wendu =(TextView)view.findViewById(R.id.tv_paiyan_wendu);
        TextView tv_ranshaoqi_status=(TextView)view.findViewById(R.id.tv_ranshaoqi_status);
        TextView tv_bushuibeng_status=(TextView)view.findViewById(R.id.tv_bushuibeng_status);
        TextView tv_bushuibeng_bei=(TextView)view.findViewById(R.id.tv_bushuibeng_bei_status);
        TextView tv_lengningbeng_status=(TextView)view.findViewById(R.id.tv_lengningbeng_status);
       /* tv_zhengqi_yali.setText(Float.toString(deviceItem.getZhengQiYaLi()));
        tv_py_wendu.setText(Integer.toString(deviceItem.getPaiYanWenDu()));
//        tv_ranshaoqi_status.setText(deviceItem.getRansh);
//        tv_bushuibeng_status.setText(deviceItem.getbushui);
        tv_ranshaoqi_status.setText(deviceItem.getRanShaoQiQiTing()==0 ? "停止" : deviceItem.getRanShaoQiDaHuo()==1 ? "大火" : "小火");
        tv_bushuibeng_status.setText(deviceItem.getJiShuiBengZhu()>0 ? "启动" : "停止");
        tv_bushuibeng_bei.setText(deviceItem.getJiShuiBengBei()>0 ? "启动" : "停止");
        tv_lengningbeng_status.setText(deviceItem.getRanShaoQiQiTing()==0 ? "停止" : "启动");*/
        return  view;
    }
    private View initItem1Reshui(){
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.device_info_11,null);
        TextView tv_chushui_wendu=(TextView)view.findViewById(R.id.chuishui_wend);
        TextView tv_huishui_wendu=(TextView)view.findViewById(R.id.huishui_wend);
        TextView tv_py_wendu=(TextView)view.findViewById(R.id.paiyan_wend);
        TextView tv_shuiwei_status=(TextView)view.findViewById(R.id.shuiwei_status);
        TextView tv_yali_status=(TextView)view.findViewById(R.id.yali_status);
        TextView tv_ranshaoqi_status=(TextView)view.findViewById(R.id.ranshaoqi_status);
        TextView tv_xunhuanbeng_status=(TextView)view.findViewById(R.id.xunhuanbeng_status);
        TextView tv_xunhuanbengbei=(TextView)view.findViewById(R.id.xunhuanbengbei);
        TextView tv_bushuibeng_status=(TextView)view.findViewById(R.id.bushuibeng_status);
        TextView tv_bushuibengbei=(TextView)view.findViewById(R.id.bushuibengbei);

      /*  tv_chushui_wendu.setText(Integer.toString(deviceItem.getChuKouWenDu()));
        tv_huishui_wendu.setText(Integer.toString(deviceItem.getRuKouWenDu()));
        tv_py_wendu.setText(Integer.toString(deviceItem.getPaiYanWenDu()));
        tv_shuiwei_status.setText(deviceItem.getDiShuiWei()==1 ? "低水位" : deviceItem.getGaoShuiWei()==1 ? "高水位" : "正常");
        tv_yali_status.setText("正常");
        tv_ranshaoqi_status.setText(deviceItem.getRanShaoQiQiTing()==0 ? "停止" : deviceItem.getRanShaoQiDaHuo()==1 ? "大火" : "小火");
        tv_xunhuanbeng_status.setText(deviceItem.getXunHuanBeng()>0 ? "启动" : "停止");
        tv_xunhuanbengbei.setText(deviceItem.getXunHuanBengBei()>0 ? "启动" : "停止");
        tv_bushuibeng_status.setText(deviceItem.getJiShuiBengZhu()>0 ? "启动" : "停止");
        tv_bushuibengbei.setText(deviceItem.getJiShuiBengBei()>0 ? "启动" : "停止");*/
//        tv_huishui_wendu.setText(Integer.toString(deviceItem.get));

        return  view;
    }
    /**
     * 蒸汽锅炉
     * @return
     */
    private View initItem2Zhengqi(){
        LayoutInflater inflater2=getLayoutInflater();
        View view=inflater2.inflate(R.layout.device_info_22,null);
        TextView tv_py_bj_wendu =(TextView)view.findViewById(R.id.tv_paiyanbaojingwend);
        TextView tv_chaoya_bj=(TextView)view.findViewById(R.id.tv_chaoya_baojing);
        TextView tv_tl_yali=(TextView)view.findViewById(R.id.tv_tl_yali);
        TextView tv_mb_yali=(TextView)view.findViewById(R.id.tv_mb_yali);
        TextView tv_ql_huicha=(TextView)view.findViewById(R.id.tv_ql_huicha) ;
        TextView tv_qian_yanshi=(TextView)view.findViewById(R.id.tv_qian_yanshi);
        TextView tv_hou_yanshi=(TextView)view.findViewById(R.id.tv_hou_yanshi);

        /*tv_py_bj_wendu.setText(Integer.toString(deviceItem.getPaiYanWenDuSetting()));
        tv_chaoya_bj.setText(Float.toString(deviceItem.getBaoJingYaLiSetting()));
        tv_ql_huicha.setText(Float.toString(deviceItem.getQiLuHuiChaYaLiSetting()));
        tv_tl_yali.setText(Float.toString(deviceItem.getTingLuYaLiSetting()));
        tv_mb_yali.setText(Float.toString(deviceItem.getMuBiaoYaLiSetting()));
        tv_qian_yanshi.setText(Integer.toString(deviceItem.getQianYanShiSetting()));
        tv_hou_yanshi.setText(Integer.toString(deviceItem.getHouYanShiSetting()));*/
        return view;
    }

    /**
     * 热水锅炉
     * @return
     */
   /* private View initItem2Reshui(){
        LayoutInflater inflater2=getLayoutInflater();
        View view=inflater2.inflate(R.layout.device_info_21,null);
        TextView tv_paiyanbaojingwend =(TextView)view.findViewById(R.id.tv_paiyanbaojingwend);
        TextView tv_bj_wendu=(TextView)view.findViewById(R.id.tv_bj_wendu);
        TextView tv_tl_wendu=(TextView)view.findViewById(R.id.tv_tl_wendu);
        TextView tv_mb_wendu=(TextView)view.findViewById(R.id.tv_mb_wendu);
        TextView tv_ql_huicha=(TextView)view.findViewById(R.id.tv_ql_huicha);
        TextView tv_qian_yanshi=(TextView)view.findViewById(R.id.tv_qian_yanshi);
        TextView tv_hou_yanshi=(TextView)view.findViewById(R.id.tv_hou_yanshi);
        tv_paiyanbaojingwend.setText(Integer.toString(deviceItem.getPaiYanWenDuSetting()));
        tv_bj_wendu.setText(Integer.toString(deviceItem.getBaoJingWenDuSetting()));
        tv_tl_wendu.setText(Integer.toString(deviceItem.getTingLuWenDuSetting()));
        tv_mb_wendu.setText(Integer.toString(deviceItem.getMuBiaoWenDuSetting()));
        tv_ql_huicha.setText(Float.toString(deviceItem.getQiLuHuiChaYaLiSetting()));
        tv_qian_yanshi.setText(Integer.toString(deviceItem.getQianYanShiSetting()));
        tv_hou_yanshi.setText(Integer.toString(deviceItem.getHouYanShiSetting()));
        return view;
    }*/
    private View initItem2(){
        LayoutInflater inflater2=getLayoutInflater();
        View view=inflater2.inflate(R.layout.device_info_2,null);
        TextView tv_py_wendu =(TextView)view.findViewById(R.id.tv_py_wendu);
        TextView tv_bj_wendu=(TextView)view.findViewById(R.id.tv_bj_wendu);
        TextView tv_tl_wendu=(TextView)view.findViewById(R.id.tv_tl_wendu);
        TextView tv_mb_wendu=(TextView)view.findViewById(R.id.tv_mb_wendu);
        TextView tv_ql_wendu=(TextView)view.findViewById(R.id.tv_ql_wendu);
        TextView tv_zh_huicha=(TextView)view.findViewById(R.id.tv_zh_huicha);
        TextView tv_ql_huicha=(TextView)view.findViewById(R.id.tv_ql_huicha);
        TextView tv_kb_wendu=(TextView)view.findViewById(R.id.tv_kb_wendu);
        TextView tv_gb_wendu=(TextView)view.findViewById(R.id.tv_gb_wendu);
        TextView tv_bj_yali=(TextView)view.findViewById(R.id.tv_bj_yali);
        TextView tv_tl_yali=(TextView)view.findViewById(R.id.tv_tl_yali);
        TextView tv_mb_yali=(TextView)view.findViewById(R.id.tv_mb_yali);
        TextView tv_ql_yali=(TextView)view.findViewById(R.id.tv_ql_yali);
        TextView tv_zh_huicha_yali=(TextView)view.findViewById(R.id.tv_zh_huicha_yali);
        TextView tv_ql_huicha_yali=(TextView)view.findViewById(R.id.tv_ql_huicha_yali);
        TextView tv_qian_yanshi=(TextView)view.findViewById(R.id.tv_qian_yanshi);
        TextView tv_hou_yanshi=(TextView)view.findViewById(R.id.tv_hou_yanshi);
        TextView tv_qian_chuisao=(TextView)view.findViewById(R.id.tv_qian_chuisao);
        TextView tv_hou_chuisao=(TextView)view.findViewById(R.id.tv_hou_chuisao);
        TextView tv_lb_bj_wendu=(TextView)view.findViewById(R.id.tv_lb_bj_wendu);
        TextView tv_lq_bj_wendu=(TextView)view.findViewById(R.id.tv_lq_bj_wendu);
        TextView tv_bh_wendu=(TextView)view.findViewById(R.id.tv_bh_wendu);
        TextView tv_bt_py_bj_wendu=(TextView)view.findViewById(R.id.tv_bt_py_bj_wendu);
        TextView tv_qd_time1=(TextView)view.findViewById(R.id.tv_qd_time1);
        TextView tv_tz_time1=(TextView)view.findViewById(R.id.tv_tz_time1);
        TextView tv_qd_time2=(TextView)view.findViewById(R.id.tv_qd_time2);
        TextView tv_tz_time2=(TextView)view.findViewById(R.id.tv_tz_time2);
        TextView tv_qd_time3=(TextView)view.findViewById(R.id.tv_qd_time3);
        TextView tv_tz_time3=(TextView)view.findViewById(R.id.tv_tz_time3);
        TextView tv_qd_time4=(TextView)view.findViewById(R.id.tv_qd_time4);
        TextView tv_tz_time4=(TextView)view.findViewById(R.id.tv_tz_time4);
        TextView tv_qd_time5=(TextView)view.findViewById(R.id.tv_qd_time5);
        TextView tv_tz_time5=(TextView)view.findViewById(R.id.tv_tz_time5);
        TextView tv_qd_time6=(TextView)view.findViewById(R.id.tv_qd_time6);
        TextView tv_tz_time6=(TextView)view.findViewById(R.id.tv_tz_time6);
        /*tv_py_wendu.setText(Integer.toString(deviceItem.getPaiYanWenDuSetting()));
        tv_bj_wendu.setText(Integer.toString(deviceItem.getBaoJingWenDuSetting()));
        tv_tl_wendu.setText(Integer.toString(deviceItem.getTingLuWenDuSetting()));
        tv_mb_wendu.setText(Integer.toString(deviceItem.getMuBiaoWenDuSetting()));
        tv_ql_wendu.setText(Integer.toString(deviceItem.getQiLuWenDuSetting()));
        tv_zh_huicha.setText(Integer.toString(deviceItem.getZhuanHuoHuiChaSetting()));
        tv_ql_huicha.setText(Integer.toString(deviceItem.getQiLuHuiChaSetting()));
        tv_kb_wendu.setText(Integer.toString(deviceItem.getKaiBengWenDuSetting()));
        tv_gb_wendu.setText(Integer.toString(deviceItem.getGuanBengWenDuSetting()));
        tv_bj_yali.setText(Float.toString(deviceItem.getBaoJingYaLiSetting()));
        tv_tl_yali.setText(Float.toString(deviceItem.getTingLuYaLiSetting()));
        tv_mb_yali.setText(Float.toString(deviceItem.getMuBiaoYaLiSetting()));
        tv_ql_yali.setText(Float.toString(deviceItem.getQiLuYaLiSetting()));
        tv_zh_huicha_yali.setText(Float.toString(deviceItem.getZhuanHuoHuiChaYaLiSetting()));
        tv_ql_huicha_yali.setText(Float.toString(deviceItem.getQiLuHuiChaYaLiSetting()));
        tv_qian_yanshi.setText(Integer.toString(deviceItem.getQianYanShiSetting()));
        tv_hou_yanshi.setText(Integer.toString(deviceItem.getHouYanShiSetting()));
        tv_qian_chuisao.setText(Integer.toString(deviceItem.getQianChuiSaoSetting()));
        tv_hou_chuisao.setText(Integer.toString(deviceItem.getHouChuiSaoSetting()));
        tv_lb_bj_wendu.setText(Integer.toString(deviceItem.getLuBiBaoJingWenDuSetting()));
        tv_lq_bj_wendu.setText(Integer.toString(deviceItem.getLuTangChuKouBaoJingWenDuSetting()));
        tv_bh_wendu.setText(Integer.toString(deviceItem.getBaoHuWenDuSetting()));
        tv_bt_py_bj_wendu.setText(Integer.toString(deviceItem.getBenTiPaiYanWenDuBaoJingZhiSetting()));
        tv_qd_time1.setText(Integer.toString(deviceItem.getQiDongShiJian1Setting()));
        tv_tz_time1.setText(Integer.toString(deviceItem.getTingZhiShiJian1Setting()));
        tv_qd_time2.setText(Integer.toString(deviceItem.getQiDongShiJian2Setting()));
        tv_tz_time2.setText(Integer.toString(deviceItem.getTingZhiShiJian2Setting()));
        tv_qd_time3.setText(Integer.toString(deviceItem.getQiDongShiJian3Setting()));
        tv_tz_time3.setText(Integer.toString(deviceItem.getTingZhiShiJian3Setting()));
        tv_qd_time4.setText(Integer.toString(deviceItem.getQiDongShiJian4Setting()));
        tv_tz_time4.setText(Integer.toString(deviceItem.getTingZhiShiJian4Setting()));
        tv_qd_time5.setText(Integer.toString(deviceItem.getQiDongShiJian5Setting()));
        tv_tz_time5.setText(Integer.toString(deviceItem.getTingZhiShiJian5Setting()));
        tv_qd_time6.setText(Integer.toString(deviceItem.getQiDongShiJian6Setting()));
        tv_tz_time6.setText(Integer.toString(deviceItem.getTingZhiShiJian6Setting()));*/
        return view;
    }

    @Override
    protected void onPause() {
        super.onPause();
        DevClient devClient= DevClient.getInstance(getApplicationContext());
        devClient.stopSendMessageThread();
    }
}
