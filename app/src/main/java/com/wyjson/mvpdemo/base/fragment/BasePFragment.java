package com.wyjson.mvpdemo.base.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;
import com.wyjson.mvpdemo.base.presenter.IBaseContract;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 4:32 PM
 */
public class BasePFragment<VB extends ViewBinding, P extends BasePresenter> extends BaseFragment<VB> implements IBaseContract.IBaseView {

    public P mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = BasePresenter.getT(this, 1);
        if (mPresenter != null)
            mPresenter.onAttach(this, this);
    }

    @Override
    public void onDestroy() {
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

