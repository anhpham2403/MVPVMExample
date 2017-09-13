package com.example.anh.mvpvm.screen.main;

import com.example.anh.mvpvm.data.model.User;
import java.util.List;

/**
 * Created by anh on 13/09/2017.
 */

public class MainContract {
    interface Presenter {
        void getUsers(String username);
    }

    interface ViewModel {
        void onSuccess(List<User> users);

        void onError(String msg);

        void onShowProgress();

        void onHideProgress();
    }
}