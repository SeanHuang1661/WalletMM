package com.sean.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sean.model.ModelKeyboard;
import com.sean.walletmm2.R;

import java.util.ArrayList;

public class ActivityLogin extends ActivityFrame implements ModelKeyboard.CheckListener {

    View incLoginUsershower;

    View incLoginKeyboard;

    Button btnUserShowerLeft, btnUserShowerRight;

    TextView tvUserShower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
        createMenu(R.menu.menu_login);
    }

    @Override
    public void initView() {

        incLoginUsershower = findViewById(R.id.incLoginUsershower);
        incLoginKeyboard = findViewById(R.id.incLoginKeyboard);

        btnUserShowerLeft = (Button) incLoginUsershower.findViewById(R.id.btnUserShowerLeft);
        btnUserShowerRight = (Button) incLoginUsershower.findViewById(R.id.btnUserShowerRight);
        tvUserShower = (TextView) incLoginUsershower.findViewById(R.id.tvUserShower);

        new ModelKeyboard(this, R.id.incLoginKeyboard);
    }

    @Override
    public void initListener() {

        btnUserShowerLeft.setOnClickListener(usershowerOCListener);
        btnUserShowerRight.setOnClickListener(usershowerOCListener);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener usershowerOCListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btnUserShowerLeft:
                    showMsg("btnUserShowerLeft");
                    break;

                case R.id.btnUserShowerRight:
                    showMsg("btnUserShowerRight");
                    break;
            }
        }
    };

    @Override
    public void check(ArrayList<String> pList) {

    }
}
