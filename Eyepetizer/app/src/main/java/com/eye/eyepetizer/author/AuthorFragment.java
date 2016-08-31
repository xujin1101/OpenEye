package com.eye.eyepetizer.author;

import android.widget.ListView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.okHttp.NetTool;
import com.eye.eyepetizer.okHttp.onHttpCallBack;

import okhttp3.Callback;

/**
 * 作者Fragment
 */
public class AuthorFragment extends BaseFragment{
    private String allAuthorUrl = "http://baobab.wandoujia.com/api/v3/tabs/pgcs/more?start=0&num=85";
    private AllAuthorAdapter mAdapter;
    private ListView mListView;
    @Override
    protected int getLayout() {
        return R.layout.fragment_author;
    }

    @Override
    protected void initView() {
        mListView = findView(R.id.all_author_list);
        mAdapter = new AllAuthorAdapter(getContext());

    }

    @Override
    protected void initDate() {
        NetTool.getInstance().startRequest(allAuthorUrl, AllAuthorEntity.class, new onHttpCallBack<AllAuthorEntity>() {
            @Override
            public void onSuccess(AllAuthorEntity response) {
                mAdapter.setAllAuthorEntity(response);
                mListView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
