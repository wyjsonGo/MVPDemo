package com.wyjson.mvpdemo.two.activity;

import android.os.Bundle;

import com.wyjson.mvpdemo.base.activity.BasePActivity;
import com.wyjson.mvpdemo.databinding.ActivityTwoBinding;
import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.two.presenter.ITwoContract;
import com.wyjson.mvpdemo.two.presenter.TwoPresenter;

public class TwoActivity extends BasePActivity<TwoPresenter, ActivityTwoBinding> implements ITwoContract.IView {

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