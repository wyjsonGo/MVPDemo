package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:11 PM
 */
public interface IBaseContract {

    interface IBasePresenter<V> {
        void onAttach(LifecycleOwner lifecycleOwner, V view);

        void onDetach();

        V getView();
    }

    interface IBaseView {
        void showLoading();

        void hideLoading();
    }
}
