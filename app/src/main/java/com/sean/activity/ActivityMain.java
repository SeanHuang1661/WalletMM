package com.sean.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;

import com.sean.business.BusinessData;
import com.sean.fragment.FragmentAccountList;
import com.sean.fragment.FragmentSlidingmenu;
import com.sean.walletmm2.R;
import com.slidingmenu.lib.SlidingMenu;

public class ActivityMain extends ActivityFrame implements FragmentSlidingmenu.OnFragmentChangeListenre{

    private SlidingMenu menu;

    private Button titleMenu ;

    private View actionBarView;

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initActionBar();
        setContentView(R.layout.activity_main);

        //此处有一个bug,FragmentSlidingmenu要比FragmentAccountList先被Transaction
        //不然第一次点击AccountList ，FragmentSlidingmenu会消失
        initSlidingMenu();
        initView();
        initListener();
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

        doFragemntManage(R.id.laySlidingmenuContainer, FragmentSlidingmenu.getInstance());
    }

    @Override
    public void initView() {
        //设置ActionBar
//        BusinessSetActionBar actionBar = new BusinessSetActionBar(this, R.layout.title_main);
//        actionBar.doChange();
//        actionBarView = actionBar.getLayout();
//
//        titleMenu = (Button)actionBarView.findViewById(R.id.btnMainTitleMenu);

        //设置main初始页面为fragment_accountlist
        doFragemntManage(R.id.layMainContainer, FragmentAccountList.getInstance());
    }

    @Override
    public void initListener() {
//        titleMenu.setOnClickListener(titleOnClickListener);
    }

    @Override
    public void initActionBar() {
        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_home);
        actionBar.setIcon(R.drawable.ic_menu_home);

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

    /**
     * 继承于FragmentSlidingmenu.OnFragmentChangeListenre
     * 用来响应Fragment的跳转
     * @param position
     */
    @Override
    public void onFragmentChange(int position) {
        Fragment fragment = BusinessData.dataFragmentInstance.get(position);
        if (fragment != null) {
            doFragemntManage(R.id.layMainContainer, fragment);
        }
        if (position == BusinessData.SLIDINGMENU_LAST_POSITION) {
            doOpenActivity(ActivityLogin.class);
        }
        //关闭Slidingmenu
        menu.toggle();
    }
}
