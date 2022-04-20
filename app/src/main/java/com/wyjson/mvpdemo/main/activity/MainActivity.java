package com.wyjson.mvpdemo.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wyjson.mvpdemo.R;
import com.wyjson.mvpdemo.two.activity.TwoActivity;
import com.wyjson.mvpdemo.base.activity.BasePActivity;
import com.wyjson.mvpdemo.databinding.ActivityMainBinding;
import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.lifecycle.MyLifecycleObserver;
import com.wyjson.mvpdemo.main.presenter.IMainContract;
import com.wyjson.mvpdemo.main.presenter.MainPresenter;

public class MainActivity extends BasePActivity<MainPresenter, ActivityMainBinding> implements View.OnClickListener, IMainContract.IView {

    @Override
    public MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    public ActivityMainBinding setViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getLifecycle().addObserver(new MyLifecycleObserver());
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_test) {
            mPresenter.loadingDataApi(1);
        } else if (v.getId() == R.id.btn_open) {
            startActivity(new Intent(this, TwoActivity.class));
        }
    }

    @Override
    public void loadingDataApiSuccess(UserEntity userEntity) {
        vb.btnTest.setText("Success! ->" + userEntity.toString());
    }

    @Override
    public void loadingDataApiFailed(int statusCode) {
        vb.btnTest.setText("Failed!");
    }
}