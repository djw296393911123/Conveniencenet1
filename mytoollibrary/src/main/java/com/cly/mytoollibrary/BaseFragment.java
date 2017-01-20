package com.cly.mytoollibrary;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cly.mytoollibrary.interfaces.FragmentSetDatas;

/**
 * Created by 丛龙宇 on 17-1-20.
 */

public class BaseFragment extends Fragment {

    private static final String FRAGMENT_KEY = "FRAGMENT_KEY";


    public static <T extends FragmentSetDatas> BaseFragment newInstance(T t) {

        Bundle args = new Bundle();
        args.putParcelable(FRAGMENT_KEY, t);
        BaseFragment fragment = new BaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams(((FragmentSetDatas) getArguments().getParcelable(FRAGMENT_KEY)));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void initParams(FragmentSetDatas datas) {

    }


}
