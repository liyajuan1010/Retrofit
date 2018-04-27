package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGet,btnPost;
    private TextView tvShowMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        btnPost.setOnClickListener(this);
        btnGet.setOnClickListener(this);
        
    }

    private void initView() {
        btnGet=(Button)findViewById(R.id.btn_get);
        btnPost=(Button)findViewById(R.id.btn_post);
        tvShowMsg=(TextView)findViewById(R.id.tv_show_msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get:
                get();
                break;
            case R.id.btn_post:
                post();
                break;
        }
    }
    private void get() {
        RetrofitUtil.requestGet(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                tvShowMsg.setText("Get方法获取数据："+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                tvShowMsg.setText(t.getMessage());
            }
        });
    }

    private void post() {
        RetrofitUtil.requestPost(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                tvShowMsg.setText("Post方法获取数据："+response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
              tvShowMsg.setText(t.getMessage());
            }
        });
    }

}
