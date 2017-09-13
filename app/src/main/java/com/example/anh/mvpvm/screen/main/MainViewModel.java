package com.example.anh.mvpvm.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.example.anh.mvpvm.ApplicationLogin;
import com.example.anh.mvpvm.BR;
import com.example.anh.mvpvm.data.model.User;
import com.example.anh.mvpvm.data.source.UserRepositoty;
import com.example.anh.mvpvm.utils.Constant;
import java.util.List;

/**
 * Created by anh on 12/09/2017.
 */

public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private List<User> mUsers;
    private UserRepositoty mUserRepositoty;
    private UserAdapter mUserAdapter;
    private MainPresenter mMainPresenter;
    private boolean isComplete;
    public MainViewModel(UserRepositoty userRepositoty) {
        mUserRepositoty = userRepositoty;
    }

    public void setMainPresenter(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
        mainPresenter.getUsers(Constant.USERNAME);
        isComplete = false;
    }

    @Bindable
    public UserAdapter getUserAdapter() {
        return mUserAdapter;
    }

    @Override
    public void onSuccess(List<User> users) {
        mUsers = users;
        mUserAdapter = new UserAdapter(mUsers);
        notifyPropertyChanged(BR.userAdapter);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(ApplicationLogin.getContext(), msg, Toast.LENGTH_LONG).show();
        isComplete = true;
        notifyPropertyChanged(BR.complete);
    }

    @Override
    public void onShowProgress() {
        isComplete = false;
        notifyPropertyChanged(BR.complete);
    }

    @Override
    public void onHideProgress() {
        isComplete = true;
        notifyPropertyChanged(BR.complete);
    }
    @Bindable
    public boolean isComplete() {
        return isComplete;
    }
}
