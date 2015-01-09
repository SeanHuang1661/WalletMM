package com.sean.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sean.adapter.AdapterSlidingmenu;
import com.sean.walletmm2.R;

public class FragmentSlidingmenu extends FragmentFrame {

    private View view;

    private FragmentSlidingmenu () {}

    private static Fragment fragment;

    public static Fragment getInstance () {
        if (fragment == null) {
            fragment = new FragmentSlidingmenu();
        }
        return fragment;
    }

    private ListView slidingmenuList ;

    /**
     * Activity和Fragment的连接接口
     * 用来响应Fragment的跳转
     */
    public interface OnFragmentChangeListenre {
        public void onFragmentChange(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_slidingmenu , container , false);
        initView();
        initListener();
        initAdapter();
        return view;
    }


    @Override
    protected void initView() {
        slidingmenuList = (ListView)view.findViewById(R.id.lvSlidingmenuList);
    }

    @Override
    protected void initListener() {
        slidingmenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((OnFragmentChangeListenre)getActivity()).onFragmentChange(position);
            }
        });
    }

    @Override
    protected void initAdapter() {
        slidingmenuList.setAdapter(new AdapterSlidingmenu(getActivity()));
    }
}
