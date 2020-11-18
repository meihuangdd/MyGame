package com.goldze.mvvmhabit.ui;

import android.os.Bundle;
import android.view.View;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.ActivitySnakeBinding;
import com.goldze.mvvmhabit.model.SnakeViewModel;
import com.goldze.mvvmhabit.ui.snake.StartActivity;

import me.goldze.mvvmhabit.base.BaseActivity;

public class SnakeActivity extends BaseActivity<ActivitySnakeBinding, SnakeViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_snake;
    }

    @Override
    public int initVariableId() {
        return BR.snakeViewModel;
    }

    @Override
    public void initData() {
        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.startActivity(StartActivity.class);
            }
        });
    }
}
