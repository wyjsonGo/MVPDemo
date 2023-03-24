package com.wyjson.mvpdemo.two.presenter;

import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;

public interface ITwoContract extends IBaseContract {

    interface IPresenter<V> extends IBasePresenter<V> {
        void findApi1(int page);

        void findApi2(int page);
    }

    interface IView extends IBaseView {
        void findApiSuccess(UserEntity userEntity);

        void findApiFailed(int statusCode);
    }
}
