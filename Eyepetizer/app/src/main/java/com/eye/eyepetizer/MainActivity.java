package com.eye.eyepetizer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;import android.view.View;
import android.widget.ImageView;

import com.eye.eyepetizer.author.AuthorFragment;
import com.eye.eyepetizer.base.BaseActivity;
import com.eye.eyepetizer.discover.DiscoverFragment;
import com.eye.eyepetizer.my.MyFragment;
import com.eye.eyepetizer.select.SelectFragment;

import java.util.ArrayList;
public class MainActivity extends BaseActivity implements OnPageChangeListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private MainAdapter adapter;
    private ImageView searchIv,menuIv;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        searchIv = findView(R.id.title_search_iv);
        menuIv = findView(R.id.title_more_iv);
    }

    @Override
    protected void initDate() {
        fragments = new ArrayList<>();
        fragments.add(new SelectFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new AuthorFragment());
        fragments.add(new MyFragment());

        adapter = new MainAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        //ViewPager 滑动监听
        viewPager.addOnPageChangeListener(this);
        initTab();
    }
    private void initTab() {
        int[] selects = {R.drawable.selector_selection, R.drawable.selector_discover, R.drawable.selector_author, R.drawable.selector_mine};
        for (int i = 0; i < selects.length; i++) {
            tabLayout.getTabAt(i).setIcon(selects[i]);
        }
    }

    //ViewPager页面发生变化
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    //每次页面切换
    @Override
    public void onPageSelected(int position) {
        if (position == 3) {
            searchIv.setVisibility(View.GONE);
            menuIv.setVisibility(View.VISIBLE);
        } else {
            searchIv.setVisibility(View.VISIBLE);
            menuIv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
