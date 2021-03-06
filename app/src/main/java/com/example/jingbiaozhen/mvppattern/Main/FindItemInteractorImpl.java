package com.example.jingbiaozhen.mvppattern.Main;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

import java.util.Arrays;
import java.util.List;

import android.os.Handler;

public class FindItemInteractorImpl implements FindItemInteractor
{
    @Override
    public void findItems(final OnFinishListener listener)
    {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                listener.onFinished(createArrayList());
            }
        }, 2000);

    }

    private List<String> createArrayList()
    {

        return Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8");
    }
}
