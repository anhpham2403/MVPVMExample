package com.example.anh.mvpvm.screen.main;

import com.example.anh.mvpvm.data.model.User;
import com.example.anh.mvpvm.data.source.UserDataSource;
import com.example.anh.mvpvm.data.source.UserRepositoty;
import java.util.List;

/**
 * Created by anh on 13/09/2017.
 */

public class MainPresenter implements MainContract.Presenter{
    private MainContract.ViewModel mViewModel;
    private UserRepositoty mUserRepositoty;

    public MainPresenter(MainContract.ViewModel viewModel, UserRepositoty userRepositoty) {
        mViewModel = viewModel;
        mUserRepositoty = userRepositoty;
    }

    @Override
    public void getUsers(String username) {
        mViewModel.onShowProgress();
        mUserRepositoty.getUsers(username, new UserDataSource.Callback<List<User>>() {
            @Override
            public void onSuccess(List<User> data) {
                mViewModel.onSuccess(data);
                mViewModel.onHideProgress();
            }

            @Override
            public void onFailure(String msg) {
                mViewModel.onError(msg);
                mViewModel.onHideProgress();
            }
        });
    }
}
