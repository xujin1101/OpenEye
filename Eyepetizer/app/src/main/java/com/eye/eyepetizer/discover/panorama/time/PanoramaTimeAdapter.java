package com.eye.eyepetizer.discover.panorama.time;

import android.animation.ObjectAnimator;
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
 * 　　　　　　　 ┏┓ 　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　帅哥 　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽大帅哥在上
 * 　　　　　　　　　┃　　　┃          无bug代码在下
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * <p>
 * 作者：TheTopKing_杨燚 on 16/9/2 10:00
 * 这周日你有空吗
 */
public class PanoramaTimeAdapter extends BaseAdapter {
    private PanoramaTimeBean mBean;
    private Context context;

    public PanoramaTimeAdapter(Context context) {
        this.context = context;
    }

    public void setBean(PanoramaTimeBean bean) {
        mBean = bean;
    }

    @Override
    public int getCount() {
        return mBean.getItemList().size();
    }

    @Override
    public Object getItem(int position) {
        return mBean.getItemList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        MyView myView = null;
        if (myView == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_panorama_list_img,viewGroup,false);
            myView = new MyView(view);
            view.setTag(myView);
        }else {
            myView = (MyView) view.getTag();
        }
        Glide.with(context).load(mBean.getItemList().get(i).getData().getCover().getFeed()).placeholder(R.mipmap.lolo).error(R.mipmap.lolo).thumbnail(0.2f).into(myView.imageView);
        myView.titleTxt.setText(mBean.getItemList().get(i).getData().getTitle());
        myView.descriptionTxt.setText("#"+mBean.getItemList().get(i).getData().getCategory());
        myView.numTxt.setText(i+1+".");
        myView.nameText.setText(mBean.getItemList().get(i).getData().getLabel().getText());


        ObjectAnimator.ofFloat(view, "translationY", 400, 0).setDuration(1000).start();
        ObjectAnimator.ofFloat(view, "rotationX", 360, 0).setDuration(1000).start();
        return view;
    }
    class MyView{

        private ImageView imageView;
        private TextView titleTxt,timeTxt,descriptionTxt,numTxt,nameText;
        MyView(View view){
            imageView = (ImageView) view.findViewById(R.id.img_back);
            titleTxt = (TextView) view.findViewById(R.id.title);
            timeTxt = (TextView) view.findViewById(R.id.txt_time);
            descriptionTxt = (TextView) view.findViewById(R.id.what_txt);
            numTxt = (TextView) view.findViewById(R.id.name_txt);
            nameText = (TextView) view.findViewById(R.id.name);
        }
    }
}