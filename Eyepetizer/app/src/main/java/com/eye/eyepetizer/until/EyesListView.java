package com.eye.eyepetizer.until;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 自定义ListView 解决滑动冲突
 */
public class EyesListView extends ListView {
    public EyesListView(Context context) {
        super(context);
    }

    public EyesListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EyesListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
