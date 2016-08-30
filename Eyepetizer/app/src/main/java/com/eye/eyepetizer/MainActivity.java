package com.eye.eyepetizer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eye.eyepetizer.author.AuthorFragment;
import com.eye.eyepetizer.discover.DiscoverFragment;
import com.eye.eyepetizer.my.MyFragment;
import com.eye.eyepetizer.select.SelectFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragments;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        initData();

    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new SelectFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new AuthorFragment());
        fragments.add(new MyFragment());

        adapter = new MainAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.selector_selection);
        tabLayout.getTabAt(1).setIcon(R.drawable.selector_discover);
        tabLayout.getTabAt(2).setIcon(R.drawable.selector_author);
        tabLayout.getTabAt(3).setIcon(R.drawable.selector_mine);


    }
}
