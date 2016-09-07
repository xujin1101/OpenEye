package com.eye.eyepetizer.okHttp;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/8/30.
 */
public class OkHtttpUtil implements NetInterface {
    private OkHttpClient mClient;
    private Gson mGson;
    //此Handler 创建出的对象,属于主线程
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public OkHtttpUtil() {
        mGson = new Gson();
        File path = Environment.getExternalStorageDirectory();
        //设置缓存位置和大小
        mClient = new OkHttpClient.Builder()
                .cache(new Cache(path, 10 * 1024 * 1024))
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public void startRequeset(String url, final onHttpCallBack<String> callBack) {
        Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });

    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final onHttpCallBack<T> callBack) {
        final Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.d("OkHtttpUtil", str);
                T result;
                try {

                    result = mGson.fromJson(str, tClass);
                    mHandler.post(new MyRunnable<T>(result) {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });
                }catch (Exception e){
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onError(new Throwable("解析不出来"));
                        }
                    });
                }

            }
        });

    }

    abstract class MyRunnable<T> implements Runnable{
        T result;

        public MyRunnable(T result) {
            this.result = result;
        }
    }
}
