package com.goldze.mvvmhabit.model;

import android.app.Application;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.ui.SnakeActivity;
import com.goldze.mvvmhabit.ui.test.TestFragment;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class MainViewModel extends BaseViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public View.OnClickListener test = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startContainerActivity(TestFragment.class.getCanonicalName());
        }
    };
    public View.OnClickListener snake = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(SnakeActivity.class);
        }
    };
}
