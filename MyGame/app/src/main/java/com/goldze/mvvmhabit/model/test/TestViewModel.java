package com.goldze.mvvmhabit.model.test;

import android.app.Application;
import android.support.annotation.NonNull;
import android.view.View;

import com.goldze.mvvmhabit.ui.test.NetWorkFragment;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class TestViewModel extends BaseViewModel {
    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    public View.OnClickListener netWorkClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           startContainerActivity(NetWorkFragment.class.getCanonicalName());
        }
    };
}
