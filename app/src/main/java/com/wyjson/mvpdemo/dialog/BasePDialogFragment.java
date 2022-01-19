package com.wyjson.mvpdemo.dialog;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.presenter.impl.BasePresenter;


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
            mPresenter.attach(this, this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detach();
    }
}

