package com.longcai.conveniencenet.contracts;

import com.longcai.conveniencenet.BasePresenter;
import com.longcai.conveniencenet.BaseView;

/**
 * Created by 丛龙宇 on 17-1-20.
 */

public interface IndexContracts {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        //启动定位
        void startLocation();

        //定位成功
        <T> void locationSuccess(T t);

        //定位失败
        void locationFailed(String msg);

        //

    }

}
