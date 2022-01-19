package com.wyjson.mvpdemo.presenter.impl;

import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.presenter.ITwoContract;
import com.wyjson.mvpdemo.utils.OkHttpUtils;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:21 PM
 */
public class TwoPresenter extends BasePresenter<ITwoContract.IView> implements ITwoContract.IPresenter<ITwoContract.IView> {

    @Override
    public void findApi1(int page) {
        new OkHttpUtils().enqueue(2, new OkHttpUtils.MyCallback() {
            @Override
            public void onSuccess() {
                if (getView() == null)
                    return;
                getView().findApiSuccess(new UserEntity(1, "Wyjson Two 1"));
            }
        });
    }

    @Override
    public void findApi2(int page) {
        new OkHttpUtils().enqueue(4, new OkHttpUtils.MyCallback() {
            @Override
            public void onSuccess() {
                if (getView() == null)
                    return;
                getView().findApiSuccess(new UserEntity(2, "Wyjson Two 2"));
            }
        });
    }
}
