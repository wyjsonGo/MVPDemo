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

import com.wyjson.mvpdemo.utils.ViewBindingHelper;

public class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected VB vb;

    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vb = ViewBindingHelper.onCreateViewBinding(this, inflater, container, false);
        if (vb != null) {
            return rootView = vb.getRoot();
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    protected ProgressDialog progressDialog;

    protected void showLoading() {
        if (progressDialog != null && progressDialog.isShowing())
            hideLoading();
        progressDialog = ProgressDialog.show(getActivity(), null, "Loading...", false, false);
    }

    protected void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }
}
