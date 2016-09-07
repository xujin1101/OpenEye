package com.eye.eyepetizer.select;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.EyeApp;
import com.eye.eyepetizer.until.AllValues;

/**
 * Created by dllo on 16/9/2.
 */
public class SelectAdapterLv extends BaseAdapter {
    private SelectBean mSelectBean;
    private LayoutInflater mInflater;
    private int duration;

    public SelectAdapterLv(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    public void setSelectBean(SelectBean selectBean) {
        mSelectBean = selectBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 20;
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

        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_select_video, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Glide.with(EyeApp.getContext()).load(mSelectBean.getSectionList().get(0).getItemList().get(position).getData().getCover().getFeed()).into(viewHolder.videoIv);
        viewHolder.videoTitle.setText(mSelectBean.getSectionList().get(0).getItemList().get(position).getData().getTitle());
        viewHolder.videoCategory.setText("#" + mSelectBean.getSectionList().get(0).getItemList().get(position).getData().getCategory());
        duration = mSelectBean.getSectionList().get(0).getItemList().get(position).getData().getDuration();

        String time = duration / 600 + "" + duration % 600 / 60 + "' " + duration % 60 / 10 + "" + duration % 60 % 10 + "''";
        viewHolder.videoTime.setText(time);


        return convertView;
    }


    class ViewHolder {
        ImageView videoIv;
        TextView videoTitle, videoCategory, videoTime;

        public ViewHolder(View itemView) {
            videoIv = (ImageView) itemView.findViewById(R.id.iv_select_video);
            videoTitle = (TextView) itemView.findViewById(R.id.tv_video_title);
            videoCategory = (TextView) itemView.findViewById(R.id.tv_video_category);
            videoTime = (TextView) itemView.findViewById(R.id.tv_video_time);
        }
    }
}
