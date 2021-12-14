package com.wyjson.mvpdemo.presenter.impl;

import android.app.Activity;
import android.content.Context;

import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.presenter.IMainContract;

import java.util.Random;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:21 PM
 */
public class MainPresenter extends BasePresenter<IMainContract.IView> implements IMainContract.IPresenter<IMainContract.IView> {

    @Override
    public void loadingDataApi(Context context, int page) {
        mView.showLoading();
        // 模拟子线程网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.hideLoading();
                        if (new Random().nextBoolean()) {
                            mView.loadingDataApiSuccess(new UserEntity(25, "Wyjson"));
                        } else {
                            mView.loadingDataApiFailed(500);
                        }
                    }
                });
            }
        }).start();
    }
}
