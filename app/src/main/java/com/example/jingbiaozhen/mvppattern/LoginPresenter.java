package com.example.jingbiaozhen.mvppattern;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

public interface LoginPresenter {
    void validateCreadentials(String username,String password);
    void onDestory();
}
