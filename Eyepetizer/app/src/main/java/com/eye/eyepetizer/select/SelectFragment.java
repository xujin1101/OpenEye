package com.eye.eyepetizer.select;

import android.widget.ListView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;

/**
 * 精选Fragment
 */
public class SelectFragment extends BaseFragment {
    private ListView mListView;
    @Override
    protected int getLayout() {
        return R.layout.fragment_select;
    }

    @Override
    protected void initView() {
        mListView = findView(R.id.select_lv);
    }

    @Override
    protected void initDate() {

    }
}
