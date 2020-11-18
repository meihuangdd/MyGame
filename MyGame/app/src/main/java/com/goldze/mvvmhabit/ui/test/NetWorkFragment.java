package com.goldze.mvvmhabit.ui.test;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.adapter.NetWorkAdapter;
import com.goldze.mvvmhabit.app.AppViewModelFactory;
import com.goldze.mvvmhabit.databinding.FragmentNetworkBinding;
import com.goldze.mvvmhabit.model.test.NetWorkViewModel;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;

public class NetWorkFragment extends BaseFragment<FragmentNetworkBinding, NetWorkViewModel> {
    private  NetWorkAdapter adapter;
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
        viewModel.requestNetWork();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.recNetWork.setLayoutManager(manager);
        adapter = new NetWorkAdapter(viewModel.obserableList);
        binding.recNetWork.setAdapter(adapter);
        binding.refWork.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                viewModel.requestNetWork();
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //跳转到详情界面,传入条目的实体对象
                Bundle mBundle = new Bundle();
                mBundle.putParcelable("entity", viewModel.obserableList.get(position));
                viewModel.startContainerActivity(DetailFragment.class.getCanonicalName(),mBundle);
            }
        });
    }

    @Override
    public void initViewObservable() {
        viewModel.uc.finishRefreshing.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                binding.refWork.finishRefresh();
                adapter.notifyDataSetChanged();
            }
        });
        viewModel.uc.finishLoadmore.observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                binding.refWork.finishLoadMore();
                adapter.notifyDataSetChanged();
            }
        });
    }
}
