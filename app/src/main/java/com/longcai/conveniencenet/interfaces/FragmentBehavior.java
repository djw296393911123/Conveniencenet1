package com.longcai.conveniencenet.interfaces;

import android.content.Context;
import android.view.View;

/**
 * Created by 丛龙宇 on 17-1-20.
 */

public interface FragmentBehavior {


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

    /** View点击 **/
    public abstract void widgetClick(View v);


}
