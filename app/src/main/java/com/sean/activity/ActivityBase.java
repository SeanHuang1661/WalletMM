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

    protected void openActivity(Class activityClass) {

        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }

    protected void showMsg(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showAlertDialog() {

    }

}
