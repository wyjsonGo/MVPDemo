package com.wyjson.mvpdemo.two.activity;

import android.os.Bundle;

import com.wyjson.mvpdemo.base.activity.BasePActivity;
import com.wyjson.mvpdemo.databinding.ActivityTwoBinding;
import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.two.presenter.TwoContract;
import com.wyjson.mvpdemo.two.presenter.TwoPresenter;

public class TwoActivity extends BasePActivity<ActivityTwoBinding, TwoPresenter> implements TwoContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.findApi1(1);
        mPresenter.findApi2(1);
    }

    @Override
    public void onFindApiSuc(UserEntity userEntity) {
        vb.tvTest.setText("Success! ->" + userEntity.toString());
    }

    @Override
    public void onFindApiFail(int statusCode) {
        vb.tvTest.setText("Failed!");
    }
}