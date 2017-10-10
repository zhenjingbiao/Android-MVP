package com.example.jingbiaozhen.mvppattern.Main;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

import java.util.List;

public interface FindItemInteractor {
    public interface OnFinishListener{
        void onFinished(List<String>items);
    }
    void findItems(OnFinishListener listener);
}
