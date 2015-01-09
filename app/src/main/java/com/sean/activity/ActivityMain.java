package com.sean.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sean.business.BusinessData;
import com.sean.business.BusinessSetActionBar;
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

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.laySlidingmenuContainer, FragmentSlidingmenu.getInstance());
        fragmentTransaction.commit();
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

    /**
     * 继承于FragmentSlidingmenu.OnFragmentChangeListenre
     * 用来响应Fragment的跳转
     * @param position
     */
    @Override
    public void onFragmentChange(int position) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = BusinessData.dataFragmentInstance.get(position);
        if (fragment != null) {
            fragmentTransaction.replace(R.id.layMainContainer, fragment);
            fragmentTransaction.commit();
        }
        if (position == BusinessData.dataSlidingmenuItemName.size()-1) {
            doOpenActivity(ActivityLogin.class);
        }
        //关闭Slidingmenu
        menu.toggle();
    }
}
