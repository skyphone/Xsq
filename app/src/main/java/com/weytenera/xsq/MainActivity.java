package com.weytenera.xsq;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.Toast;

import com.weytenera.xsq.base.BaseActivity;
import com.weytenera.xsq.fragment.HomeFragment;

public class MainActivity extends BaseActivity {
    Fragment mContent;
    HomeFragment homeFragment;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_ma;
    }

    @Override
    protected void init() {
        getSupportActionBar().hide();
        mContent = new Fragment();
        homeFragment = new HomeFragment();
        switchContent(mContent, homeFragment);
    }

    @Override
    protected void widgetListener() {

    }


    public void switchContent(Fragment from, Fragment to) {
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(from).add(R.id.lin_main, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }


    // 退出程序 private static long currenttime;
    long waitTime = 2000;
    long touchTime = 0;

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();// 退出功能
        if ((currentTime - touchTime) >= waitTime) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            touchTime = currentTime;
        } else {
//            MyApplication.userInfo.isLoaded=false;
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
        }

    }

}
