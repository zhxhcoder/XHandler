package com.zhxh.xhandler;

import android.content.Context;

/**
 * Created by zhxh on 2018/4/19.
 */

public class AppManager {

    // 有内存泄漏的问题：
    // private static AppManager instance;
    // private Context context;
    // private AppManager(Context context) {
    //     this.context = context;
    // }
    // public static AppManager getInstance(Context context) {
    //     if (instance == null) {
    //         instance = new AppManager(context);
    //     }
    //     return instance;
    // }
    //修复内存泄漏的写法：
    private static AppManager instance;
    private Context context;

    private AppManager(Context context) {
        this.context = context.getApplicationContext();// 使用Application 的context
    }

    public static AppManager getInstance(Context context) {
        if (instance == null) {
            instance = new AppManager(context);
        }
        return instance;
    }
}
