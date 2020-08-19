package com.goldze.mvvmhabit.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentNetworkBinding;
import com.goldze.mvvmhabit.model.test.NetworkViewModel;

import me.goldze.mvvmhabit.base.BaseFragment;

public class NetWorkFragment extends BaseFragment<FragmentNetworkBinding, NetworkViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_network;
    }

    @Override
    public int initVariableId() {
        return BR.networkModel;
    }
}
