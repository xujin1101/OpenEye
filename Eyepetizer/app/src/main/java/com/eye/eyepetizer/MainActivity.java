package com.eye.eyepetizer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eye.eyepetizer.author.AuthorFragment;
import com.eye.eyepetizer.base.BaseActivity;
import com.eye.eyepetizer.discover.DiscoverFragment;
import com.eye.eyepetizer.my.MyFragment;
import com.eye.eyepetizer.select.SelectFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private MainAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
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

       initTab();
    }
    private void initTab() {
        int[] selects = {R.drawable.selector_selection, R.drawable.selector_discover,R.drawable.selector_author,R.drawable.selector_mine};
        for (int i = 0; i < selects.length; i++) {
            tabLayout.getTabAt(i).setIcon(selects[i]);
        }
    }



}
