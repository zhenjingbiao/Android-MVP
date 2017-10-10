package com.example.jingbiaozhen.mvppattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        mLoginPresenter=new LoginPresenterImpl(this);
    }

    @Override
    public void onClick(View view) {
        mLoginPresenter.validateCreadentials(username.getText().toString(),password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.username_error));

    }

    @Override
    public void setPasswordError() {
        username.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this,LoginActivity.class));
        finish();

    }
}
