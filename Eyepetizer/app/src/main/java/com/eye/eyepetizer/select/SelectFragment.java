package com.eye.eyepetizer.select;

import android.widget.ListView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.okHttp.NetTool;
import com.eye.eyepetizer.okHttp.onHttpCallBack;
import com.eye.eyepetizer.until.AllValues;

/**
 * 精选Fragment
 */
public class SelectFragment extends BaseFragment {
    private ListView mListView;
    private SelectAdapterLv mSelectAdapterLv;
    @Override
    protected int getLayout() {
        return R.layout.fragment_select;
    }

    @Override
    protected void initView() {
        mListView = findView(R.id.select_lv);
        mSelectAdapterLv = new SelectAdapterLv(context);
    }

    @Override
    protected void initDate() {
        NetTool.getInstance().startRequest(AllValues.SELECTION, SelectBean.class, new onHttpCallBack<SelectBean>() {
            @Override
            public void onSuccess(SelectBean response) {
                mSelectAdapterLv.setSelectBean(response);
                mListView.setAdapter(mSelectAdapterLv);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
