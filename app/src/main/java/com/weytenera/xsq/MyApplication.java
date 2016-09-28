package com.weytenera.xsq;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //http://fresco-cn.org/docs/using-drawees-xml.html
        Fresco.initialize(this);
        //异常处理
//        CrashHandler crashHandler=CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());
    }
}
