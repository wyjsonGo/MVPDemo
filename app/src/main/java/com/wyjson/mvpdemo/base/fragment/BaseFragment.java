package com.wyjson.mvpdemo.base.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.base.presenter.IBaseContract;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 4:28 PM
 */
public abstract class BaseFragment<VB extends ViewBinding> extends Fragment implements IBaseContract.IBaseView {

    protected VB vb;

    protected abstract VB setViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vb = setViewBinding(inflater, container);
        if (vb != null) {
            return rootView = vb.getRoot();
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    ProgressDialog progressDialog;

    @Override
    public void showLoading() {
        progressDialog = ProgressDialog.show(getActivity(), null, "Loading...", false, false);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

}
