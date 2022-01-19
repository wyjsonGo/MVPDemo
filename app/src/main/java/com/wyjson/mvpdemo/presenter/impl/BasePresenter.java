package com.wyjson.mvpdemo.presenter.impl;

import com.wyjson.mvpdemo.presenter.IBaseContract;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<T> {

    private WeakReference<T> weakReference;

    @Override
    public void onAttach(T view) {
        weakReference = new WeakReference<>(view);
    }

    @Override
    public void onDetach() {
        if (weakReference != null && weakReference.get() != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    @Override
    public T getView() {
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        return null;
    }

}
