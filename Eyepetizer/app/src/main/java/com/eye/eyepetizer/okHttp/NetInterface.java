package com.eye.eyepetizer.okHttp;

/**
 * Created by dllo on 16/8/30.
 */
public interface NetInterface {
    void startRequeset(String url, onHttpCallBack<String> callBack);
    <T> void startRequest(String url,Class<T> tClass,onHttpCallBack<T> callBack);

}
