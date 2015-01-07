package com.sean.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;

import com.sean.walletmm2.R;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ActivityFrame extends ActivityBase {

    private int resourceMenuXml = 0;

    private int indexClickBack = 0;

    private Timer timer = null;

    private final int TIME_WAIT_FINISH = 3000;

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
        indexClickBack += 1 ;

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
    protected void doSetTitle (int resourceTitle) {
        setTitle(resourceTitle);
    }

    public abstract void initView();


    public abstract void initListener() ;
}
