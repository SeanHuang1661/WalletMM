package com.sean.business;

import java.util.ArrayList;

/**
 * Created by Sean on 2015/1/6.
 */
public class BusinessCheck {
    private static  BusinessCheck businessCheck;

    private BusinessCheck (){}

    static public BusinessCheck newInstence (){
        if (businessCheck == null) {
            businessCheck = new BusinessCheck();
        }
        return businessCheck;
    }

    public boolean check (ArrayList<String> pList) {
        return doCheck(pList);
    }

    private boolean doCheck (ArrayList<String> pList) {
        String p = "";
        for (String pItem : pList) {
            p += pItem;
        }
        if (p.equals("123456")) {
            return true;
        }
        return false;
    }
}
