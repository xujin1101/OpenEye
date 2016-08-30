package com.eye.eyepetizer.okHttp;

/**
 * Created by dllo on 16/8/30.
 */
public class NetTool implements NetInterface{
    private static NetTool ourInstance = new NetTool();
    private NetInterface mNetInterface;
    public static NetTool getInstance(){
        if (ourInstance==null){
            synchronized (NetTool.class){
                if (ourInstance==null){
                    ourInstance=new NetTool();
                }
            }
        }
        return ourInstance;
    }

    private NetTool(){
        mNetInterface = new OkHtttpUtil();
    }
    @Override
    public void startRequeset(String url, onHttpCallBack<String> callBack) {
        mNetInterface.startRequeset(url,callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, onHttpCallBack<T> callBack) {
        mNetInterface.startRequest(url,tClass,callBack);

    }
}
