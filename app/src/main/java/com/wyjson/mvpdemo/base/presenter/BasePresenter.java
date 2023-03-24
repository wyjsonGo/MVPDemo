package com.wyjson.mvpdemo.base.presenter;

import androidx.lifecycle.LifecycleOwner;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BasePresenter<V extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<V> {

    private LifecycleOwner lifecycleOwner;
    private Reference<V> viewReference;
    protected V mView;

    @Override
    public void onAttach(LifecycleOwner lifecycleOwner, V view) {
        this.lifecycleOwner = lifecycleOwner;
        viewReference = new SoftReference<>(view);
        // 动态代理解决在presenter里需要多处判断view==null的情况.
        this.mView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (viewReference == null || viewReference.get() == null) {
                    return null;
                }
                return method.invoke(viewReference.get(), args);
            }
        });
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
        return mView;
    }

    public LifecycleOwner getLifecycleOwner() {
        return lifecycleOwner;
    }

}
