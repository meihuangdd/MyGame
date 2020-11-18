package com.goldze.mvvmhabit.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentDetailBinding;
import com.goldze.mvvmhabit.entity.DemoEntity;
import com.goldze.mvvmhabit.model.test.DetailViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailViewModel> {
    private DemoEntity.ItemsEntity entity;
    @Override
    public void initParam() {
        //获取列表传入的实体
        Bundle bundle = getArguments();
        if(bundle != null){
            entity = bundle.getParcelable("entity");
        }
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_detail;
    }

    @Override
    public int initVariableId() {
        return BR.detailViewModel;
    }

    @Override
    public void initData() {
        if(entity != null){
            binding.tvId.setText(String.valueOf(entity.getId()));
            binding.tvName.setText(entity.getName());
            binding.tvImg.setText(entity.getImg());
            binding.tvTime.setText(entity.getPubDate());
        }
    }
}
