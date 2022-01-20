package com.wyjson.mvpdemo.presenter.impl;

import androidx.lifecycle.LifecycleOwner;

import com.wyjson.mvpdemo.presenter.IBaseContract;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<T> {

    protected LifecycleOwner lifecycleOwner;
    private WeakReference<T> weakReference;

    @Override
    public void onAttach(LifecycleOwner lifecycleOwner, T view) {
        this.lifecycleOwner = lifecycleOwner;
        weakReference = new WeakReference<>(view);
    }

    @Override
    public void onDetach() {
        lifecycleOwner.getLifecycle().removeObserver(null);
        lifecycleOwner = null;
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
