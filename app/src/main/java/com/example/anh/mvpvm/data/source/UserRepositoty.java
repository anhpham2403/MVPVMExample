package com.example.anh.mvpvm.data.source;

import com.example.anh.mvpvm.data.model.User;
import com.example.anh.mvpvm.data.source.remote.api.UserRemoteDataSource;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by anh on 11/09/2017.
 */

public class UserRepositoty implements UserDataSource {
    private UserRemoteDataSource mDataSource;

    public UserRepositoty(UserRemoteDataSource dataSource) {
        mDataSource = dataSource;
    }

    @Override
    public Observable<List<User>> getUsers(String username) {
        return mDataSource.getUsers(username);
    }
}
