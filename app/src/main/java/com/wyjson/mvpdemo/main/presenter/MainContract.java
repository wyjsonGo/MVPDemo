package com.wyjson.mvpdemo.main.presenter;

import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;

public interface MainContract extends IBaseContract {

    interface IPresenter<V> extends IBasePresenter<V> {
        void loadingData(int page);
    }

    interface IView extends IBaseView {
        void onLoadingDataSuc(UserEntity userEntity);

        void onLoadingDataFail(int statusCode);
    }
}
