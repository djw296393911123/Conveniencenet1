package com.longcai.conveniencenet;

import android.app.Application;

import com.zcx.helper.app.AppInit;

/**
 * Created by 丛龙宇 on 17-1-20.
 */
@AppInit(name = "ConvenienceNet", log = false, initialize = false, width = 720, scale = 1f)

public class BaseApplication extends Application {

    //是否开启调试模式
    public static final boolean isDebug = false;
    //应用名称
    public static final String APP_NAME = "ConvenienceNet";



    @Override
    public void onCreate() {
        super.onCreate();
    }
}
