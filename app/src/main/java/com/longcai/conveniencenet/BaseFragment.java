package com.longcai.conveniencenet;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longcai.conveniencenet.interfaces.FragmentBehavior;

/**
 * Created by 丛龙宇 on 17-1-20.
 */

public abstract class BaseFragment extends Fragment implements FragmentBehavior, View.OnClickListener {

    private boolean isDebug;
    private String APP_NAME;
    protected final String TAG = this.getClass().getSimpleName();
    private View mContextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $Log(TAG + "--> onCreate");
        isDebug = BaseApplication.isDebug;
        APP_NAME = BaseApplication.APP_NAME;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContextView = inflater.inflate(bindLayout(), container, false);
        initView(mContextView);
        doBusiness(getActivity());
        return mContextView;
    }

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }


    /**
     * [日志输出]
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(APP_NAME, msg);
        }
    }

    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }


}
