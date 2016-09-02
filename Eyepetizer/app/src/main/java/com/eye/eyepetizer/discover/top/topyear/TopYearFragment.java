package com.eye.eyepetizer.discover.top.topyear;

import android.widget.ListView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
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
 * 作者：TheTopKing_杨燚 on 16/9/2 09:49
 * 这周日你有空吗
 */
public class TopYearFragment extends BaseFragment {
    private ListView mListView;
    private TopYearBean mYearBean;
    private TopYearAdapter mYearAdapter;

    private String url = "http://baobab.wandoujia.com/api/v3/ranklist?num=10&strategy=historical&udid=08bd83e35ce74200b1ce8eae3cdf60ea5452b57b&vc=129&vn=2.5.1&deviceModel=Google%20Nexus%205%20-%204.4.4%20-%20API%2019%20-%201080x1920&first_channel=eyepetizer_baidu_market&last_channel=eyepetizer_baidu_market&system_version_code=19";
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
        mYearAdapter = new TopYearAdapter(context);
        NetTool.getInstance().startRequest(url, TopYearBean.class, new onHttpCallBack<TopYearBean>() {
            @Override
            public void onSuccess(TopYearBean response) {
                mYearAdapter.setBean(response);
                mListView.setAdapter(mYearAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
