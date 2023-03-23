package com.wyjson.mvpdemo.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;
import com.wyjson.mvpdemo.base.presenter.IBaseContract;

/**
 * Presenter
 *
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 3:47 PM
 */
public abstract class BasePActivity<P extends BasePresenter, VB extends ViewBinding> extends BaseActivity<VB> implements IBaseContract.IBaseView {

    protected P mPresenter;

    protected abstract P setPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = setPresenter();
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
