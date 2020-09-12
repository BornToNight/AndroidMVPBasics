package com.borntonight.androidmvpbasics.presenter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Patterns;

import com.borntonight.androidmvpbasics.model.IUser;
import com.borntonight.androidmvpbasics.model.User;
import com.borntonight.androidmvpbasics.view.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter {
    ILoginView iLoginView;
    IUser user;
    Handler handler;

    public LoginPresenterImpl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String email, String passwd) {
        boolean isLoginSuccess = true;
        final int code = checkUserValidity(email,passwd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 1000);
    }

    @Override
    public int checkUserValidity(String email, String passwd) {
        if (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(passwd).matches() && passwd.length() > 5) {
            return -1;
        }
        return 0;
    }

    private void initUser(){
        user = new User("mvp","mvp");
    }
}