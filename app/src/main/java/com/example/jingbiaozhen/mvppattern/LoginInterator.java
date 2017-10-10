package com.example.jingbiaozhen.mvppattern;
/*
 * Created by jingbiaozhen on 2017/10/9.
 **/

public interface LoginInterator {
    interface onLoginFinishedListener{
        void onUserNameError();
        void onPasswordError();
        void onSuccess();
    }
    void login(String username,String password,onLoginFinishedListener listener);
}
