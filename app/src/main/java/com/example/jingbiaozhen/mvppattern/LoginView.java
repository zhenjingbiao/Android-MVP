package com.example.jingbiaozhen.mvppattern;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

public interface LoginView
{
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
