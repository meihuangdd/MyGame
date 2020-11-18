package com.goldze.mvvmhabit.ui.snake;

import android.os.Bundle;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.ActivityStartBinding;
import com.goldze.mvvmhabit.model.StartViewModel;

import me.goldze.mvvmhabit.base.BaseActivity;

public class StartActivity extends BaseActivity<ActivityStartBinding, StartViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_start;
    }

    @Override
    public int initVariableId() {
        return BR.startViewModel;
    }
}
