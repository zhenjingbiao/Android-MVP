package com.example.jingbiaozhen.mvppattern.Main;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

import java.util.List;

public interface MainView {
    void showProgress();
    void hideProgress();
    void setItem(List<String> items);
    void showMessage(String message);
}
