package com.sean.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sean.walletmm2.R;

public class ActivityBase extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    /**
     * 打开其他activity
     * @param activityClass
     */
    protected void doOpenActivity(Class activityClass) {

        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }

    /**
     * 显示信息
     * @param resourceMsg
     */
    protected void doShowMsg(int resourceMsg) {

        Toast.makeText(this, resourceMsg, Toast.LENGTH_SHORT).show();
    }

    protected void doShowMsg(String stringMsg) {

        Toast.makeText(this, stringMsg, Toast.LENGTH_SHORT).show();
    }

    protected void showAlertDialog() {

    }

}
