package com.wyjson.mvpdemo.base.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.utils.ViewBindingHelper;

class BaseDialogFragment<VB extends ViewBinding> extends DialogFragment {

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
}
