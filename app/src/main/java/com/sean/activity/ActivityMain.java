package com.sean.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sean.business.BusinessSetActionBar;
import com.sean.walletmm2.R;
import com.slidingmenu.lib.SlidingMenu;

public class ActivityMain extends ActivityFrame {

    SlidingMenu menu;

    Button titleMenu ;

    View actionBarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
        initSlidingMenu();

    }

    private void initSlidingMenu () {

        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setShadowWidthRes(R.dimen.slidingMenuShadowWidth);
        menu.setShadowDrawable(R.drawable.shadow_slidingmenu);
        menu.setBehindOffsetRes(R.dimen.slidingMenuOffset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.layout_slidingmenu);
    }

    @Override
    public void initView() {
        BusinessSetActionBar actionBar = new BusinessSetActionBar(this, R.layout.title_main);
        actionBar.doChange();
        actionBarView = actionBar.getLayout();

        titleMenu = (Button)actionBarView.findViewById(R.id.btnMainTitleMenu);
    }

    @Override
    public void initListener() {
        titleMenu.setOnClickListener(titleOnClickListener);
    }

    View.OnClickListener titleOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnMainTitleMenu:
                    menu.toggle();
                    break;
            }
        }
    };
}
