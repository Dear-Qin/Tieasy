package zz.haut.tieasy.home.fragment.classify;

import android.view.View;

import zz.haut.tieasy.R;
import zz.haut.tieasy.base.BaseFragment;

/**
 * Created by 亲 on 2017/1/5.
 * 分类界面自定义pager
 */

public class ClassifyFragment extends BaseFragment implements ClassifyContract.View {


    public ClassifyFragment() {
    }



    public View initView() {
        View view = View.inflate(context, R.layout.frag_home,null);
        return view;
    }

    public void initData() {
        //设置适配器

        //绑定

        //1.获取本地缓存

        //2.如果有本地缓存，解析展示

        //3.请求网络新数据（暂无）

        
    }

    @Override
    public void setPresenter(ClassifyContract.Presenter presenter) {

    }
}
