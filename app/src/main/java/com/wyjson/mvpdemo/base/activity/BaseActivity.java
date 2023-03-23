package com.wyjson.mvpdemo.base.activity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;

/**
 * @author Wyjson
 * @version 1
 * @date 2021/9/22 11:53 AM
 */
public abstract class BaseActivity<VB extends ViewBinding> extends FragmentActivity {

    protected VB vb;

    protected abstract VB setViewBinding();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vb = setViewBinding();
        if (vb != null) {
            setContentView(vb.getRoot());
        }
    }

    ProgressDialog progressDialog;

    protected void showLoading() {
        progressDialog = ProgressDialog.show(this, null, "Loading...", false, false);
    }

    protected void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
    }
}
