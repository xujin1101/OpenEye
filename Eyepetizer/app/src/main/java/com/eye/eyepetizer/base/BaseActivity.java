package com.eye.eyepetizer.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/8/30.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initDate();
    }

    /**
     * 绑定布局
     * @return 绑定的布局
     */
    protected abstract int getLayout();

    /**
     * 初始化组件
     */
    protected abstract void initView();

    /**
     * 初始化数据的ff
     */
    protected abstract void initDate();

    /**
     * 绑定控件id
     * @param id 控件的id
     * @param <T> 控件的类型
     * @return
     */
    protected  <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 跳转的activity
     * @param from 本类
     * @param to 目标
     */
    protected void gotoActivity(Context from, Class<? extends BaseActivity> to) {
        Intent intent = new Intent(from, to);
        startActivity(intent);
    }
    /**
     * 重载该方法
     * 带bundle值参数的跳转
     *
     * @param from   本类中
     * @param to     目标Activity
     * @param bundle 传的值
     */
    protected void goToActivity(Context from, Class<? extends BaseActivity> to, Bundle bundle) {
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
