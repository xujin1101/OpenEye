package com.eye.eyepetizer.discover.glideview.share;

import android.content.Intent;
import android.widget.ListView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.discover.glideview.time.GlideViewFragmentTimeBean;
import com.eye.eyepetizer.discover.glideview.time.GlideViewNextFragmentTimeAdapter;
import com.eye.eyepetizer.okHttp.NetTool;
import com.eye.eyepetizer.okHttp.onHttpCallBack;

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
 * 作者：TheTopKing_杨燚 on 16/9/3 10:26
 * 这周日你有空吗
 */
public class GlideViewNextShareFragment extends BaseFragment {
    private ListView mListView;
    private GlideViewNextFragmentTimeAdapter mAdapter;
    private GlideViewFragmentTimeBean mBean;

    private  String url;
    private String headUrl = "http://baobab.wandoujia.com/api/v3/videos?categoryId=";
    private String endUrl = "&strategy=shareCount&udid=cd1ee9c5b44e4f9487a505a4fe31ddc\" +\n" +
            "            \"b07441cc8&vc=121&vn=2.3.5&deviceModel=MI%205&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23";
    @Override
    protected int getLayout() {
        return R.layout.activity_discover_top_listview;
    }

    @Override
    protected void initView() {
        mListView = findView(R.id.list_view);

    }

    @Override
    protected void initDate() {
        mAdapter = new GlideViewNextFragmentTimeAdapter(context);
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id", 0);
        url = headUrl + id + endUrl;
        NetTool.getInstance().startRequest(url, GlideViewFragmentTimeBean.class, new onHttpCallBack<GlideViewFragmentTimeBean>() {
            @Override
            public void onSuccess(GlideViewFragmentTimeBean response) {
                mAdapter.setBean(response);
                mListView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
