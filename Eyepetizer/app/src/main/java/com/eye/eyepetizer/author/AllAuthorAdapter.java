package com.eye.eyepetizer.author;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;


/**
 * Created by dllo on 16/8/31.
 */
public class AllAuthorAdapter extends BaseAdapter{
    public Context context;
    private ListView mListView;
    private AllAuthorEntity mAllAuthorEntity;

    public AllAuthorAdapter(Context context) {
        this.context = context;
    }

    public void setListView(ListView listView) {
        mListView = listView;
    }

    public void setAllAuthorEntity(AllAuthorEntity allAuthorEntity) {
        mAllAuthorEntity = allAuthorEntity;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mAllAuthorEntity.getItemList().size();
    }

    @Override
    public Object getItem(int position) {
        return mAllAuthorEntity.getItemList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            convertView= LayoutInflater.from(context)
                    .inflate(R.layout.hot_author_include,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.author.setText(mAllAuthorEntity.getItemList().get(position).getData().getTitle());
        holder.videoNumber.setText(mAllAuthorEntity.getItemList().get(position).getData().getSubTitle());
        holder.description.setText(mAllAuthorEntity.getItemList().get(position).getData().getDescription());
        Glide.with(context).load(mAllAuthorEntity.getItemList().get(position).getData().getIcon())
                .bitmapTransform(new CropCircleTransformation(context)).into(holder.mImageView);
        return convertView;
    }
    public static class ViewHolder{
        private ImageView mImageView;
        private TextView author,description,videoNumber;
        public ViewHolder(View view){
            mImageView = (ImageView) view.findViewById(R.id.image_author_icon);
            author = (TextView) view.findViewById(R.id.hot_author);
            description = (TextView) view.findViewById(R.id.description);
            videoNumber = (TextView) view.findViewById(R.id.video_number);


        }
    }
}
