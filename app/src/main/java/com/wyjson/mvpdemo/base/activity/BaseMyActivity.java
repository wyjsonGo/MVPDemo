package com.wyjson.mvpdemo.base.activity;

import android.app.ProgressDialog;

import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.base.presenter.BasePresenter;
import com.wyjson.mvpdemo.utils.ProgressDialogHelper;

/**
 * 这里实现ActionBar等一些通用控件
 *
 * @param <VB>
 * @param <P>
 */
public class BaseMyActivity<VB extends ViewBinding, P extends BasePresenter> extends BasePActivity<VB, P> {

    protected ProgressDialog progressDialog;

    @Override
    public void showLoading() {
        if (progressDialog != null && progressDialog.isShowing())
            hideLoading();
        progressDialog = ProgressDialogHelper.showLoading(this);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        hideLoading();
        super.onDestroy();
    }
}
