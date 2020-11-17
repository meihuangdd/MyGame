package com.goldze.mvvmhabit.data.source;

import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

public interface HttpDataSource {
    Observable<BaseResponse<DemoEntity>> demoGet();
}
