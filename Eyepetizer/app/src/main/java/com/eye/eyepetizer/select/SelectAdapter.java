package com.eye.eyepetizer.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by dllo on 16/8/31.
 */
public class SelectAdapter extends BaseAdapter {
    private SelectBean mSelectBean;
    private LayoutInflater mInflater;

    private SelectAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setSelectBean(SelectBean selectBean) {
        mSelectBean = selectBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mSelectBean.getSectionList().size();
    }

    @Override
    public Object getItem(int position) {
        return mSelectBean.getSectionList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
