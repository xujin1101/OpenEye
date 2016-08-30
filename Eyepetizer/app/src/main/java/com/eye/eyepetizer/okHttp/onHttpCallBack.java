package com.eye.eyepetizer.okHttp;

/**
 * Created by dllo on 16/8/30.
 */

/**
 *
 * @param <T> 成功回调时的参数
 */
public interface onHttpCallBack<T> {
    void onSuccess(T response);
    void onError(Throwable e);
}
