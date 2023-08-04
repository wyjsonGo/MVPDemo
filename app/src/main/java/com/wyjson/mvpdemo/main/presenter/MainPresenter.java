package com.wyjson.mvpdemo.main.presenter;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;
import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.utils.OkHttpUtils;

import java.util.Random;

public class MainPresenter extends BasePresenter<MainContract.IView> implements MainContract.IPresenter<MainContract.IView> {

    @Override
    public void loadingData(int page) {
        getView().showLoading();
        new OkHttpUtils().enqueue(getLifecycleOwner(), 1, new OkHttpUtils.MyCallback() {
            @Override
            public void onSuccess() {
                getView().hideLoading();
                if (new Random().nextBoolean()) {
                    getView().onLoadingDataSuc(new UserEntity(25, "Wyjson"));
                } else {
                    getView().onLoadingDataFail(500);
                }
            }
        });
    }
}
