package com.goldze.mvvmhabit.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.model.test.NetWorkViewModel;

public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @SuppressLint("StaticFieldLeak")
    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final DemoRepository mRepository;

    public static AppViewModelFactory getInstance(Application application){
        if(INSTANCE == null){
            synchronized (AppViewModelFactory.class){
                if(INSTANCE == null){
                    INSTANCE = new AppViewModelFactory(application,Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }
    public AppViewModelFactory(Application mApplication, DemoRepository mRepository) {
        this.mApplication = mApplication;
        this.mRepository = mRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(NetWorkViewModel.class)){
            return (T) new NetWorkViewModel(mApplication,mRepository);
        }
        return super.create(modelClass);
    }
}
