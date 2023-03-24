package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

public interface BaseContract {

    interface BasePresenter<V> {
        void onAttach(LifecycleOwner lifecycleOwner, V view);

        void onDetach();

        V getView();
    }

    interface BaseView {
        void showLoading();

        void hideLoading();
    }
}
