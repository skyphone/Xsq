package com.weytenera.xsq.fragment;

import android.widget.GridView;
import android.widget.LinearLayout;

import com.weytenera.xsq.R;
import com.weytenera.xsq.adapter.TypeAdapter;
import com.weytenera.xsq.base.BaseFragment;
import com.weytenera.xsq.beans.Type;
import com.weytenera.xsq.views.AdViewpage;

import java.util.ArrayList;

import butterknife.Bind;

/**
  * <br/> Description: 
  * <br/> Author:  chencaisheng
  * <br/> Version: 1.0
  * <br/> Date:  2016/9/27 0027 上午 9:47
  */

public class HomeFragment extends BaseFragment {

     private AdViewpage adViewpage;//轮播

    @Bind(R.id.rel_main)
    LinearLayout relMain;

    @Bind(R.id.grid_type)
    GridView gridType;


    @Override
    protected int getContentViewId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init() {
        adViewpage=new AdViewpage(getActivity());
        relMain.addView(adViewpage);
        initGridviewType();
    }

    @Override
    protected void widgetListener() {

    }



    private void initGridviewType(){
        String[] infos={"资讯","活动","公告","优品","供需","服务","企向","商链"};
        ArrayList<Type> types=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Type t=new Type();
            t.info=infos[i];
            if(i%2==0){
                t.drawable=R.drawable.icon_typeone;
            }else{
                t.drawable=R.drawable.icon_typetwo;
            }
            types.add(t);
        }

        TypeAdapter adaper=new TypeAdapter(types,getActivity());
        gridType.setAdapter(adaper);

    }





}
