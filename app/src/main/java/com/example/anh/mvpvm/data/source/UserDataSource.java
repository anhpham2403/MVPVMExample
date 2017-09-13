package com.example.anh.mvpvm.data.source;

import com.example.anh.mvpvm.data.model.User;
import java.util.List;

/**
 * Created by anh on 11/09/2017.
 */

public interface UserDataSource {
    interface Callback<T>{
        void onSuccess(T data);
        void onFailure(String msg);
    }
    void getUsers(String username, Callback<List<User>> callback);
}
