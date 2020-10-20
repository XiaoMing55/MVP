package com.alibaba.lib_core.mvp.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.lib_core.mvp.presenter.IPresenter;
import com.alibaba.lib_core.mvp.view.view.IView;

public  abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView,IActivity {

    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getReslayout());
        initView();
        initData();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
