package com.goldze.mvvmhabit.model.test;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.entity.DemoEntity;

import java.util.Observable;

import me.goldze.mvvmhabit.base.BaseViewModel;

public class DetailViewModel extends BaseViewModel {
    public ObservableField<DemoEntity.ItemsEntity> entity = new ObservableField<>();
    public DetailViewModel(@NonNull Application application) {
        super(application);
    }
    public void setDemoEntity(DemoEntity.ItemsEntity entity){
        this.entity.set(entity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        entity = null;
    }
}
