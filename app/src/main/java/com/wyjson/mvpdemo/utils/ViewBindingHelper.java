package com.wyjson.mvpdemo.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public class ViewBindingHelper {

    public static <VB extends ViewBinding> VB onCreateViewBinding(Object o, LayoutInflater layoutInflater) {
        return onCreateViewBinding(o, layoutInflater, null, false);
    }

    public static <VB extends ViewBinding> VB onCreateViewBinding(Object o, LayoutInflater layoutInflater, ViewGroup viewGroup, boolean attachToParent) {
        try {
            Class<VB> mVBClass = (Class<VB>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
            Method method = mVBClass.getMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            return (VB) method.invoke(null, layoutInflater, viewGroup, attachToParent);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
