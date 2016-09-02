package com.eye.eyepetizer.discover.topic;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;

/**
 * 点击TOPIC
 */
public class TopIcAdapter extends BaseAdapter {

    private TopIcBean mTopIcBean;
    private Context context;

    public TopIcAdapter(Context context) {
        this.context = context;
    }

    public void setTopIcBean(TopIcBean topIcBean) {
        mTopIcBean = topIcBean;
    }

    @Override
    public int getCount() {
        return mTopIcBean.getItemList().size();
    }

    @Override
    public Object getItem(int position) {
        return mTopIcBean.getItemList().get(position).getData().getImage();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        MyView myView = null;
        if (myView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_only_image,viewGroup,false);
            myView = new MyView(view);
            view.setTag(myView);
        }else {
            myView = (MyView) view.getTag();
        }
        Glide.with(context).load(mTopIcBean.getItemList().get(i).getData().getImage()).placeholder(R.mipmap.lolo).error(R.mipmap.lolo).into(myView.imageView);

        ObjectAnimator.ofFloat(view, "translationY", 400, 0).setDuration(1000).start();
        ObjectAnimator.ofFloat(view, "rotationX", 360, 0).setDuration(1000).start();
        return view;
    }
    class MyView{

        private ImageView imageView;
        MyView(View view){
            imageView = (ImageView) view.findViewById(R.id.image_view);
        }
    }
}
