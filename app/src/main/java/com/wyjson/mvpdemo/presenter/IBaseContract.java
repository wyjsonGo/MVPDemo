package com.wyjson.mvpdemo.presenter;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:11 PM
 */
public interface IBaseContract {

    interface IBasePresenter<T> {
        void onAttach(T view);

        void onDetach();

        T getView();
    }

    interface IBaseView {
        void showLoading();

        void hideLoading();
    }
}
