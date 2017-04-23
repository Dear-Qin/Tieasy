package zz.haut.tieasy.base;

import android.content.Context;
import android.view.View;

/**
 * Created by 亲 on 2017/1/5.
 * 自定义pager
 * initView和initData在哪里调用？
 *
 *      啥时候显示自定义pager，那就啥时候，调用initView和initData
 *       HomeActivity - Viewpager的适配器的instantiateItem
 */

public abstract class BasePager {

    public Context context;
    public BasePager(Context context){
        this.context = context;
    }

    /**
     * 初始化View
     * @return 将初始化的view返回 — viewpager内部需要用
     */
    public abstract View initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 发起网络请求
     * @param url
     * @param 根据用到的开源框架添加参数
     */
    public void sendRequest(String url,String other){

    }

}
