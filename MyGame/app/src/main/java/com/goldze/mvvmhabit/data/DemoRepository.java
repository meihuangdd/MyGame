package com.goldze.mvvmhabit.data;

import com.goldze.mvvmhabit.data.source.HttpDataSource;
import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * MVVM的model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * 2020、
 */
public class DemoRepository extends BaseModel implements HttpDataSource {
    private volatile static DemoRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    public DemoRepository(HttpDataSource mHttpDataSource) {
        this.mHttpDataSource = mHttpDataSource;
    }
    public static DemoRepository getInstance(HttpDataSource httpDataSource){
        if(INSTANCE == null){
            synchronized (DemoRepository.class){
                if(INSTANCE == null){
                    INSTANCE = new DemoRepository(httpDataSource);
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return mHttpDataSource.demoGet();
    }
}
