package com.wyjson.mvpdemo.two.presenter;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;
import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.utils.OkHttpUtils;

public class TwoPresenter extends BasePresenter<ITwoContract.IView> implements ITwoContract.IPresenter<ITwoContract.IView> {

    @Override
    public void findApi1(int page) {
        new OkHttpUtils().enqueue(getLifecycleOwner(), 2, new OkHttpUtils.MyCallback() {
            @Override
            public void onSuccess() {
                getView().findApiSuccess(new UserEntity(1, "Wyjson Two 1"));
            }
        });
    }

    @Override
    public void findApi2(int page) {
        new OkHttpUtils().enqueue(getLifecycleOwner(), 4, new OkHttpUtils.MyCallback() {
            @Override
            public void onSuccess() {
                getView().findApiSuccess(new UserEntity(2, "Wyjson Two 2"));
            }
        });
    }
}
