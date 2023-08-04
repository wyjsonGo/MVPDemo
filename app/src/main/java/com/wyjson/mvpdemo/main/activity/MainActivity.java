package com.wyjson.mvpdemo.main.activity;

import android.content.Intent;
import android.view.View;

import com.wyjson.mvpdemo.R;
import com.wyjson.mvpdemo.base.activity.BaseMyActivity;
import com.wyjson.mvpdemo.databinding.ActivityMainBinding;
import com.wyjson.mvpdemo.entity.UserEntity;
import com.wyjson.mvpdemo.main.presenter.MainContract;
import com.wyjson.mvpdemo.main.presenter.MainPresenter;
import com.wyjson.mvpdemo.two.activity.TwoActivity;
import com.wyjson.mvpdemo.voids.activity.VoidActivity;

public class MainActivity extends BaseMyActivity<ActivityMainBinding, MainPresenter> implements View.OnClickListener, MainContract.IView {

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_test) {
            mPresenter.loadingData(1);
        } else if (v.getId() == R.id.btn_open) {
            startActivity(new Intent(this, TwoActivity.class));
        } else if (v.getId() == R.id.btn_void) {
            startActivity(new Intent(this, VoidActivity.class));
        }
    }

    @Override
    public void onLoadingDataSuc(UserEntity userEntity) {
        vb.btnTest.setText("Success! ->" + userEntity.toString());
    }

    @Override
    public void onLoadingDataFail(int statusCode) {
        vb.btnTest.setText("Failed!");
    }
}