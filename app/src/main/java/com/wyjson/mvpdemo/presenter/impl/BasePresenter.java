package com.wyjson.mvpdemo.presenter.impl;

import com.wyjson.mvpdemo.presenter.IBaseContract;

public class BasePresenter<T extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

}
