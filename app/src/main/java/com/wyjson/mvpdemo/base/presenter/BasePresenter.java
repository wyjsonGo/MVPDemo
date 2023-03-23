package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<V> {

    protected LifecycleOwner lifecycleOwner;
    private WeakReference<V> viewWeakReference;

    @Override
    public void onAttach(LifecycleOwner lifecycleOwner, V view) {
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
    public V getView() {
        if (viewWeakReference != null) {
            V mView = viewWeakReference.get();
            if (mView != null)
                return mView;
        }
        return null;
    }

}
