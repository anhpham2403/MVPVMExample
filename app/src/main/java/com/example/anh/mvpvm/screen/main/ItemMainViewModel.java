package com.example.anh.mvpvm.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.anh.mvpvm.data.model.User;

/**
 * Created by anh on 12/09/2017.
 */

public class ItemMainViewModel extends BaseObservable {
    private User mUser;

    public ItemMainViewModel(User user) {
        mUser = user;
    }

    @Bindable
    public String getImageUrl() {
        return mUser.getAvatarURL();
    }

    @Bindable
    public String getUserName() {
        return mUser.getUsername();
    }

    @Bindable
    public String getId() {
        return String.valueOf(mUser.getId());
    }
}
