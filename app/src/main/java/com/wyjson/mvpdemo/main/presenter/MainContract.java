package com.wyjson.mvpdemo.main.presenter;

import com.wyjson.mvpdemo.base.presenter.BaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;

public interface MainContract extends BaseContract {

    interface Presenter<V> extends BasePresenter<V> {
        void loadingData(int page);
    }

    interface View extends BaseView {
        void onLoadingDataSuc(UserEntity userEntity);

        void onLoadingDataFail(int statusCode);
    }
}
