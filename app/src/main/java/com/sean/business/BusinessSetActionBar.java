package com.sean.business;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 2015/1/8.
 */
public class BusinessSetActionBar {

    ActionBarActivity activity;

    int resourceLayoutXml;

    public BusinessSetActionBar (ActionBarActivity activity , int resourceLayoutXml) {
        this.activity = activity;
        this.resourceLayoutXml = resourceLayoutXml;

        ActionBar.LayoutParams layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT , ActionBar.LayoutParams.MATCH_PARENT );
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View titleMain = layoutInflater.inflate(resourceLayoutXml , null);

        ActionBar actionBar =activity.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(titleMain , layout);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    public View getActionBarLayout () {
        return null;
    }
}
