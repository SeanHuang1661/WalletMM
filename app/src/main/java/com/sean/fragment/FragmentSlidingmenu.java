package com.sean.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sean.walletmm2.R;

public class FragmentSlidingmenu extends Fragment {

    View slidingmenuView;

    private static FragmentSlidingmenu fragmentSlidingmenu;

    private FragmentSlidingmenu () {}

    public static FragmentSlidingmenu getInstance () {
        if (fragmentSlidingmenu == null) {
            fragmentSlidingmenu = new FragmentSlidingmenu();
        }
        return fragmentSlidingmenu;
    }

    private void initAdapter () {
        
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        slidingmenuView = inflater.inflate(R.layout.fragment_slidingmenu , container , false);
        return slidingmenuView;
    }


}
