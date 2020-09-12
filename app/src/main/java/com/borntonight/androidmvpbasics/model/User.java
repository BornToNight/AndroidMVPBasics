package com.borntonight.androidmvpbasics.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPasswd() {
        return password;
    }
}