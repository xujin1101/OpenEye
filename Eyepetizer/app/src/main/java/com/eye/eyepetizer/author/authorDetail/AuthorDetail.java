package com.eye.eyepetizer.author.authorDetail;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.allinterface.OnScrollListener;
import com.eye.eyepetizer.base.BaseActivity;
import com.eye.eyepetizer.base.MyScrollview;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/3.
 */
public class AuthorDetail extends BaseActivity implements OnScrollListener, OnClickListener {
    private RadioGroup radioGroupLayout;
    private MyScrollview myScrollview;
    LinearLayout replaceLayout, suspensionLayout;//替换的布局和悬浮的布局.
    LinearLayout headLayout;
    private RadioButton timeRb, enjoyRb;
    private ImageView personal;
    private TextView title, name, content;
    private LinearLayout nameLinear, replace_title;
    private int nameHeight;

    @Override
    protected int getLayout() {
        return R.layout.activity_authordetail;
    }

    @Override
    protected void initView() {
        timeRb = (RadioButton) findViewById(R.id.time_radio);
        enjoyRb = (RadioButton) findViewById(R.id.enjoy_radio);
        personal = (ImageView) findViewById(R.id.personal);
        nameLinear = (LinearLayout) findViewById(R.id.lalala_linearlayout);
        name = (TextView) findViewById(R.id.authordetial_title);
        content = (TextView) findViewById(R.id.authordetial_content);
        radioGroupLayout = (RadioGroup) findViewById(R.id.RadioGroup);
        //整个scrolview的初始化.
        myScrollview = (MyScrollview) findViewById(R.id.scroll);
        suspensionLayout = (LinearLayout) findViewById(R.id.suspensionLayout);
        headLayout= (LinearLayout) findViewById(R.id.headLayout);
        //给listener赋值.
        myScrollview.setOnScrollListener(this);
        Bundle bundle = this.getIntent().getExtras();
        String nameTv = bundle.getString("bcTitle");
        Log.d("111111111------>", nameTv);
        String contentTv = bundle.getString("bcDescription");
        Log.d("111111111------>", contentTv);
        name.setText(nameTv);
        timeRb.setOnClickListener(this);
        enjoyRb.setOnClickListener(this);
        content.setText(contentTv);
        Glide.with(this).load(bundle.getString("bcIcon")).centerCrop().bitmapTransform(new CropCircleTransformation(this))
            .into(personal);
        //此处确保在一开始就可以显示数据.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.replace_layout_mine,new TimeFragment());
        transaction.commit();



    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.time_radio:
                transaction.replace(R.id.replace_layout_mine,new TimeFragment());
                break;
            case R.id.enjoy_radio:
                transaction.replace(R.id.replace_layout_mine,new TimeFragment());
                break;
        }
        transaction.commit();

    }
    //这里设置滑自定义滑动.
    @Override
    public void onScroll(int scrollY) {

    }
}
