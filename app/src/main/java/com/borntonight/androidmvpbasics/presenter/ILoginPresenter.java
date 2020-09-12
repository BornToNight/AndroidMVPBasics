package com.borntonight.androidmvpbasics.presenter;

public interface ILoginPresenter {
    void doLogin(String email, String passwd);
    int checkUserValidity(String name, String passwd);
}
