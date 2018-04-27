package com.example.administrator.myapplication;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //注解
    @GET("get.php")   //基地址后面的部分
    Call<String> requestGet(@Query("key") String key);


    @FormUrlEncoded
    @POST("post.php")
    Call<String> requestPost(@Field("key") String key);
}
