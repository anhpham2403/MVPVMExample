package com.example.anh.mvpvm.data.source.remote.api.service;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anh on 13/09/2017.
 */

public class ServiceClient {
    static <T> T createService(String endPoint, Class<T> serviceClass) {
        return createService(endPoint, serviceClass,null);
    }

    static <T> T createService(String endPoint, Class<T> serviceClass,
            @NonNull Gson gson) {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(endPoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
