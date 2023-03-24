package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

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
