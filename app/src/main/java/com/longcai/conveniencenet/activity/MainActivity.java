package com.longcai.conveniencenet.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.longcai.conveniencenet.BaseActivity;
import com.longcai.conveniencenet.R;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        bar = ((BottomNavigationBar) view.findViewById(R.id.bnb_main));
        bar.setMode(BottomNavigationBar.MODE_FIXED);
        bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bar
                .addItem(new BottomNavigationItem(R.drawable.bottom_one, getResources().getString(R.string.bnb_name_shouye)))
                .addItem(new BottomNavigationItem(R.drawable.bottom_two, getResources().getString(R.string.bnb_name_youhuiquan)))
                .addItem(new BottomNavigationItem(R.drawable.bottom_three, getResources().getString(R.string.bnb_name_shangjiahuodong)))
                .addItem(new BottomNavigationItem(R.drawable.bottom_four, getResources().getString(R.string.bnb_name_guanzhu)))
                .addItem(new BottomNavigationItem(R.drawable.bottom_five, getResources().getString(R.string.bnb_name_wode)))
                .initialise();
        bar.setTabSelectedListener(this);

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
