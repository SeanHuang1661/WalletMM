package com.sean.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;

import com.sean.walletmm2.R;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ActivityFrame extends ActivityBase {

    private int resourceMenuXml = 0;

    private int indexClickBack = 0;

    private Timer timer = null;

    private final int TIME_WAIT_FINISH = 3000;

    private String fragmentTag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (resourceMenuXml != 0)
            getMenuInflater().inflate(resourceMenuXml, menu);
        return true;
    }

    /**
     * 创建菜单
     *
     * @param resourceMenuXml
     */
    protected void doCreateMenu(int resourceMenuXml) {

        this.resourceMenuXml = resourceMenuXml;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            doExit();
        }
        return true;
    }

    /**
     * 退出操作
     */
    private void doExit() {

        indexClickBack += 1;

        if (indexClickBack == 1) {
            doShowMsg(R.string.frame_again_finish);

            if (timer == null) {
                timer = new Timer();
            }

            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    indexClickBack = 0;
                }
            }, TIME_WAIT_FINISH);

        } else if (indexClickBack == 2) {
            finish();
        }
    }

    /**
     * 设置标题
     */
    protected void doSetTitle(int resourceTitle) {

        setTitle(resourceTitle);
    }

    /**
     * 管理Fragment
     */
    protected void doFragemntManage(int resourceContainer, Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(resourceContainer, fragment);
        fragmentTransaction.commit();
    }

    public abstract void initView();


    public abstract void initListener();

    public abstract void initActionBar();
}
