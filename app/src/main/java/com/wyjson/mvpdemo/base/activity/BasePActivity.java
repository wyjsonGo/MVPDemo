package com.wyjson.mvpdemo.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;
import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.utils.PresenterHelper;

/**
 * Presenter
 *
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 3:47 PM
 */
public class BasePActivity<VB extends ViewBinding, P extends BasePresenter> extends BaseActivity<VB> implements IBaseContract.IBaseView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = PresenterHelper.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.onAttach(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDetach();
            mPresenter = null;
        }
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }
}
