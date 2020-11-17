package com.goldze.mvvmhabit.model.test;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.data.DemoRepository;
import com.goldze.mvvmhabit.entity.DemoEntity;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.http.ResponseThrowable;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class NetWorkViewModel extends BaseViewModel<DemoRepository> {
    //封装一个界面发生改变的观察者
    public UIChangObservable uc = new UIChangObservable();
    public class UIChangObservable{
        //下拉刷新完成
        public SingleLiveEvent finishRefreshing = new SingleLiveEvent<>();
        //上拉加载完成
        public SingleLiveEvent finishLoadmore = new SingleLiveEvent<>();
    }
    public NetWorkViewModel(@NonNull Application application,DemoRepository repository) {
        super(application,repository);
    }
    //给RecyclerView添加ObservableList
    public ObservableList<NetWorkItemViewModel> obserableList = new ObservableArrayList<>();

    //给RecyclerView添加ItemBinding
    public ItemBinding<NetWorkItemViewModel> itemBinding = ItemBinding.of(BR.networkModel, R.layout.item_network);
    //下拉刷新
    public BindingCommand onRefreshCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("下拉刷新");
            requestNetWork();
        }
    });

    /**
     * 网络请求方法，在ViewModel中调用Model层，通过Okhttp+Retrofit+RxJava发起请求
     */
    public void requestNetWork(){
        //可以调用addSubscribe()添加Disposable，请求与View周期同步
        model.demoGet()
                .compose(RxUtils.schedulersTransformer())//线程调度
                .compose(RxUtils.exceptionTransformer())//网络错误的异常转换，这里可以转换成自己的ExceptionHandle
                .doOnSubscribe(this)//请求ViewModel周期同步
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog("正在请求。。。");
                    }
                })
                .subscribe(new DisposableObserver<BaseResponse<DemoEntity>>() {

                    @Override
                    public void onNext(BaseResponse<DemoEntity> response) {
                        //清除列表
                        obserableList.clear();
                        //请求成功
                        if(response.getCode() == 1){
                            for(DemoEntity.ItemsEntity entity :response.getResult().getItems()){
                                NetWorkItemViewModel itemViewModel = new NetWorkItemViewModel(NetWorkViewModel.this,entity);
                                //双向绑定动态添加Item
                                obserableList.add(itemViewModel);
                            }
                        }else{
                            //code错误时也可以定义Observable回调到View层去处理
                            ToastUtils.showShort("数据错误");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        //关闭对话框
                        dismissDialog();
                        //请求刷新完成收回
                        uc.finishRefreshing.call();
                        if(e instanceof ResponseThrowable){
                            ToastUtils.showShort(((ResponseThrowable)e).message);
                        }
                    }

                    @Override
                    public void onComplete() {
                        //关闭对话框
                        dismissDialog();
                        uc.finishRefreshing.call();
                    }
                });
    }
    /**
     * 获取条目下标
     */
    public int getItemPosition(NetWorkItemViewModel netWorkItemViewModel){
        return obserableList.indexOf(netWorkItemViewModel);
    }
}
