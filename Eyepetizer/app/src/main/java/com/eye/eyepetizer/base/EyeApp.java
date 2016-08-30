package com.eye.eyepetizer.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/8/30.
 */
public class EyeApp extends Application {
    protected static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
    //对外提供个方法，让别的类获取自己的context
    public static Context getContext() {
        return context;
    }
}
