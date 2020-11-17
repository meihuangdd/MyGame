package com.goldze.mvvmhabit.model.test;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.entity.DemoEntity;

import me.goldze.mvvmhabit.base.ItemViewModel;

public class NetWorkItemViewModel extends ItemViewModel<NetWorkViewModel> {
    public ObservableField<DemoEntity.ItemsEntity> entity = new ObservableField<>();
    public Drawable drawableImg;
    public NetWorkItemViewModel(@NonNull NetWorkViewModel viewModel,DemoEntity.ItemsEntity entity) {
        super(viewModel);
        this.entity.set(entity);
        //ImageView 的占位图片，可以解决RecyclerView中图片错误问题
        drawableImg = ContextCompat.getDrawable(viewModel.getApplication(), R.mipmap.ic_launcher);
    }
    /**
     * 获取position的方式有很多种，indexOf是其中一种，常见的还有在Adapter中，ItemBinding.of回调里
     *
     */
    public int getPosition(){
        return viewModel.getItemPosition(this);
    }

}
