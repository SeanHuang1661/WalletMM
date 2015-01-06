package com.sean.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sean.walletmm2.R;

public abstract class ActivityFrame extends ActivityBase {

    int menuXml ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        if (menuXml != 0)
            getMenuInflater().inflate(menuXml, menu);
        return true;
    }

    protected void createMenu(int menuXml) {
        this.menuXml = menuXml;
    }


    public abstract void initView();


    public abstract void initListener() ;
}
