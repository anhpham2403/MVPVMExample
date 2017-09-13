package com.example.anh.mvpvm.data.source.remote.api.service;

import android.content.Context;
import com.example.anh.mvpvm.utils.Constant;

/**
 * Created by anh on 13/09/2017.
 */

public class UserServiceClient extends ServiceClient{
    private static UserAPI mUserApiInstance;
    public static UserAPI getInstance(){
        if (mUserApiInstance == null) {
            mUserApiInstance = createService(Constant.END_POINT_URL,UserAPI.class);
        }
        return mUserApiInstance;
    }
}
