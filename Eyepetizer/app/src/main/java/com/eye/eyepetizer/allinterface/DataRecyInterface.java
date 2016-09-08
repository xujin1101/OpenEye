package com.eye.eyepetizer.allinterface;

/**
 * Created by dllo on 16/9/3.
 */
public interface DataRecyInterface {
    //这里边定义不同的接口,是为了区分不同点击事件所触发的效果
    //interface是abstract关键词的进一步强化,不同的类可以实现同一个接口
    //可以规范回调

    void DataRecyOnClick(int position);

}
