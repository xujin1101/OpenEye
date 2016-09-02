package com.eye.eyepetizer.author;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.executor.Prioritized;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.okHttp.NetTool;
import com.eye.eyepetizer.okHttp.onHttpCallBack;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import okhttp3.Callback;

/**
 * 作者Fragment
 */
public class AuthorFragment extends BaseFragment {
    private String allAuthorUrl = "http://baobab.wandoujia.com/api/v3/tabs/pgcs/more?start=10&num=85";
    private String headAuthorUrl = "http://baobab.wandoujia.com/api/v3/tabs/pgcs?";
    private AllAuthorAdapter mAdapter;
    private ListView mListView;
    private RecyclerView headRecycler;
    private AuthorListAdapter mAuthorListAdapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_author;
    }

    @Override
    protected void initView() {
        //头布局初始化.
        View viewHead = LayoutInflater.from(context).inflate(R.layout.fragment_author_head, null);
        headRecycler = (RecyclerView) viewHead.findViewById(R.id.head_recycler);
        mAuthorListAdapter = new AuthorListAdapter(context);


        mListView = findView(R.id.all_author_list);
        //listview添加头布局.
        mListView.addHeaderView(viewHead);
        mAdapter = new AllAuthorAdapter(getContext());

    }

    @Override
    protected void initDate() {
        //对全部作者进行数据解析
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

        //对头布局进行数据解析.
        NetTool.getInstance().startRequest(headAuthorUrl, HeadAuthorEntity.class, new onHttpCallBack<HeadAuthorEntity>() {
            @Override
            public void onSuccess(HeadAuthorEntity response) {
                mAuthorListAdapter.setAuthor(response);
                Log.d("AuthorFragment", "response:" + response);
                headRecycler.setAdapter(mAuthorListAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                headRecycler.setLayoutManager(manager);

            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }

}
