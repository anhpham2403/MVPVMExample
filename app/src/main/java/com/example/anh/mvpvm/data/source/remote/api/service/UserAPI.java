package com.example.anh.mvpvm.data.source.remote.api.service;

import com.example.anh.mvpvm.data.model.User;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by anh on 13/09/2017.
 */

public interface UserAPI {
    @GET("/users/{username}/followers")
    Observable<List<User>> getListUserfollowers(@Path("username") String username);
}
