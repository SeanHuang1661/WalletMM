package com.sean.model;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sean.business.BusinessData;
import com.sean.walletmm2.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/1/6.
 */
public class ModelKeyboard {

    private Activity activity;

    private View incLoginKeyboard;

    private ArrayList<TextView> etList;

    private ArrayList<Button> btnList;

    private ArrayList<String> pList ;

    private int index = 0;

    public ModelKeyboard (Activity activity, int incXml) {
        this.activity = activity;
        this.incLoginKeyboard = activity.findViewById(incXml);
        this.etList = new ArrayList<TextView>();
        this.btnList = new ArrayList<Button>();
        this.pList = new ArrayList<String>();

        initView();

        initListener();
    }

    private void initView() {

        etList.add((TextView) incLoginKeyboard.findViewById(R.id.etKeyboard_1));
        etList.add((TextView) incLoginKeyboard.findViewById(R.id.etKeyboard_2));
        etList.add((TextView) incLoginKeyboard.findViewById(R.id.etKeyboard_3));
        etList.add((TextView) incLoginKeyboard.findViewById(R.id.etKeyboard_4));
        etList.add((TextView) incLoginKeyboard.findViewById(R.id.etKeyboard_5));
        etList.add((TextView) incLoginKeyboard.findViewById(R.id.etKeyboard_6));

        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_1));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_2));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_3));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_4));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_5));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_6));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_7));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_8));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_9));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboard_0));
        btnList.add((Button) incLoginKeyboard.findViewById(R.id.btnKeyboardClean));

    }

    private void initListener() {

        for (Button btn : btnList) {
            btn.setOnClickListener(keybroadOCListener);
        }
    }

    View.OnClickListener keybroadOCListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            show(BusinessData.pMap.get(v.getId()));
            if (v.getId() == R.id.btnKeyboardClean) {
                clean();
            }
        }
    };

    private void show(String p) {
        if (index < etList.size()) {
            pList.add(p);
            TextView et = etList.get(index);
            et.setText(R.string.loginPasswordMark);
        }
        index ++ ;
        if (index == etList.size()){
            if (activity instanceof CheckListener) {
                if(!((CheckListener)activity).check(pList)){
                    clean();
                }
            }
        }
    }

    private void clean() {
        for (TextView et: etList) {
            index = 0;
            pList.clear();
            et.setText("");
        }
    }

    public interface CheckListener {
        public boolean check(ArrayList<String> pList);
    }
}
