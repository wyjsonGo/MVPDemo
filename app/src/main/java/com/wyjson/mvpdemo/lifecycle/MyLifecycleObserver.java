package com.wyjson.mvpdemo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 7:26 PM
 */
public class MyLifecycleObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.d("MyLifecycleObserver", "onResume");
    }

}
