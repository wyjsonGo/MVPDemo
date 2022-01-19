package com.wyjson.mvpdemo.activity;

import android.os.Bundle;

import com.wyjson.mvpdemo.databinding.ActivityTwoBinding;
import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.presenter.ITwoContract;
import com.wyjson.mvpdemo.presenter.impl.TwoPresenter;

public class TwoActivity extends BasePActivity<TwoPresenter, ActivityTwoBinding> implements ITwoContract.IView {

    @Override
    public TwoPresenter setPresenter() {
        return new TwoPresenter();
    }

    @Override
    public ActivityTwoBinding setViewBinding() {
        return ActivityTwoBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.findApi1(1);
        mPresenter.findApi2(1);
    }

    @Override
    public void findApiSuccess(UserEntity userEntity) {
        vb.tvTest.setText("Success! ->" + userEntity.toString());
    }

    @Override
    public void findApiFailed(int statusCode) {
        vb.tvTest.setText("Failed!");
    }
}