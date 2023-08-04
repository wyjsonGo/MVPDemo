package com.wyjson.mvpdemo.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.StringRes;

import com.wyjson.mvpdemo.R;

public class ProgressDialogHelper {

    public static ProgressDialog showLoading(Context context) {
        return showLoading(context, -1, null);
    }

    public static ProgressDialog showLoading(Context context, @StringRes int resId) {
        return showLoading(context, resId, null);
    }

    public static ProgressDialog showLoading(Context context, DialogInterface.OnCancelListener onCancelListener) {
        return showLoading(context, -1, onCancelListener);
    }

    public static ProgressDialog showLoading(Context context, @StringRes int resId, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialog progressDialog = ProgressDialog.show(context, null, context.getString(resId != -1 ? resId : R.string.progress_dialog_loading), false, true, onCancelListener);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

}
