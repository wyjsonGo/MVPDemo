package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

public interface IBaseContract {

    interface IBasePresenter<V> {
        void onAttach(LifecycleOwner lo, V view);

        void onDetach();

        V getView();

        LifecycleOwner getLifecycleOwner();
    }

    interface IBaseView {
        void showLoading();

        void hideLoading();
    }
}
