package com.wyjson.mvpdemo.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;

import com.wyjson.mvpdemo.utils.ViewBindingHelper;

class BaseActivity<VB extends ViewBinding> extends FragmentActivity {

    protected VB vb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vb = ViewBindingHelper.onCreateViewBinding(this, getLayoutInflater());
        if (vb != null) {
            setContentView(vb.getRoot());
        }
    }
}
