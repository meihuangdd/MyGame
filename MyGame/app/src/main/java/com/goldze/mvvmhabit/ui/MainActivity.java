package com.goldze.mvvmhabit.ui;

import android.os.Bundle;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.ActivityMainBinding;
import com.goldze.mvvmhabit.model.MainViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public  class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.mainModel;
    }
}
