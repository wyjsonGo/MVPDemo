package com.wyjson.mvpdemo.main.presenter;

import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;

public interface IMainContract extends IBaseContract {

    interface IPresenter<V> extends IBasePresenter<V> {
        void loadingDataApi(int page);
    }

    interface IView extends IBaseView {
        void loadingDataApiSuccess(UserEntity userEntity);

        void loadingDataApiFailed(int statusCode);
    }
}
