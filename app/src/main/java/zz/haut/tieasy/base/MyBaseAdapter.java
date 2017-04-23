package zz.haut.tieasy.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author 亲
 * @date 2017/3/16.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    /** 子类需要使用这个属性，获取数据 */
    public List<T> list;
    private Context context;
    private int selectIndex;

    public MyBaseAdapter(List<T> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public MyBaseAdapter(List<T> list, Context context, int selectIndex) {
        this.list = list;
        this.context = context;
        this.selectIndex = selectIndex;
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(int selectItem) {
        this.selectIndex = selectItem;
    }

    @Override
    public int getCount() {
        if(list == null){
            return 0;
        }else{
            return list.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
