package com.eye.eyepetizer.my.mymessage;

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
 * 点击我的消息的Adapter
 */
public class MyMessageAdapter extends BaseAdapter {

    private MyMessageBean mBean;
    private Context context;

    public MyMessageAdapter(Context context) {
        this.context = context;
    }

    public void setBean(MyMessageBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        return mBean.getMessageList().size();
    }

    @Override
    public Object getItem(int position) {
        return mBean.getMessageList().get(position).getTitle();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        MyView myView = null;
        if (myView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_my_message,viewGroup,false);
            myView = new MyView(view);
            view.setTag(myView);
        }else {
            myView = (MyView) view.getTag();
        }
        Glide.with(context).load(mBean.getMessageList().get(i).getIcon()).into(myView.imageView);
        myView.titleTxt.setText(mBean.getMessageList().get(i).getTitle());
        myView.descriptionTxt.setText(mBean.getMessageList().get(i).getContent());
        return view;
    }
    class MyView{

        private ImageView imageView;
        private TextView titleTxt,timeTxt,descriptionTxt;
        MyView(View view){
            imageView = (ImageView) view.findViewById(R.id.image_icon);
            titleTxt = (TextView) view.findViewById(R.id.title_txt);
            timeTxt = (TextView) view.findViewById(R.id.time_txt);
            descriptionTxt = (TextView) view.findViewById(R.id.description);

        }
    }
}
