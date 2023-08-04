package com.wyjson.mvpdemo.base.dialog;

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
public class BaseMyDialogFragment<VB extends ViewBinding, P extends BasePresenter> extends BasePDialogFragment<VB, P> {

    protected ProgressDialog progressDialog;

    @Override
    public void showLoading() {
        if (progressDialog != null && progressDialog.isShowing())
            hideLoading();
        progressDialog = ProgressDialogHelper.showLoading(getContext());
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void onDestroyView() {
        hideLoading();
        super.onDestroyView();
    }

}
