package com.example.jingbiaozhen.mvppattern;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

public class LoginPresenterImpl implements LoginPresenter ,LoginInterator.onLoginFinishedListener{
    private LoginView mLoginView;
    private LoginInterator mLoginInteractor;
    public LoginPresenterImpl(LoginView loginView){
        mLoginView=loginView;
        mLoginInteractor=new LoginInteractorImpl();
    }
    @Override
    public void validateCreadentials(String username, String password) {
        if (mLoginView!=null){
            mLoginView.showProgress();
        }
        mLoginInteractor.login(username,password,this);

    }

    @Override
    public void onDestory() {
        mLoginView=null;

    }

    @Override
    public void onUserNameError() {
        if(mLoginView!=null){
            mLoginView.setUsernameError();
            mLoginView.hideProgress();
        }

    }

    @Override
    public void onPasswordError() {
        if(mLoginView!=null){
            mLoginView.setPasswordError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(mLoginView!=null){
            mLoginView.navigateToHome();
        }

    }
}
