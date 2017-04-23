package zz.haut.tieasy.home.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.haut.tieasy.R;
import zz.haut.tieasy.base.BaseActivity;
import zz.haut.tieasy.home.fragment.classify.ClassifyContract;
import zz.haut.tieasy.home.fragment.classify.ClassifyFragment;
import zz.haut.tieasy.home.fragment.classify.ClassifyPresenter;
import zz.haut.tieasy.home.fragment.group.GroupContract;
import zz.haut.tieasy.home.fragment.group.GroupFragment;
import zz.haut.tieasy.home.fragment.group.GroupPresenter;
import zz.haut.tieasy.home.fragment.home.HomeContract;
import zz.haut.tieasy.home.fragment.home.HomeFragment;
import zz.haut.tieasy.home.fragment.home.HomePresenter;
import zz.haut.tieasy.home.fragment.my.MyContract;
import zz.haut.tieasy.home.fragment.my.MyFragment;
import zz.haut.tieasy.home.fragment.my.MyPresenter;

/**
 * RadioGroup + Viewpager
 * viewpager填充适配器
 * PagerAdapter ——自定义pager
 * <p>
 * 依赖注入_Butterknife
 */
@RequiresApi(api = Build.VERSION_CODES.M)
public class HomeActivity extends BaseActivity {

    private static final String TAG = "HomeActivity";
    @BindView(R.id.mIVTitleSearch)
    ImageView mIVTitleSearch;
    @BindView(R.id.mETTitleSearch)
    EditText mETTitleSearch;
    @BindView(R.id.mIVAdd)
    ImageView mIVAdd;
    @BindView(R.id.contentFrame)
    FrameLayout contentFrame;
    @BindView(R.id.mIVHome)
    ImageView mIVHome;
    @BindView(R.id.mTVHome)
    TextView mTVHome;
    @BindView(R.id.mLLHome)
    AutoLinearLayout mLLHome;
    @BindView(R.id.mIVClassify)
    ImageView mIVClassify;
    @BindView(R.id.mTVClassify)
    TextView mTVClassify;
    @BindView(R.id.mLLClassify)
    AutoLinearLayout mLLClassify;
    @BindView(R.id.mIVGroup)
    ImageView mIVGroup;
    @BindView(R.id.mTVGroup)
    TextView mTVGroup;
    @BindView(R.id.mLLGroup)
    AutoLinearLayout mLLGroup;
    @BindView(R.id.mIVMy)
    ImageView mIVMy;
    @BindView(R.id.mTVMy)
    TextView mTVMy;
    @BindView(R.id.mLLMy)
    AutoLinearLayout mLLMy;
    @BindView(R.id.mLLImageGroup)
    AutoLinearLayout mLLImageGroup;

    @BindView(R.id.glide)
    ImageView glide;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;

    @BindView(R.id.mainLayout)
    AutoLinearLayout mainLayout;


    public void initData() {



    }

    public void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainLayout.setPadding(0,getStatusHeight(context), 0, getBottomStatusHeight(context));

        //设置刷新时动画的颜色，可以设置4个
        srl.setProgressBackgroundColorSchemeResource(android.R.color.white);
        srl.setColorSchemeResources(android.R.color.holo_blue_light
                ,android.R.color.holo_red_light
                ,android.R.color.holo_orange_light
                ,android.R.color.holo_green_light);
        srl.setProgressViewOffset(false
                , 0
                , (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24
                , getResources().getDisplayMetrics()));

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        //默认切换
        onViewClicked(mLLHome);
    }

    @OnClick({R.id.mIVAdd, R.id.mLLHome, R.id.mLLClassify, R.id.mLLGroup, R.id.mLLMy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mIVAdd:
                showImage();
                break;
            case R.id.mLLHome:
                setColor(mLLHome);
                HomeContract.Presenter mHomePresenter;
                HomeFragment homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, homeFragment).commit();
                mHomePresenter = new HomePresenter(homeFragment);
                break;
            case R.id.mLLClassify:
                setColor(mLLClassify);
                mIVClassify.setClickable(true);
                ClassifyContract.Presenter mClassifyPresenter;
                ClassifyFragment classifyFragment = new ClassifyFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, classifyFragment).commit();
                mClassifyPresenter = new ClassifyPresenter(classifyFragment);
                break;
            case R.id.mLLGroup:
                setColor(mLLGroup);
                mIVGroup.setClickable(true);
                GroupContract.Presenter mGroupPresenter;
                GroupFragment groupFragment = new GroupFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, groupFragment).commit();
                mGroupPresenter = new GroupPresenter(groupFragment);
                break;
            case R.id.mLLMy:
                setColor(mLLMy);
                mIVMy.setClickable(true);
                MyContract.Presenter mMyPresenter;
                MyFragment myFragment = new MyFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFrame, myFragment).commit();
                mMyPresenter = new MyPresenter(myFragment);
                break;
        }
    }

    private void showImage() {
        Glide.with(context).load("http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg").into(glide);
    }


    private void setColor(View view) {
        mIVHome.setImageResource(R.mipmap.pager_home);
        mIVClassify.setImageResource(R.mipmap.pager_classify);
        mIVGroup.setImageResource(R.mipmap.pager_group);
        mIVMy.setImageResource(R.mipmap.pager_my);
        mTVHome.setTextColor(getResources().getColor(R.color.colorFoucs, null));
        mTVClassify.setTextColor(getResources().getColor(R.color.colorFoucs, null));
        mTVGroup.setTextColor(getResources().getColor(R.color.colorFoucs, null));
        mTVMy.setTextColor(getResources().getColor(R.color.colorFoucs, null));
        switch (view.getId()) {
            case R.id.mLLHome:
                mIVHome.setImageResource(R.mipmap.pager_home_select);
                mTVHome.setTextColor(getResources().getColor(R.color.colorFoucsSelect, null));
                break;
            case R.id.mLLClassify:
                mIVClassify.setImageResource(R.mipmap.pager_classify_select);
                mTVClassify.setTextColor(getResources().getColor(R.color.colorFoucsSelect, null));
                break;
            case R.id.mLLGroup:
                mIVGroup.setImageResource(R.mipmap.pager_group_select);
                mTVGroup.setTextColor(getResources().getColor(R.color.colorFoucsSelect, null));
                break;
            case R.id.mLLMy:
                mIVMy.setImageResource(R.mipmap.pager_my_select);
                mTVMy.setTextColor(getResources().getColor(R.color.colorFoucsSelect, null));
                break;
        }
    }
}
