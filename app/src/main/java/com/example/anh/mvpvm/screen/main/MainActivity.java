package com.example.anh.mvpvm.screen.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.anh.mvpvm.R;
import com.example.anh.mvpvm.data.source.UserRepositoty;
import com.example.anh.mvpvm.data.source.remote.api.UserRemoteDataSource;
import com.example.anh.mvpvm.data.source.remote.api.service.UserServiceClient;
import com.example.anh.mvpvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private MainPresenter mMainPresenter;
    private UserRepositoty mUserRepositoty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserRepositoty =
                new UserRepositoty(new UserRemoteDataSource(UserServiceClient.getInstance()));
        MainViewModel mainViewModel = new MainViewModel(mUserRepositoty);
        mMainPresenter = new MainPresenter(mainViewModel,mUserRepositoty);
        mainViewModel.setMainPresenter(mMainPresenter);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(mainViewModel);
    }
}
