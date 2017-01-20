package com.cly.mytoollibrary;


import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by 丛龙宇 on 17-1-20.
 */

public class ActivityUtils {

    /**
     * 展示Fragment
     *
     * @param fragmentManager
     * @param t
     * @param resId
     * @param <T>
     */
    public static <T extends android.app.Fragment> void addFragmentToActivity(android.app.FragmentManager fragmentManager, T t, int resId) {
        android.app.Fragment fragment = fragmentManager.findFragmentByTag(t.getClass().getSimpleName());
        if (fragment == null) {
            try {
                fragment = t.getClass().newInstance();
                if (resId != -1)
                    fragmentManager.beginTransaction().add(fragment, t.getClass().getSimpleName()).commitAllowingStateLoss();
                else
                    fragmentManager.beginTransaction().add(resId, fragment, t.getClass().getSimpleName()).commitAllowingStateLoss();
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            fragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss();
        }
    }

    /**
     * 展示Fragment
     *
     * @param fragmentManager
     * @param t
     * @param <T>
     */
    public static <T extends android.app.Fragment> void addFragmentToActivity(android.app.FragmentManager fragmentManager, T t) {
        addFragmentToActivity(fragmentManager, t, -1);
    }

    /**
     * 展示v4 Fragment
     *
     * @param fragmentManager
     * @param t
     * @param resId
     * @param <T>
     */
    public static <T extends android.support.v4.app.Fragment> void addFragmentToActivity(android.support.v4.app.FragmentManager fragmentManager, T t, int resId) {
        android.support.v4.app.Fragment fragment = fragmentManager.findFragmentByTag(t.getClass().getSimpleName());
        if (fragment == null) {
            try {
                fragment = t.getClass().newInstance();
                if (resId != -1)
                    fragmentManager.beginTransaction().add(fragment, t.getClass().getSimpleName()).commitAllowingStateLoss();
                else
                    fragmentManager.beginTransaction().add(resId, fragment, t.getClass().getSimpleName()).commitAllowingStateLoss();
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            fragmentManager.beginTransaction().show(fragment).commitAllowingStateLoss();
        }
    }

    /**
     * 展示v4 Fragment
     *
     * @param fragmentManager
     * @param t
     * @param <T>
     */
    public static <T extends android.support.v4.app.Fragment> void addFragmentToActivity(android.support.v4.app.FragmentManager fragmentManager, T t) {
        addFragmentToActivity(fragmentManager, t, -1);
    }

    /**
     * 关闭软键盘
     * @param activity
     */
    public static void closeKeyBoard(Activity activity) {
        if (activity.getCurrentFocus() != null) {
            ((InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus()
                                    .getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
