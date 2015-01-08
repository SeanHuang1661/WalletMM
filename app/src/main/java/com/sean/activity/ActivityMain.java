package com.sean.activity;

import android.os.Bundle;
import android.view.Window;

import com.sean.walletmm2.R;
import com.slidingmenu.lib.SlidingMenu;

public class ActivityMain extends ActivityFrame {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title_main);
        initView();
        initListener();
        initSlidingMenu();
    }

    private void initSlidingMenu () {

        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.slidingMenuShadowWidth);
        menu.setShadowDrawable(R.drawable.shadow_slidingmenu);
        menu.setBehindOffsetRes(R.dimen.slidingMenuOffset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//        menu.setMenu(R.layout.menu);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

}
