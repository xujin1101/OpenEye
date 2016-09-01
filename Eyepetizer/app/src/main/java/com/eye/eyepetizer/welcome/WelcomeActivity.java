package com.eye.eyepetizer.welcome;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eye.eyepetizer.MainActivity;
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
 * 作者：TheTopKing_杨燚 on 16/9/1 16:40
 * 这周日你有空吗
 */
public class WelcomeActivity extends BaseActivity {
    private TextView timeText, welcomeText;
    private ImageView welcomeImg;
    private String url = "http://baobab.wandoujia.com/api/v2/configs?model=Android&udid=cd1ee9c5b44e4f9487a505a4fe31ddcb07441cc8&vc=121&vn=2.3.5&deviceModel=MI%205&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23";

    @Override
    protected int getLayout() {

        return R.layout.activity_welcome;

    }

    @Override
    protected void initView() {
        timeText = (TextView) findViewById(R.id.time_text);
        welcomeText = (TextView) findViewById(R.id.welcome_text);
        welcomeImg = (ImageView) findViewById(R.id.welcome_img);
    }

    @Override
    protected void initDate() {
        welcomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();//在跳转的时候 取消timer
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });

        net();
    }

    private void net() {
        NetTool.getInstance().startRequest(url, WelcomeBean.class, new onHttpCallBack<WelcomeBean>() {
            @Override
            public void onSuccess(WelcomeBean response) {
                String imgUrl = response.getStartPageAd().getImageUrl();
                Glide.with(getApplicationContext()).load(imgUrl).into(welcomeImg);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        timer.start();
    }

    //跳转设置跳转时间
    CountDownTimer timer = new CountDownTimer(4000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            timeText.setText(millisUntilFinished / 1000 + "");
        }

        @Override
        public void onFinish() {
            welcomeText.setText("欢迎");
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }
    }.start();
}
