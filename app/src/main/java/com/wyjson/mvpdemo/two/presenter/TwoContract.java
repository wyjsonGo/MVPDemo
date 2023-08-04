package com.wyjson.mvpdemo.two.presenter;

import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;

public interface TwoContract extends IBaseContract {

    interface Presenter<V> extends IBasePresenter<V> {
        void findApi1(int page);

        void findApi2(int page);
    }

    interface View extends IBaseView {
        void onFindApiSuc(UserEntity userEntity);

        void onFindApiFail(int statusCode);
    }
}
