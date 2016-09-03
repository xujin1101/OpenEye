package com.eye.eyepetizer.discover.glideview;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseActivity;
import com.eye.eyepetizer.discover.glideview.share.GlideViewNextShareFragment;
import com.eye.eyepetizer.discover.glideview.time.GlideViewNextTimeFragment;

import java.util.ArrayList;

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
 * 作者：TheTopKing_杨燚 on 16/9/3 11:00
 * 这周日你有空吗
 */
public class GlideViewNextActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private GlideViewNextAdapter mGlideViewNextAdapter;
    private ImageView returnImg;
    @Override
    protected int getLayout() {
        return R.layout.activity_discover_top;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.top_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.top_tab);

        returnImg = (ImageView) findViewById(R.id.return_img);

        returnImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initDate() {
        fragments = new ArrayList<>();
        fragments.add(new GlideViewNextTimeFragment());
        fragments.add(new GlideViewNextShareFragment());


        mGlideViewNextAdapter = new GlideViewNextAdapter(getSupportFragmentManager());
        mGlideViewNextAdapter.setFragments(fragments);
        viewPager.setAdapter(mGlideViewNextAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
