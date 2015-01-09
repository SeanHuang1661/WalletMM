package com.sean.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sean.business.BusinessData;
import com.sean.walletmm2.R;

/**
 * Created by Administrator on 2015/1/9.
 */
public class AdapterSlidingmenu extends BaseAdapter {

    private LayoutInflater inflater;

    private ViewHolder viewHolder;

    public AdapterSlidingmenu(Context context){

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return BusinessData.dataSlidingmenuItemName.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = inflater.inflate(R.layout.layout_slidingmenuitem, null);
            viewHolder = new ViewHolder();
            viewHolder.ivSlidingmenuItemPic = (ImageView)convertView.findViewById(R.id.ivSlidingmenuItemPic);
            viewHolder.tvSlidingmenuItemName = (TextView)convertView.findViewById(R.id.tvSlidingmenuItemName);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.ivSlidingmenuItemPic.setBackgroundResource(BusinessData.dataSlidingmenuItemPic.get(position));
        viewHolder.tvSlidingmenuItemName.setText(BusinessData.dataSlidingmenuItemName.get(position));

        return convertView;
    }

    private class ViewHolder {
        public ImageView ivSlidingmenuItemPic;
        public TextView tvSlidingmenuItemName;
    }
}
