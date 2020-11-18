package com.goldze.mvvmhabit.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.entity.DemoEntity;
import com.goldze.mvvmhabit.utils.Constants;

import java.util.List;

public class NetWorkAdapter extends BaseQuickAdapter<DemoEntity.ItemsEntity, BaseViewHolder> {
    public NetWorkAdapter( @Nullable List<DemoEntity.ItemsEntity> data) {
        super(R.layout.item_network, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DemoEntity.ItemsEntity item) {
        helper.setText(R.id.tv_title,item.getName());

        Glide.with(mContext)
                .load(item.getImg())
                .apply(Constants.defaultOptions())
                .into((ImageView) helper.getView(R.id.img));

    }
}
