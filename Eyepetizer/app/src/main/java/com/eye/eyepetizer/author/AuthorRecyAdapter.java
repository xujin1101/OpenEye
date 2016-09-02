package com.eye.eyepetizer.author;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.author.AuthorRecyAdapter.DataViewHolder;
import com.eye.eyepetizer.author.HeadAuthorEntity.ItemListBean.DataBean.ItemListBeanSecond.DataBeanSecond.AuthorsBean;

/**
 * Created by dllo on 16/9/1.
 */
public class AuthorRecyAdapter extends Adapter<DataViewHolder>{
    private HeadAuthorEntity author;
    private Context context;
    //这里没有接口.用了接口以后得给赋值.
    private int pos ;
    private LayoutInflater inflater;

    public AuthorRecyAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setAuthorsBean(HeadAuthorEntity author) {
        this.author = author;
        notifyDataSetChanged();
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DataViewHolder dataViewHolder =null;
        dataViewHolder = new DataViewHolder(inflater.inflate(R.layout.author_recycler_video_recydata,parent,false));

        return dataViewHolder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        DataViewHolder dataViewHolder = holder;
        dataViewHolder.tvTitle.setText(author.getItemList().get(pos).getData().getItemList().get(position).getData().getTitle());
        dataViewHolder.tvCategory.setText("#"+author.getItemList().get(pos).getData().getItemList().get(position).getData().getCategory());
        Glide.with(context).load(author.getItemList().get(pos).getData().getItemList().get(position).getData().getCover().getFeed())
        .into(dataViewHolder.ivCover);


    }

    @Override
    public int getItemCount() {

        return author.getItemList().get(pos).getData().getItemList().size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCover;
        TextView tvTitle,tvCategory;

        public DataViewHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_item_author_data_cover);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_author_data_title);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_item_author_data_category);
        }
    }
}
