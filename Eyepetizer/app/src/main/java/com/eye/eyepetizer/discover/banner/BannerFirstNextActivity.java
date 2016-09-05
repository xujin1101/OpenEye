package com.eye.eyepetizer.discover.banner;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.eye.eyepetizer.R;
import com.eye.eyepetizer.base.BaseActivity;

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
 * <p/>
 * <p/>
 * 作者：TheTopKing_杨燚 on 16/9/5 15:36
 * 这周日你有空吗
 */
public class BannerFirstNextActivity extends BaseActivity {
    private WebView mWebView;
    private TextView titleText;
    private ImageView returnImg;
    String url;
    @Override
    protected int getLayout() {
        return R.layout.banner_first_next;
    }

    @Override
    protected void initView() {
        mWebView = (WebView) findViewById(R.id.web_view);
        titleText = (TextView) findViewById(R.id.title_text);
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
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        titleText.setText(intent.getStringExtra("text"));
        Log.d("uu", url);
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
