package com.eye.eyepetizer.my.mymessage;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseActivity;
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
 * 作者：TheTopKing_杨燚 on 16/9/1 10:47
 * 这周日你有空吗
 */
public class MyMessageActivity extends BaseActivity {
    private ListView mListView;
    private MyMessageBean mMessageBean;
    private MyMessageAdapter mMessageAdapter;
    private ImageView returnImg;
    String url = "http://baobab.wandoujia.com/api/v3/messages?udid=cd1ee9c5b44e4f9487a505a4fe31ddcb07441cc8&vc=121&vn=2.3.5&deviceModel=MI%205&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23";
    @Override
    protected int getLayout() {
        return R.layout.activity_my_message;
    }

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        returnImg = (ImageView) findViewById(R.id.return_img);

        returnImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initDate() {
        mMessageAdapter = new MyMessageAdapter(this);
        NetTool();

    }

    private void NetTool() {
        NetTool.getInstance().startRequest(url, MyMessageBean.class, new onHttpCallBack<MyMessageBean>() {
            @Override
            public void onSuccess(MyMessageBean response) {
                mMessageAdapter.setBean(response);
                mListView.setAdapter(mMessageAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}