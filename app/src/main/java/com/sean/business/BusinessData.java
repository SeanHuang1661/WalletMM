package com.sean.business;

import com.sean.walletmm2.R;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/1/6.
 */
public class BusinessData {

    public static HashMap<Integer, String> pMap = new HashMap();

    static {
        pMap.put(R.id.btnKeyboard_1, "f");
        pMap.put(R.id.btnKeyboard_2, "g");
        pMap.put(R.id.btnKeyboard_3, "j");
        pMap.put(R.id.btnKeyboard_4, "v");
        pMap.put(R.id.btnKeyboard_5, "u");
        pMap.put(R.id.btnKeyboard_6, "k");
        pMap.put(R.id.btnKeyboard_7, "z");
        pMap.put(R.id.btnKeyboard_8, "l");
        pMap.put(R.id.btnKeyboard_9, "c");
        pMap.put(R.id.btnKeyboard_0, "b");
    }
}
