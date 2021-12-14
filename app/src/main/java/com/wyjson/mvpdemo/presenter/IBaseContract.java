package com.wyjson.mvpdemo.presenter;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:11 PM
 */
public interface IBaseContract {

    interface IBasePresenter<T> {
        void attachView(T view);

        void detachView();
    }

    interface IBaseView {
        void showLoading();

        void hideLoading();
    }
}
