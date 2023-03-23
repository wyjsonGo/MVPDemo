package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<T> {

    protected LifecycleOwner lifecycleOwner;
    private WeakReference<T> viewWeakReference;

    @Override
    public void onAttach(LifecycleOwner lifecycleOwner, T view) {
        this.lifecycleOwner = lifecycleOwner;
        viewWeakReference = new WeakReference<>(view);
    }

    @Override
    public void onDetach() {
        lifecycleOwner = null;
        if (viewWeakReference != null && viewWeakReference.get() != null) {
            viewWeakReference.clear();
            viewWeakReference = null;
        }
    }

    @Override
    public T getView() {
        if (viewWeakReference != null) {
            T mView = viewWeakReference.get();
            if (mView != null)
                return mView;
        }
        return null;
    }

}
