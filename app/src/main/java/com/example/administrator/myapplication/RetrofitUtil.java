package com.example.administrator.myapplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
//<uses-permission android:name="android.permission.INTERNET"/>
//compile 'com.squareup.retrofit2:retrofit:2.4.0'
//compile 'com.squareup.retrofit2:converter-scalars:2.4.0'

//功能类
public class RetrofitUtil {
    public static void requestGet(Callback<String> callback){
        //创建Retrofit对象
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        //创建ApiService对象
        ApiService apiService=retrofit.create(ApiService.class);
        //创建call对象
        Call<String> call=apiService.requestGet("Get");
        //调用enqueue
        call.enqueue(callback);
    }
    public static void requestPost(Callback<String> callback){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);
        Call<String> call=apiService.requestPost("Post");
        call.enqueue(callback);
    }

}
