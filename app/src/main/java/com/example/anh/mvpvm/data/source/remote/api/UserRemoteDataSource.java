package com.example.anh.mvpvm.data.source.remote.api;

import com.example.anh.mvpvm.data.model.User;
import com.example.anh.mvpvm.data.source.UserDataSource;
import com.example.anh.mvpvm.data.source.remote.api.service.UserAPI;
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
    public void getUsers(String username, final Callback<List<User>> callback) {
        mUserApi.getListUserfollowers(username).enqueue(new retrofit2.Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> users = response.body();
                    callback.onSuccess(users);
                } else {
                    callback.onFailure("code: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
