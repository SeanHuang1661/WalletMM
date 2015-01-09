package com.sean.business;

import android.app.Fragment;

import com.sean.fragment.FragmentAccountList;
import com.sean.fragment.FragmentAssets;
import com.sean.fragment.FragmentBackup;
import com.sean.fragment.FragmentSetup;
import com.sean.fragment.FragmentStatistics;
import com.sean.walletmm2.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2015/1/6.
 */
public class BusinessData {
    public static final String STR_SLIDINGMENUITEM_PIC = "str_slidingmenuitem_pic";

    public static final String STR_SLIDINGMENUITEM_NAME = "str_slidingmenuitem_name";

    public static HashMap<Integer, String> dataKeyboard = new HashMap();

    public static ArrayList<Integer> dataSlidingmenuItemPic = new ArrayList();

    public static ArrayList<Integer> dataSlidingmenuItemName = new ArrayList();

    public static HashMap<Integer, Fragment> dataFragmentInstance = new HashMap<>();

    static {
        dataKeyboard.put(R.id.btnKeyboard_1, "1");
        dataKeyboard.put(R.id.btnKeyboard_2, "2");
        dataKeyboard.put(R.id.btnKeyboard_3, "3");
        dataKeyboard.put(R.id.btnKeyboard_4, "4");
        dataKeyboard.put(R.id.btnKeyboard_5, "5");
        dataKeyboard.put(R.id.btnKeyboard_6, "6");
        dataKeyboard.put(R.id.btnKeyboard_7, "7");
        dataKeyboard.put(R.id.btnKeyboard_8, "8");
        dataKeyboard.put(R.id.btnKeyboard_9, "9");
        dataKeyboard.put(R.id.btnKeyboard_0, "0");
    }

    static {
        dataSlidingmenuItemPic.add(R.drawable.add_defual);
        dataSlidingmenuItemPic.add(R.drawable.add_defual);
        dataSlidingmenuItemPic.add(R.drawable.add_defual);
        dataSlidingmenuItemPic.add(R.drawable.add_defual);
        dataSlidingmenuItemPic.add(R.drawable.add_defual);
        dataSlidingmenuItemPic.add(R.drawable.add_defual);
    }

    static {
        dataSlidingmenuItemName.add(R.string.slidingmenuItemName1);
        dataSlidingmenuItemName.add(R.string.slidingmenuItemName2);
        dataSlidingmenuItemName.add(R.string.slidingmenuItemName3);
        dataSlidingmenuItemName.add(R.string.slidingmenuItemName4);
        dataSlidingmenuItemName.add(R.string.slidingmenuItemName5);
        dataSlidingmenuItemName.add(R.string.slidingmenuItemName6);
    }

    static {
        dataFragmentInstance.put(0, FragmentAccountList.getInstance());
        dataFragmentInstance.put(1, FragmentStatistics.getInstance());
        dataFragmentInstance.put(2, FragmentAssets.getInstance());
        dataFragmentInstance.put(3, FragmentBackup.getInstance());
        dataFragmentInstance.put(4, FragmentSetup.getInstance());
        dataFragmentInstance.put(6, null);
    }
}
