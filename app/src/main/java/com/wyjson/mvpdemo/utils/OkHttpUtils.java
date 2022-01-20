package com.wyjson.mvpdemo.utils;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

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
    public void enqueue(LifecycleOwner lifecycleOwner, long sleepSecond, MyCallback callback) {
        addLifecycleObserver(lifecycleOwner);
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
                        if (isContextDestroy) return;
                        removeLifecycleObserver(lifecycleOwner);
                        if (callback != null) {
                            callback.onSuccess();
                        }
                    }
                });
            }
        }).start();
    }

    private volatile boolean isContextDestroy;

    private final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() {
        @Override
        public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                isContextDestroy = true;
                // okhttp request cancel
//                call.cancel();
                source.getLifecycle().removeObserver(this);
                return;
            }
        }
    };

    private void addLifecycleObserver(final LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null)
            return;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
                }
            });
        }
    }

    private void removeLifecycleObserver(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null)
            return;
        lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
    }
}
