package com.wyjson.mvpdemo.base.dialog;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;


/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 11:53 AM
 */
public abstract class BasePDialogFragment<P extends BasePresenter, VB extends ViewBinding> extends BaseDialogFragment<VB> {

    public P mPresenter;

    public abstract P setPresenter();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = setPresenter();
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
}

