package com.goldze.mvvmhabit.utils;

import com.bumptech.glide.request.RequestOptions;
import com.goldze.mvvmhabit.R;

public class Constants {
    //页面404
    public static final int ERROR_404 = 0x123;
    //搜索没有数据
    public static final int ERROR_SEARCH = 0x124;
    //请求数据失败
    public static final int ERROR_NETWORK = 0x125;
    //查询没有数据
    public static final int ERROR_NORMAL = 0x126;

    public static RequestOptions defaultOptions() {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(R.mipmap.public_default);
        requestOptions.placeholder(R.mipmap.public_default);
        return requestOptions;
    }

    public static RequestOptions defaultOptions(int drawableId) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(drawableId);
        requestOptions.placeholder(drawableId);
        return requestOptions;
    }
}
