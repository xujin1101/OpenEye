package com.eye.eyepetizer.author.authorDetail;

import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.okHttp.NetTool;
import com.eye.eyepetizer.okHttp.onHttpCallBack;

import java.io.PipedReader;

/**
 * Created by dllo on 16/9/6.
 */
public class TimeFragment extends BaseFragment{
    private ListView mListView;
    private String url = "http://baobab.wandoujia.com/api/v3/pgc/videos?pgcId=";
    private String endUrl = "&strategy=date&udid\" +\n" +
            "\"=cd1ee9c5b44e4f9487a505a4fe31ddcb07441cc8&vc=121&vn=\" + \"2.3.5&dev" +
            "iceModel=MI%205&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23";
    private TimeEntity datas;
    private TimeAdapter mTimeAdapter;
    @Override
    protected int getLayout() {
        return R.layout.fragment_author_time;
    }

    @Override
    protected void initView() {
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("bcId",0);
        Log.d("TimeFragment", "id:" + id);
        mListView = findView(R.id.time_listview);
        String allUrl = url +id +endUrl;
        datas = new TimeEntity();
        mTimeAdapter = new TimeAdapter(context);
        NetTool.getInstance().startRequest(allUrl, TimeEntity.class, new onHttpCallBack<TimeEntity>() {
            @Override
            public void onSuccess(TimeEntity response) {
                mTimeAdapter.setTimeBean(response);
                mListView.setAdapter(mTimeAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }

    @Override
    protected void initDate() {


    }
}
