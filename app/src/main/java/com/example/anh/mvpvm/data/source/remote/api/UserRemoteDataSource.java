package com.example.anh.mvpvm.data.source.remote.api;

import com.example.anh.mvpvm.data.model.User;
import com.example.anh.mvpvm.data.source.UserDataSource;
import com.example.anh.mvpvm.data.source.remote.api.service.UserAPI;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by anh on 13/09/2017.
 */

public class UserRemoteDataSource extends BaseRemoteDataSource implements UserDataSource {

    public UserRemoteDataSource(UserAPI userApi) {
        super(userApi);
    }

    @Override
    public Observable<List<User>> getUsers(String username) {
        return mUserApi.getListUserfollowers(username);
    }
}
