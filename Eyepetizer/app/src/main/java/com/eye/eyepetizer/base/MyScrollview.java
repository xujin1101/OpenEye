package com.eye.eyepetizer.base;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;

import android.widget.ScrollView;

import com.eye.eyepetizer.allinterface.OnScrollListener;

/**
 * Created by dllo on 16/9/5.
 */

/**
 * 定义此ScrollView是为了实现,当手指离开手机屏幕的时候,他仍能够向上滑动的效果.
 */
public class MyScrollview extends ScrollView{
    private OnScrollListener onScrollListener;
    private int lastScrolY;
    public MyScrollview(Context context) {
        super(context);
    }

    public MyScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    /**
     * 用户手指指离开MyScrollView的时候获取MyScrollView滚动的Y距离.
     * 然后回调给onScroll方法
     */
    private Handler handler = new Handler(new Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            int scrollY = MyScrollview.this.getScrollY();
            //此时的距离和记录下的距离不相等,在隔5毫秒给handler发送消息
            //每隔5ms发送消息,再执行同样的操作,打到循环,知道lastScrolY和scrollY相等.
            if (lastScrolY !=scrollY){
                lastScrolY = scrollY;
                handler.sendMessageDelayed(msg,5);
            }
            if (onScrollListener!=null){
                onScrollListener.onScroll(scrollY);
            }

            return false;
        }
    });

    /**
     *  重写onTouchEvent ,当用户的手在MyScroll上面的时候
     *  直接将MyScrollView 滑动的Y方向距离回调给onScroll方法中.当用户抬起手时
     *  MyScrollView 可能还在滑动,所以当用户抬起手,我们隔5毫秒给handler发送消息
     *  在handler中处理MyScrollView滑动的距离.
     * @param ev
     * @return
     */


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //回调接口,覆写里边的方法
        if (onScrollListener !=null){
            onScrollListener.onScroll(lastScrolY = this.getScrollY());
        }
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP:
                Message msg = new Message();
                //后面的20是触摸延迟时间.
                handler.sendMessageDelayed(msg,20);
        }
        return super.onTouchEvent(ev);
    }
}
