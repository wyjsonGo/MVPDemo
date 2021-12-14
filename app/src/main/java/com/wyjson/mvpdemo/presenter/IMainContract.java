package com.wyjson.mvpdemo.presenter;

import android.content.Context;

import com.wyjson.mvpdemo.entity.UserEntity;


/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:00 PM
 */
public interface IMainContract extends IBaseContract {

    interface IView extends IBaseView {
        void loadingDataApiSuccess(UserEntity userEntity);

        void loadingDataApiFailed(int statusCode);
    }

    interface IPresenter<T> extends IBasePresenter<T> {
        void loadingDataApi(Context context, int page);
    }
}
