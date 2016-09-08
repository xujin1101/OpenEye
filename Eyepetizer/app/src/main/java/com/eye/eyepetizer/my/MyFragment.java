package com.eye.eyepetizer.my;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseFragment;
import com.eye.eyepetizer.my.mymessage.MyMessageActivity;

/**
 * 我的Fragment
 */
public class MyFragment extends BaseFragment implements OnClickListener{
    private TextView myMessage,myCollect;
    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        myMessage = findView(R.id.my_message);
        myCollect = findView(R.id.my_collect);

        myMessage.setOnClickListener(this);
        myCollect.setOnClickListener(this);
    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_message:
                Toast.makeText(context, "我的消息", Toast.LENGTH_SHORT).show();
                gotoActivity(context,MyMessageActivity.class);
                break;
            case R.id.my_collect:
                Toast.makeText(context, "我的收藏", Toast.LENGTH_SHORT).show();
                gotoActivity(context,MyCollectActivity.class);
        }
    }
}
