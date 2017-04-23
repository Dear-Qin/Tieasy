package zz.haut.tieasy.home.fragment.home;

import android.content.Context;
import android.view.View;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zz.haut.tieasy.R;
import zz.haut.tieasy.base.BaseFragment;
import zz.haut.tieasy.util.GlideImageLoder;

/**
 * Created by 亲 on 2017/1/5.
 * 首页界面自定义pager
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {

    Context context = getContext();
    @BindView(R.id.banner)
    Banner banner;
    private View root;
    private List images;
    private List titles;

    @Override
    public void initData() {
        images = new ArrayList();
        images.add("http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg");
        images.add("http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg");
        images.add("http://pic18.nipic.com/20111215/577405_080531548148_2.jpg");
        images.add("http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg");
        images.add("http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg");

        titles = new ArrayList();
        titles.add("女神一号");
        titles.add("女神二号");
        titles.add("女神三号");
        titles.add("女神四号");
        titles.add("女神五号");
        //设置适配器

        //绑定

        //1.获取本地缓存

        //2.如果有本地缓存，解析展示

        //3.请求网络新数据（暂无）


    }

    @Override
    public View initView() {
        root = View.inflate(getContext(), R.layout.frag_home, null);
        ButterKnife.bind(this, root);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoder());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        return root;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
