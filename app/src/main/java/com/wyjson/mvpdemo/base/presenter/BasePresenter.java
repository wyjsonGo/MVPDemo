package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.ParameterizedType;

public class BasePresenter<V extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<V> {

    protected LifecycleOwner lifecycleOwner;
    private Reference<V> viewReference;

    @Override
    public void onAttach(LifecycleOwner lifecycleOwner, V view) {
        this.lifecycleOwner = lifecycleOwner;
        viewReference = new SoftReference<>(view);
    }

    @Override
    public void onDetach() {
        lifecycleOwner = null;
        if (viewReference != null && viewReference.get() != null) {
            viewReference.clear();
            viewReference = null;
        }
    }

    @Override
    public V getView() {
        if (viewReference != null) {
            V mView = viewReference.get();
            if (mView != null)
                return mView;
        }
        return null;
    }

    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
