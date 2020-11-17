package com.goldze.mvvmhabit.data.source.http.service;

import com.goldze.mvvmhabit.entity.DemoEntity;


import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;
import retrofit2.http.GET;

public interface DemoApiService {
    @GET("action/apiv2/banner?catalog=1")
    Observable<BaseResponse<DemoEntity>> demoGet();
}
