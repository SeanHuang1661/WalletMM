package com.sean.fragment;

import android.app.Fragment;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/1/9.
 */
public class FragmentBase extends Fragment{

    /**
     * 显示信息
     * @param resourceMsg
     */
    protected void doShowMsg(int resourceMsg) {

        Toast.makeText(getActivity(), resourceMsg, Toast.LENGTH_SHORT).show();
    }

    protected void doShowMsg(String stringMsg) {

        Toast.makeText(getActivity(), stringMsg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出提示框
     */
    protected void showAlertDialog() {

    }
}
