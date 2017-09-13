package com.example.anh.mvpvm.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anh on 11/09/2017.
 */

public class User {
    @SerializedName("id")
    @Expose
    private long mId;
    @SerializedName("login")
    @Expose
    private String mUserName;
    @SerializedName("avatar_url")
    @Expose
    private String mAvatarURL;

    public User() {
    }

    public User(long id, String username, String avatarURL) {
        mId = id;
        mUserName = username;
        mAvatarURL = avatarURL;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getUsername() {
        return mUserName;
    }

    public void setUsername(String username) {
        mUserName = username;
    }

    public String getAvatarURL() {
        return mAvatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        mAvatarURL = avatarURL;
    }
}
