package com.wyjson.mvpdemo.presenter.impl;

import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.presenter.IMainContract;
import com.wyjson.mvpdemo.utils.OkHttpUtils;

import java.util.Random;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:21 PM
 */
public class MainPresenter extends BasePresenter<IMainContract.IView> implements IMainContract.IPresenter<IMainContract.IView> {

    @Override
    public void loadingDataApi(int page) {
        getView().showLoading();
        new OkHttpUtils().enqueue(lifecycleOwner, 1, new OkHttpUtils.MyCallback() {
            @Override
            public void onSuccess() {
                getView().hideLoading();
                if (new Random().nextBoolean()) {
                    getView().loadingDataApiSuccess(new UserEntity(25, "Wyjson"));
                } else {
                    getView().loadingDataApiFailed(500);
                }

            }
        });
    }
}
