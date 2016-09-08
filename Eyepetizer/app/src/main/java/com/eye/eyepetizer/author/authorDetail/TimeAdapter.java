package com.eye.eyepetizer.author.authorDetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.author.AllAuthorAdapter;

/**
 * Created by dllo on 16/9/6.
 */
public class TimeAdapter extends BaseAdapter{
    private Context mContext;
    private TimeEntity timeBean;
    private String time;
    LayoutInflater inflater;

    public TimeAdapter(Context context) {
        mContext = context;
        inflater= LayoutInflater.from(context);
    }

    public void setTimeBean(TimeEntity timeBean) {
        this.timeBean = timeBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return timeBean==null? 0:timeBean.getCount();
    }

    @Override
    public Object getItem(int position) {
        return timeBean.getItemList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView ==null){
            convertView = inflater.inflate(R.layout.item_time_data,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load(timeBean.getItemList().get(position).
        getData().getCover().getFeed()).into(holder.imgView);
        Log.d("TimeAdapter", timeBean.getItemList().get(position).
                getData().getCover().getFeed());
        holder.textViewRecord.setText(timeBean.getItemList().get(position)
        .getData().getCategory());
        int duration = timeBean.getItemList().get(position).getData().getDuration();
        time = duration /60 +"'" +duration% 60+"''";
        holder.textViewTime.setText(time);
        holder.textViewTitle.setText(timeBean.getPgcInfo().getName());
        holder.textViewContent.setText(timeBean.getItemList().get(position)
        .getData().getTitle());
        return convertView;


    }
    public class ViewHolder{
        private ImageView imgView;
        private TextView textViewContent,textViewTitle,textViewTime,textViewRecord;
        public ViewHolder(View view){
            textViewContent = (TextView) view.findViewById(R.id.author_time_tv);
            textViewTitle= (TextView) view.findViewById(R.id.author_time_title);
            imgView = (ImageView) view.findViewById(R.id.author_time_image);
            textViewTime = (TextView) view.findViewById(R.id.author_time_time);
            textViewRecord= (TextView) view.findViewById(R.id.author_time_record);
        }

    }
}