package com.weytenera.xsq.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.weytenera.xsq.R;

import butterknife.ButterKnife;

/**
 * 基类Activity
 * <p/>
 * <br/> Description: 所有的Activity都继承自此Activity，并实现基类模板方法
 * <br/> Author:ccs
 * <br/> Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ButterKnife.bind(this);
        widgetListener();
        init();



    }


    /**
     * 获取显示view的xml文件ID
     * <p/>
     * 在Activity的 {@link #onCreate(Bundle)}里边被调用

     * @return xml文件ID
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


}
