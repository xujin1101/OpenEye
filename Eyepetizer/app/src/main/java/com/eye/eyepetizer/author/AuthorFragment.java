package com.eye.eyepetizer.author;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.executor.Prioritized;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.allinterface.BriefOnClickListener;
import com.eye.eyepetizer.allinterface.VideoBriefOnClickListener;
import com.eye.eyepetizer.author.authorDetail.AuthorDetail;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.okHttp.NetTool;
import com.eye.eyepetizer.okHttp.onHttpCallBack;

import java.io.PipedReader;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import okhttp3.Callback;

/**
 * 作者Fragment
 */
public class AuthorFragment extends BaseFragment implements BriefOnClickListener,VideoBriefOnClickListener{
    private String allAuthorUrl = "http://baobab.wandoujia.com/api/v3/tabs/pgcs/more?start=10&num=85";
    private String headAuthorUrl = "http://baobab.wandoujia.com/api/v3/tabs/pgcs?";
    private AllAuthorAdapter mAdapter;
    private ListView mListView;
    private RecyclerView headRecycler;
    private AuthorListAdapter mAuthorListAdapter;
    private HeadAuthorEntity mHeadAuthorEntity;



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
        //这里先给接口进行赋值,相当于初始化,这里都是在头布局里边的.
        mAuthorListAdapter.setBriefOnClickListener(this);
        mAuthorListAdapter.setVideoBriefOnClickListener(this);
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
                mHeadAuthorEntity = response;
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

    @Override
    public void onClick(int position) {
        //
        if (mHeadAuthorEntity.getItemList().get(position).getType().equals("briefCard")){
            Log.d("ffffffffff", "mHeadAuthorEntity.getItemList().size():" + mHeadAuthorEntity.getItemList().size());
            //将解析出来的数据传到下个Fragment.
            Log.d("地点", "position:" + position);
            Bundle bundle = new Bundle();
            bundle.putInt("bcId",mHeadAuthorEntity.getItemList().get(position).getData().getId());
            bundle.putString("bcDescription",mHeadAuthorEntity.getItemList().get(position).getData().getDescription());
            Log.d("标题", mHeadAuthorEntity.getItemList().get(position).getData().getDescription());
            bundle.putString("bcTitle",mHeadAuthorEntity.getItemList().get(position).getData().getTitle());
            Log.d("描述", mHeadAuthorEntity.getItemList().get(position).getData().getTitle());
            bundle.putString("bcIcon",mHeadAuthorEntity.getItemList().get(position).getData().getIcon());
            goToActivity(context,AuthorDetail.class,bundle);
        }else if (mHeadAuthorEntity.getItemList().get(position).getType().equals("videoCollectionWithBrief")){
            Bundle bundle1 = new Bundle();
            bundle1.putInt("bcId",mHeadAuthorEntity.getItemList().get(position).getData().getId());
            bundle1.putString("bcDescription",mHeadAuthorEntity.getItemList().get(position).getData().getDescription());
            bundle1.putString("bcTitle",mHeadAuthorEntity.getItemList().get(position).getData().getTitle());
            bundle1.putString("bcIcon",mHeadAuthorEntity.getItemList().get(position).getData().getIcon());

            goToActivity(context,AuthorDetail.class,bundle1);

        }

    }
}
