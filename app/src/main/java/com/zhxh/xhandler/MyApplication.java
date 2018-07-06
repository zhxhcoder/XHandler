package com.zhxh.xhandler;

import android.app.Application;

/**
 * Created by zhxh on 2018/4/19.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }
}
