package com.sean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

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

    /**
     * 弹出提示框
     */
    protected void showAlertDialog() {

    }

}
