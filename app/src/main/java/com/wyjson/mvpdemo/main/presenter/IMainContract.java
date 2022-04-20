package com.wyjson.mvpdemo.main.presenter;

import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;


/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:00 PM
 */
public interface IMainContract extends IBaseContract {

    interface IPresenter<T> extends IBasePresenter<T> {
        void loadingDataApi(int page);
    }

    interface IView extends IBaseView {
        void loadingDataApiSuccess(UserEntity userEntity);

        void loadingDataApiFailed(int statusCode);
    }
}
