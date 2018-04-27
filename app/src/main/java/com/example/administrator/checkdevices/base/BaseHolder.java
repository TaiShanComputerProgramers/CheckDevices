package com.example.administrator.checkdevices.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;

/**
 * Created by wd on 2018/1/25.
 *
 * @author wd
 * @date 2018/1/25
 * @describe TODO
 * @package com.example.administrator.checkdevices.base
 */

public class BaseHolder extends RecyclerView.ViewHolder {
    private HashMap<Integer,View> mViews=new HashMap<>();
    public BaseHolder(View itemView){
        super(itemView);
    }
    /**
     * 获取控件方法
     */
    public<T> T getView(Integer viewId){
        View view=mViews.get(viewId);
        if(view==null){
            view=itemView.findViewById(viewId);
            //缓存
            mViews.put(viewId,view);
        }
        return (T)view;
    }
    /**
     * 传入图片控件id
     */
    public BaseHolder setImageResource(Integer viewId, Integer resId) {
        ImageView imageView = getView(viewId);
        if (imageView != null) {
            imageView.setImageResource(resId);
        }
        return this;
    }
}
