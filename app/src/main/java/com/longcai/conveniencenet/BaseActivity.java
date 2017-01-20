package com.longcai.conveniencenet;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.cly.mytoollibrary.ActivityUtils;

/**
 * Created by 丛龙宇 on 17-1-20.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    //APP名称
    protected String APP_NAME = BaseApplication.APP_NAME;
    //是否调试
    protected boolean isDebug = BaseApplication.isDebug;
    //Log的标记
    protected final String TAG = this.getClass().getSimpleName();
    // 是否禁止旋转屏幕
    private boolean isAllowScreenRoate = false;
    // 当前Activity渲染的视图View
    private View mContextView = null;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        $Log(TAG + "--> onCreate");


        try {
            Bundle bundle = getIntent().getExtras();
            initParms(bundle);
            mContextView = LayoutInflater.from(this)
                    .inflate(bindLayout(), null);
//            if (mAllowFullScreen) {
//                this.getWindow().setFlags(
//                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                requestWindowFeature(Window.FEATURE_NO_TITLE);
//            }
//            if (isSetStatusBar) {
//                steepStatusBar();
//            }
            setContentView(mContextView);
            if (!isAllowScreenRoate) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
            initView(mContextView);
            doBusiness(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        $Log(TAG + "--> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ActivityUtils.closeKeyBoard(this);
        $Log(TAG + "--> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        $Log(TAG + "--> onDestory");
    }

    /* [初始化Bundle参数]
                *
                * @param parms
        */
    public abstract void initParms(Bundle parms);

    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();


    /**
     * [初始化控件]
     *
     * @param view
     */
    public abstract void initView(final View view);

    /**
     * [业务操作]
     *
     * @param mContext
     */
    public abstract void doBusiness(Context mContext);

    /**
     * View点击
     **/
    public abstract void widgetClick(View v);


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

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }

}
