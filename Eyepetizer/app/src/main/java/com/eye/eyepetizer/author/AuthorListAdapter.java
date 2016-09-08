package com.eye.eyepetizer.author;

import android.content.Context;
import android.content.res.AssetFileDescriptor.AutoCloseInputStream;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.allinterface.BriefOnClickListener;
import com.eye.eyepetizer.allinterface.VideoBriefOnClickListener;

import java.security.PolicySpi;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;

/**
 * Created by dllo on 16/9/1.
 */
//继承adapter,里边填泛型holder
public class AuthorListAdapter extends Adapter<RecyclerView.ViewHolder> {
    private HeadAuthorEntity author;
    private Context mContext;
    private int type;
    private static final int HEADER = 0;
    private static final int BRIEFCARD = 1;
    private static final int VIDEOBRIEF = 2;
    private static final int BLANKCARD = 3;

    private LayoutInflater inflater;
    //申明接口
    private BriefOnClickListener mBriefOnClickListener;
    private VideoBriefOnClickListener mVideoBriefOnClickListener;
    //接口为空,给接口进行赋值
    public void setBriefOnClickListener(BriefOnClickListener briefOnClickListener){
        this.mBriefOnClickListener = briefOnClickListener;
    }

    public void setVideoBriefOnClickListener(VideoBriefOnClickListener videoBriefOnClickListener) {
        mVideoBriefOnClickListener = videoBriefOnClickListener;
    }

    //构造方法
    public AuthorListAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    //利用set方法给赋值.
    public void setAuthor(HeadAuthorEntity author) {
        this.author = author;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case HEADER:
                viewHolder = new HeaderViewHolder(inflater.inflate(R.layout.author_head_header, parent, false));
                break;
            case BRIEFCARD:
                viewHolder = new BriefCardViewHolder(inflater.inflate(R.layout.hot_author_include, parent, false));
                break;
            case VIDEOBRIEF:
                viewHolder = new VideoBriefViewHolder(inflater.inflate(R.layout.author_recycler_video, parent, false));
                break;
            case BLANKCARD:
                viewHolder = new BrankCaredViewHolder(inflater.inflate(R.layout.author_head_brankcard,parent,false));
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case HEADER:
                //根据不同的类型判断里边不同holder转成具体类型
                Log.d("aa", "position:" + position);
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.textView.setText(author.getItemList().get(position).getData().getText());
                break;
            case BRIEFCARD:
                Log.d("bb", "position:" + position);
                final BriefCardViewHolder briefCardViewHolder = (BriefCardViewHolder) holder;
                briefCardViewHolder.tvTitle.setText(author.getItemList().get(position).getData().getTitle());
                briefCardViewHolder.tvSubTitle.setText(author.getItemList().get(position).getData().getSubTitle());
                briefCardViewHolder.tvDescription.setText(author.getItemList().get(position).getData().getDescription());
                Glide.with(mContext).load(author.getItemList().get(position).getData().getIcon()).bitmapTransform(new CropCircleTransformation(mContext)).into(briefCardViewHolder.ivIcon);
                //注意我这里的点击事件都没有设置呢.
                briefCardViewHolder.mRelativeLayout.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //这里是获取到点击出对应位置的方法
                        int position = briefCardViewHolder.getLayoutPosition();
                        //这里边也是覆写这个点击方法.这里就是一个打电话的过程.
                        mBriefOnClickListener.onClick(position);
                    }
                });

                break;
            case VIDEOBRIEF:
                final VideoBriefViewHolder videoBriefViewHolder = (VideoBriefViewHolder) holder;
                videoBriefViewHolder.tvTitle.setText(author.getItemList().get(position).getData().getHeader().getTitle());
                videoBriefViewHolder.tvSubTitle.setText(author.getItemList().get(position).getData().getHeader().getSubTitle());
                videoBriefViewHolder.tvDescription.setText(author.getItemList().get(position).getData().getHeader().getDescription());
                Glide.with(mContext).load(author.getItemList().get(position).getData().getHeader().getIcon()).bitmapTransform(new CropCircleTransformation(mContext)).into(videoBriefViewHolder.ivIcon);
                //给RecyclerView进行初始化,并且
                AuthorRecyAdapter adapter = new AuthorRecyAdapter(mContext);
                adapter.setAuthorsBean(author);
                adapter.setPos(position);
                //设置布局管理器和设置进去adapter.
                videoBriefViewHolder.recyclerView.setAdapter(adapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                videoBriefViewHolder.recyclerView.setLayoutManager(linearLayoutManager);
                // TODO: 16/9/3  里边对RecyclerView的adapter也要设置点击事件.,这里先不设置.
                //这里直接给item设置点击事件,其中的RecyclerView是不能触发点击事件的.
                //点击事件实在这个里边写,这里边有position.
                videoBriefViewHolder.mLinearLayout.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = videoBriefViewHolder.getLayoutPosition();
                        mVideoBriefOnClickListener.onClick(position);
                    }
                });

                break;
            case BLANKCARD:
                BrankCaredViewHolder brankCaredViewHolder = (BrankCaredViewHolder) holder;
                break;

        }
    }

    @Override
    public int getItemCount() {
        return author.getCount();
    }

    //重新覆写方法,确定item类型.
    @Override
    public int getItemViewType(int position) {
        switch (author.getItemList().get(position).getType()) {
            case "leftAlignTextHeader":
                type = HEADER;
                break;
            case "briefCard":
                type = BRIEFCARD;
                break;
            case "videoCollectionWithBrief":
                type = VIDEOBRIEF;
                break;
            case "blankCard":
                type = BLANKCARD;
        }
        return type;
    }

    //分别创建type为0123时的holder
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.author_hot);
        }
    }

    class BriefCardViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvTitle, tvSubTitle, tvDescription;
        private RelativeLayout mRelativeLayout;

        public BriefCardViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.image_author_icon);
            tvTitle = (TextView) itemView.findViewById(R.id.hot_author);
            tvDescription = (TextView) itemView.findViewById(R.id.description);
            tvSubTitle = (TextView) itemView.findViewById(R.id.video_number);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.briefcard_relative);
        }
    }

    class VideoBriefViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle, tvSubTitle, tvDescription;
        RecyclerView recyclerView;
        LinearLayout mLinearLayout;

        public VideoBriefViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.image_author_icon);
            tvTitle = (TextView) itemView.findViewById(R.id.hot_author);
            tvDescription = (TextView) itemView.findViewById(R.id.description);
            tvSubTitle = (TextView) itemView.findViewById(R.id.video_number);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recy_videobrief_data);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.videobrief_relative);
        }
    }

    class BrankCaredViewHolder extends RecyclerView.ViewHolder {
            LinearLayout mLinearLayout;

        public BrankCaredViewHolder(View itemView) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.layout_author_recy_blankcard);

        }
    }
}
