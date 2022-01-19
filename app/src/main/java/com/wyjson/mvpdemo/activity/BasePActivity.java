package com.wyjson.mvpdemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.presenter.impl.BasePresenter;

/**
 * Presenter
 *
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 3:47 PM
 */
public abstract class BasePActivity<P extends BasePresenter, VB extends ViewBinding> extends BaseActivity<VB> {

    protected P mPresenter;

    protected abstract P setPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = setPresenter();
        if (mPresenter != null) {
            mPresenter.onAttach(this);
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
}
