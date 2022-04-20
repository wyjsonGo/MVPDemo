package com.wyjson.mvpdemo.two.presenter;

import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.entity.UserEntity;


/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 2:00 PM
 */
public interface ITwoContract extends IBaseContract {

    interface IPresenter<T> extends IBasePresenter<T> {
        void findApi1(int page);

        void findApi2(int page);
    }

    interface IView extends IBaseView {
        void findApiSuccess(UserEntity userEntity);

        void findApiFailed(int statusCode);
    }
}
