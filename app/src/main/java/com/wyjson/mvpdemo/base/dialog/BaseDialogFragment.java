package com.wyjson.mvpdemo.base.dialog;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBinding;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 11:53 AM
 */
public abstract class BaseDialogFragment<VB extends ViewBinding> extends DialogFragment {

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

    protected void showLoading() {
        progressDialog = ProgressDialog.show(getActivity(), null, "Loading...", false, false);
    }

    protected void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }
}
