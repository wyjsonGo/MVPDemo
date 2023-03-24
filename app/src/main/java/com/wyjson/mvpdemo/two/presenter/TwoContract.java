package com.wyjson.mvpdemo.two.presenter;

import com.wyjson.mvpdemo.base.presenter.BaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;

public interface TwoContract extends BaseContract {

    interface Presenter<V> extends BasePresenter<V> {
        void findApi1(int page);

        void findApi2(int page);
    }

    interface View extends BaseView {
        void onFindApiSuc(UserEntity userEntity);

        void onFindApiFail(int statusCode);
    }
}
