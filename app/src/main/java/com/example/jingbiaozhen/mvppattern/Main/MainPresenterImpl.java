package com.example.jingbiaozhen.mvppattern.Main;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

import java.util.List;

public class MainPresenterImpl implements MainPresenter, FindItemInteractor.OnFinishListener
{
    private MainView mMainView;

    private FindItemInteractor mFindItemInteractor;

    public MainPresenterImpl(MainView mainView, FindItemInteractor findItemInteractor)
    {
        mMainView = mainView;
        mFindItemInteractor = findItemInteractor;
    }

    @Override
    public void onResume()
    {
        if (mMainView != null)
        {
            mMainView.showProgress();
        }
        mFindItemInteractor.findItems(this);

    }

    @Override
    public void onItemClick(int position)
    {
        if (mMainView != null)
        {
            mMainView.showMessage(String.format("第 %d 被点击了", position + 1));
        }

    }

    @Override
    public void onDestory()
    {
        mMainView = null;
    }

    @Override
    public void onFinished(List<String> items)
    {
        if (mMainView != null)
        {
            mMainView.setItem(items);
            mMainView.hideProgress();
        }

    }

    public MainView getMainView()
    {
        return mMainView;
    }
}
