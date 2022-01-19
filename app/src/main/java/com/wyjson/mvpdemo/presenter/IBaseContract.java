package com.wyjson.mvpdemo.presenter;

import androidx.lifecycle.LifecycleOwner;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:11 PM
 */
public interface IBaseContract {

    interface IBasePresenter<T> {
        void attach(LifecycleOwner lifecycleOwner, T view);

        void detach();
    }

    interface IBaseView {
        void showLoading();

        void hideLoading();
    }
}
