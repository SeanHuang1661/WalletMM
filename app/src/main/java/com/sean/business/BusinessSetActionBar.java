package com.sean.business;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

/**
 * Created by Administrator on 2015/1/8.
 */
public class BusinessSetActionBar {

    private ActionBarActivity activity;

    private int resourceLayoutXml;

    private ActionBar actionBar;

    private ActionBar.LayoutParams layout;

    private View actionBarView;

    public BusinessSetActionBar (ActionBarActivity activity , int resourceLayoutXml) {
        this.activity = activity;
        this.resourceLayoutXml = resourceLayoutXml;

        actionBarView = activity.getLayoutInflater().inflate(resourceLayoutXml , null);
        layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT , ActionBar.LayoutParams.MATCH_PARENT );

        actionBar =activity.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    public View getLayout() {
        return actionBarView;
    }

    public void doChange () {
        actionBar.setCustomView(actionBarView , layout);
    }
}
