package com.wyjson.mvpdemo.voids.activity;

import android.os.Bundle;

import com.wyjson.mvpdemo.base.activity.BaseMyActivity;
import com.wyjson.mvpdemo.base.presenter.VoidPresenter;
import com.wyjson.mvpdemo.databinding.ActivityVoidBinding;

/**
 * 这个Activity演示Null Presenter
 */
public class VoidActivity extends BaseMyActivity<ActivityVoidBinding, VoidPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}