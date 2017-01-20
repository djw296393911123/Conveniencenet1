package com.longcai.conveniencenet;

import android.app.Application;

import com.zcx.helper.app.AppInit;

/**
 * Created by 丛龙宇 on 17-1-20.
 */
@AppInit(name = "ConvenienceNet", log = false, initialize = false, width = 720, scale = 1f)

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
