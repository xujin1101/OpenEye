package com.eye.eyepetizer.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dllo on 16/8/30.
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    /**
     * 绑定布局
     *
     * @return 绑定布局的id
     */
    protected abstract int getLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    /**
     * 初始化数据的方法
     */
    protected abstract void initDate();

    /**
     * 初始化控件
     *
     * @param id       控件的id
     * @param <T>控件的类型
     * @return
     */
    protected <T extends View> T findView(int id) {
        return (T) getView().findViewById(id);
    }

    /**
     * 跳转的activity
     *
     * @param from 本类
     * @param to   目标
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
