package com.example.myreview.Rating;

import android.net.Uri;

public class UserGeneralInformation {

    private String name, password;
    private Uri avatar;

    public UserGeneralInformation (String name, String password, Uri avatar){
        this.name = name;
        this.password = password;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Uri getAvatar() {
        return avatar;
    }
}
