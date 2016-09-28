package com.weytenera.xsq.views;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.weytenera.xsq.R;
import com.weytenera.xsq.base.BaseView;

import java.util.ArrayList;

/**
 * <br/> Description: 广告轮播图
 * <br/> Author:  chencaisheng
 * <br/> Version: 1.0
 * <br/> Date:  2016/9/27 0027 下午 4:09
 */
public class AdViewpage extends BaseView {

    //头部广告start
    private ViewPager viewpager;
    private ArrayList<View> list;
    private ArrayList<RadioButton> radioButtons;//下标
    private RadioGroup radioGroup;
    private int currentItem;//当前图片
    public static final int TIME=2000;
    private Handler handler;
    private Runnable runnable;
    //头部广告end

    public AdViewpage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public AdViewpage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdViewpage(Context context) {
        super(context);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.ad_viewpage;
    }

    @Override
    protected void findViews() {
        viewpager= (ViewPager) view_Parent.findViewById(R.id.viewpager);
        radioGroup= (RadioGroup) view_Parent.findViewById(R.id.radioGroup);

    }

    @Override
    protected void widgetListener() {
        //添加手动滑动viewpager
        viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN|MotionEvent.ACTION_MOVE: //停止轮播
                        handler.removeCallbacks(runnable);
                        break;

                    case MotionEvent.ACTION_UP://继续轮播
                        handler.postDelayed(runnable, TIME);
                        break;
                }
                return false;
            }
        });
        //记住手动滑动的位置,并设置当前的下标
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentItem=position;
                radioButtons.get(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void init() {
        handler=new Handler();
        list=new ArrayList<>();
        runnable=new Runnable() {
            @Override
            public void run() {
                if(currentItem==list.size()){
                    currentItem=0;
                }
                viewpager.setCurrentItem(currentItem,false);
                currentItem++;
                handler.postDelayed(runnable,TIME);//间隔轮播
            }
        };

        radioButtons = new ArrayList<>();//下标
        int resources[]={R.drawable.banone,R.drawable.bantwo };
        //数据
        for (int i = 0; i < 2; i++) {
            Button button=new Button(context);
            button.setBackgroundResource(resources[i]);
            button.setOnClickListener(new View.OnClickListener() {//各个轮播图跳转
                @Override
                public void onClick(View v) {
//                    Toast.makeText(getActivity(), "" + currentItem, Toast.LENGTH_SHORT).show();
                }
            });
            list.add(button);

            //下标
            RadioButton rd = new RadioButton(context);
            RadioGroup.LayoutParams params_rb = new RadioGroup.LayoutParams(80, 80);
            params_rb.setMargins(10,0,10,0);
            rd.setLayoutParams(params_rb);
            radioButtons.add(rd);
            radioGroup.addView(rd);
            radioButtons.get(0).setChecked(true);
        }
        MyPagerAdapter adapter=new MyPagerAdapter(list);
        viewpager.setAdapter(adapter);
        handler.postDelayed(runnable, TIME);


    }



    //设配器
    class MyPagerAdapter extends PagerAdapter {

        private ArrayList<View> list;
        public MyPagerAdapter(ArrayList<View> list2){
            list=list2;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=list.get(position);
            container.addView(view);
            return view;
        }
    }
}
