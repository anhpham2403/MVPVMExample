package com.example.anh.mvpvm.screen.main;

import com.example.anh.mvpvm.data.model.User;
import com.example.anh.mvpvm.data.source.UserDataSource;
import com.example.anh.mvpvm.data.source.UserRepositoty;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by anh on 13/09/2017.
 */

public class MainPresenter implements MainContract.Presenter{
    private MainContract.ViewModel mViewModel;
    private UserRepositoty mUserRepositoty;
    private CompositeDisposable mCompositeDisposable;
    public MainPresenter(MainContract.ViewModel viewModel, UserRepositoty userRepositoty) {
        mViewModel = viewModel;
        mUserRepositoty = userRepositoty;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getUsers(String username) {
        mViewModel.onShowProgress();
        mCompositeDisposable.add(mUserRepositoty.getUsers(username).subscribeOn(Schedulers.newThread()).observeOn(
                AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<List<User>>(){

            @Override
            public void onNext(List<User> value) {
                mViewModel.onSuccess(value);
                mViewModel.onHideProgress();
            }

            @Override
            public void onError(Throwable e) {
                mViewModel.onError(e.getMessage());
                mViewModel.onHideProgress();
            }

            @Override
            public void onComplete() {

            }
        }
    ));
    }
}
