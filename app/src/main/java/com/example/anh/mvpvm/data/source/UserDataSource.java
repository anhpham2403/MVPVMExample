package com.example.anh.mvpvm.data.source;

import com.example.anh.mvpvm.data.model.User;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by anh on 11/09/2017.
 */

public interface UserDataSource {
    Observable<List<User>> getUsers(String username);
}
