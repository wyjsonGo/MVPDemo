package com.wyjson.mvpdemo.presenter.impl;

import androidx.lifecycle.LifecycleOwner;

import com.wyjson.mvpdemo.presenter.IBaseContract;

public class BasePresenter<T extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<T> {

    protected LifecycleOwner lifecycleOwner;
    protected T mView;

    @Override
    public void attach(LifecycleOwner lifecycleOwner, T view) {
        this.lifecycleOwner = lifecycleOwner;
        this.mView = view;
    }

    @Override
    public void detach() {
        this.lifecycleOwner = null;
        this.mView = null;
    }

}
