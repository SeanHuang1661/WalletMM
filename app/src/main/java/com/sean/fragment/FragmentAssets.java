package com.sean.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sean.walletmm2.R;

/**
 * Created by Administrator on 2015/1/9.
 */
public class FragmentAssets extends FragmentFrame{
    private View view;

    private FragmentAssets () {}

    private static Fragment fragment;

    public static Fragment getInstance () {
        if (fragment == null) {
            fragment = new FragmentAssets();
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_assets , container , false);
        initView();
        initListener();
        initAdapter();
        return view;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initAdapter() {

    }
}
