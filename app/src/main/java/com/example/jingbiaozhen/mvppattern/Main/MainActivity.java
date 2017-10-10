package com.example.jingbiaozhen.mvppattern.Main;
/*
 * Created by jingbiaozhen on 2017/10/10.
 **/

import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.jingbiaozhen.mvppattern.R;

public class MainActivity extends AppCompatActivity implements MainView,AdapterView.OnItemClickListener{
    private MainPresenter mMainPresenter;
    private ListView listView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        mMainPresenter=new MainPresenterImpl(this,new FindItemInteractorImpl());

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestory();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mMainPresenter.onItemClick(i);

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItem(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items));

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
