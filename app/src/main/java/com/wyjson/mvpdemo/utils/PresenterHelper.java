package com.wyjson.mvpdemo.utils;

import com.wyjson.mvpdemo.base.presenter.VoidPresenter;

import java.lang.reflect.ParameterizedType;

public class PresenterHelper {

    public static <T> T getT(Object o, int i) {
        try {
            Class<T> aClass = (Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i];
            if (aClass != VoidPresenter.class)
                return aClass.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
