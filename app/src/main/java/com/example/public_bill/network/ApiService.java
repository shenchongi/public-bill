package com.example.public_bill.network;

import com.example.public_bill.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * shenchong
 * 2023.12.17
 * 请求内容回调
 */
public interface ApiService {
    @GET("user/{id}")
    Call<User> getUser(@Path("id") int userId);
}
