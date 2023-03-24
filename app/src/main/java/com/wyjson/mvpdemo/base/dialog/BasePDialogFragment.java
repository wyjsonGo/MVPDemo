package com.wyjson.mvpdemo.base.dialog;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;
import com.wyjson.mvpdemo.base.presenter.IBaseContract;
import com.wyjson.mvpdemo.utils.PresenterHelper;


/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 11:53 AM
 */
public class BasePDialogFragment<VB extends ViewBinding, P extends BasePresenter> extends BaseDialogFragment<VB> implements IBaseContract.IBaseView {

    public P mPresenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = PresenterHelper.getT(this, 1);
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

