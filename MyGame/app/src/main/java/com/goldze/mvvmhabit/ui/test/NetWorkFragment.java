package com.goldze.mvvmhabit.ui.test;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentNetworkBinding;
import com.goldze.mvvmhabit.model.test.NetWorkViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class NetWorkFragment extends BaseFragment<FragmentNetworkBinding, NetWorkViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_network;
    }

    @Override
    public int initVariableId() {
        return BR.networkModel;
    }

    @Override
    public NetWorkViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());

        return ViewModelProviders.of(this,factory).get(NetWorkViewModel.class);
    }

    @Override
    public void initData() {
        binding.setAdapter(new BindingRecyclerViewAdapter());
        viewModel.requestNetWork();
    }

    @Override
    public void initViewObservable() {
        viewModel.uc.finishRefreshing.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                binding.twinklingRefreshLayout.finishRefreshing();
            }
        });
        viewModel.uc.finishLoadmore.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                binding.twinklingRefreshLayout.finishLoadmore();
            }
        });
    }
}
