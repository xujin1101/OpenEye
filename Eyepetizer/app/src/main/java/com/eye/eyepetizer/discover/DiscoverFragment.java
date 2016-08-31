package com.eye.eyepetizer.discover;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.okHttp.NetTool;
import com.eye.eyepetizer.okHttp.onHttpCallBack;
import com.youth.banner.Banner;
import com.youth.banner.Banner.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现Fragment
 */
public class DiscoverFragment extends BaseFragment implements OnClickListener{
    private ImageView imgMatch,imgFirst,imgSecond;
    private Banner mBanner;
    private List<String> bannerUrl;
    private GridView mGlideView;
    private DiscoverAdapter mDiscoverAdapter;


    String url = "http://baobab.wandoujia.com/api/v3/discovery?udid=cd1ee9c5b44e4f9487a505a4fe31ddcb07441cc8&vc=121&vn=2.3.5&deviceModel";
    @Override
    protected int getLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView() {
        imgMatch = findView(R.id.img_match);
        imgFirst = findView(R.id.img_first);
        imgSecond = findView(R.id.img_second);
        mBanner = findView(R.id.banner);
        mGlideView = findView(R.id.grid_view);
        //glideview 非置顶
        mGlideView.setFocusable(false);

        imgMatch.setOnClickListener(this);
        imgFirst.setOnClickListener(this);
        imgSecond.setOnClickListener(this);
    }

    @Override
    protected void initDate() {
        bannerUrl = new ArrayList<>();
        mDiscoverAdapter = new DiscoverAdapter(context);
        NetTool.getInstance().startRequest(url, DiscoverBean.class, new onHttpCallBack<DiscoverBean>() {
            @Override
            public void onSuccess(DiscoverBean response) {
                for (int i = 0; i < response.getItemList().get(0).getData().getItemList().size(); i++) {
                    bannerUrl.add(response.getItemList().get(0).getData().getItemList().get(i).getData().getImage());
                    //设置间隔
                    mBanner.setDelayTime(3000);
                    //添加图片
                    mBanner.setImages(bannerUrl);
                    //banner加点
                    mBanner.setBannerStyle(Banner.CIRCLE_INDICATOR);
                    //点居中
                    mBanner.setIndicatorGravity(Banner.CENTER);
                    mBanner.setOnBannerClickListener(new OnBannerClickListener() {
                        @Override
                        public void OnBannerClick(View view, int position) {
                            Toast.makeText(context, "点击了第"+position+"张", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


                String FirstImg = response.getItemList().get(1).getData().getImage();
                String SecondImg = response.getItemList().get(2).getData().getImage();
                String Match = response.getItemList().get(3).getData().getImage();
                Glide.with(getContext()).load(Match).into(imgMatch);
                Glide.with(getContext()).load(FirstImg).into(imgFirst);
                Glide.with(getContext()).load(SecondImg).into(imgSecond);

                mDiscoverAdapter.setBean(response);
                mGlideView.setAdapter(mDiscoverAdapter);

                mGlideView.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(context, "点击了第" + position+"个", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_first:
                Toast.makeText(context, "点击了最受欢迎", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_second:
                Toast.makeText(context, "点击了热门专题", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_match:
                Toast.makeText(context, "点击了360°", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
