package com.example.anh.mvpvm.data.source.remote.api;

import com.example.anh.mvpvm.data.source.remote.api.service.UserAPI;

/**
 * Created by anh on 13/09/2017.
 */

public abstract class BaseRemoteDataSource {
    UserAPI mUserApi;

    public BaseRemoteDataSource(UserAPI userApi) {
        mUserApi = userApi;
    }
}
