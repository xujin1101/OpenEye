package com.eye.eyepetizer.select;

import android.content.Context;
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

import java.util.List;

/**
 * Created by dllo on 16/8/31.
 */
public class SelectAdapter extends BaseAdapter {
    private SelectAllBean mSelectBean;
    private LayoutInflater mInflater;

    SelectAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setSelectBean(SelectAllBean selectBean) {
        mSelectBean = selectBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mSelectBean.getIssueList().size();
    }

    @Override
    public Object getItem(int position) {
        return mSelectBean.getIssueList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        VideoHolder videoHolder = null;
        HeaderHolder headerHolder = null;
        BannerHolder bannerHolder = null;

        if (convertView == null) {
            switch (viewType) {
                case AllValues.TYPE_VIDEO:
                    convertView = mInflater.inflate(R.layout.item_select_lv, parent, false);
                    videoHolder = new VideoHolder(convertView);
                    convertView.setTag(videoHolder);
                    break;
                case AllValues.TYPE_TEXT:
                    convertView = mInflater.inflate(R.layout.item_select_header, parent, false);
                    headerHolder = new HeaderHolder(convertView);
                    convertView.setTag(headerHolder);
                    break;
                case AllValues.TYPE_BANNER:
                    convertView = mInflater.inflate(R.layout.item_select_banner, parent, false);
                    bannerHolder = new BannerHolder(convertView);
                    convertView.setTag(bannerHolder);
                    break;
            }

        } else {
            switch (viewType) {
                case AllValues.TYPE_VIDEO:
                    videoHolder = (VideoHolder) convertView.getTag();
                    break;
                case AllValues.TYPE_TEXT:
                    headerHolder = (HeaderHolder) convertView.getTag();
                    break;
                case AllValues.TYPE_BANNER:
                    bannerHolder = (BannerHolder) convertView.getTag();
                    break;
            }

        }
        String image = mSelectBean.getIssueList().get(position)
                .getItemList().get(position).getData().getImage();
        switch (viewType) {
            case AllValues.TYPE_VIDEO:
//                SelectAdapterLv selectAdapterLv = new SelectAdapterLv(EyeApp.getContext());
//                selectAdapterLv.setBean(mSelectBean);
//                selectAdapterLv.setPos(position);
//                videoHolder.mListView.setAdapter(selectAdapterLv);
                break;
            case AllValues.TYPE_TEXT:
                headerHolder.textHeader.setText(mSelectBean.getIssueList().get(position).getItemList().get(position).getData().getText());
                break;
            case AllValues.TYPE_BANNER:

                Glide.with(EyeApp.getContext()).load(image).into(bannerHolder.bannerIv);

                break;

        }

        return convertView;
    }


    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if ("video".equals(mSelectBean.getIssueList().get(position).getItemList().get(position).getType())) {
            return AllValues.TYPE_VIDEO;
        } else if ("textHeader".equals(mSelectBean.getIssueList().get(position).getItemList().get(position).getType())) {
            return AllValues.TYPE_TEXT;
        } else {

            return AllValues.TYPE_BANNER;
        }
    }

    class VideoHolder {

        ListView mListView;

        public VideoHolder(View itemView) {

            mListView = (ListView) itemView.findViewById(R.id.select_lv);
        }
    }


    class BannerHolder {
        ImageView bannerIv;

        public BannerHolder(View itemView) {
            bannerIv = (ImageView) itemView.findViewById(R.id.image_banner);
        }
    }

    class HeaderHolder {
        TextView textHeader;

        public HeaderHolder(View itemView) {
            textHeader = (TextView) itemView.findViewById(R.id.tv_select_text);
        }
    }


}
