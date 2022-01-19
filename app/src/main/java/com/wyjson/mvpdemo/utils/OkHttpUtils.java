package com.wyjson.mvpdemo.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * @author Wyjson
 * @version 1
 * @date 2022/1/19 1:40 PM
 */
public class OkHttpUtils {

    public interface MyCallback {
        void onSuccess();
    }

    /**
     * 模拟网络请求
     *
     * @param sleepSecond
     * @param callback
     */
    public void enqueue(long sleepSecond, MyCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(sleepSecond * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (callback != null) {
                            callback.onSuccess();
                        }
                    }
                });
            }
        }).start();
    }
}
