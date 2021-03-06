package com.cly.mytoollibrary.simpletools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 丛龙宇 on 17-1-20.
 */

public class SPUtils {

    private static String APP_NAME;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor edit;


    public static void init(Context context, String appName) {
        APP_NAME = appName;
        sharedPreferences = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();
    }

    public static void putString(String key, String value) {
        edit.putString(key, value);
        edit.commit();
    }

    public static String getString(String key, String mDefault) {
        return sharedPreferences.getString(key, mDefault);
    }

    public static void putInt(String key, int value) {
        edit.putInt(key, value);
        edit.commit();
    }

    public static int getInt(String key, int mDefault) {
        return sharedPreferences.getInt(key, mDefault);
    }

    public static void putBoolean(String key, boolean value) {
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static boolean getBoolean(String key, boolean mDefault) {
        return sharedPreferences.getBoolean(key, mDefault);
    }


}
