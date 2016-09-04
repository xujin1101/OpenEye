package com.eye.eyepetizer.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;

/**
 * Discover主页的Adapter
 */
public class DiscoverAdapter extends BaseAdapter{
    private DiscoverBean mBean;
    private Context context;
    private int mNum;

    public DiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setBean(DiscoverBean bean) {
        mBean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mBean.getItemList().size() - 4;
    }

    @Override
    public Object getItem(int position) {
        return mBean.getItemList().get(position).getData().getImage();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        mNum = i;
        MyView myView = null;
        if (myView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_discover_gridview,viewGroup,false);
            myView = new MyView(view);
            view.setTag(myView);
        }else {
            myView = (MyView) view.getTag();
        }
        Glide.with(context).load(mBean.getItemList().get(i+4).getData().getImage()).into(myView.imageView);
        myView.gridTxt.setText(mBean.getItemList().get(i+4).getData().getTitle());
        return view;
    }
    class MyView{

        private ImageView imageView;
        private TextView gridTxt;

        MyView(View view){
            imageView = (ImageView) view.findViewById(R.id.grid_img);
            gridTxt = (TextView) view.findViewById(R.id.grid_txt);
        }
    }
}
