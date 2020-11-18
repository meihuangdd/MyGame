package com.goldze.mvvmhabit.data.source.http;

import com.goldze.mvvmhabit.data.source.HttpDataSource;
import com.goldze.mvvmhabit.data.source.http.service.DemoApiService;
import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

public class HttpDataSourceImpl implements HttpDataSource {
    private DemoApiService apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;
    public static HttpDataSourceImpl getInstance(DemoApiService apiService){
        if(INSTANCE == null){
            synchronized (HttpDataSourceImpl.class){
                if(INSTANCE == null){
                    INSTANCE = new HttpDataSourceImpl(apiService);
                }
            }
        }
        return INSTANCE;
    }
    private HttpDataSourceImpl(DemoApiService apiService){
        this.apiService = apiService;
    }
    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return apiService.demoGet();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return apiService.demoPost(catalog);
    }
}
