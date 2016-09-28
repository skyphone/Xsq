package com.weytenera.xsq.base;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 基类Activity
 * <p/>
 * <br/> Description: 所有的Activity都继承自此Activity，并实现基类模板方法
 * <br/> Author:ccs
 * <br/> Version: 1.0
 */
public abstract class BaseFragment extends Fragment {

    /** 父视图 */
    protected View view_Parent;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view_Parent != null) {
            ViewGroup parent = (ViewGroup) view_Parent.getParent();
            if (parent != null)
                parent.removeView(view_Parent);
        }else{
            view_Parent=inflater.inflate(getContentViewId(),container,false);
            ButterKnife.bind(this,view_Parent);
            widgetListener();
            init();
        }

        return view_Parent;
    }

    /**
     * 获取view
     *
     *  <br/> Version: 1.0
     demo
     protected View getViews() {
     view_Parent = View.inflate(getActivity(), R.layout.view_select_record, null);
     return view_Parent;
     }
     */
    protected abstract int getContentViewId();


    /**
     * 初始化应用程序，设置一些初始化数据都获取数据等操作
     * <p/>
     * 在{@link #widgetListener()}之后被调用

     */
    protected abstract void init();


    /**
     * 组件监听模块
     * <p/>
     * 在{@link #findViews()}后被调用
     * <p/>
     */
    protected abstract void widgetListener();


    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
