package com.example.public_bill.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * shenchong
 * 2023.12.17
 * 网络请求初始化
 */
public class OkHttpClientManager {
    private static OkHttpClient okHttpClient;

    //必须先启动该配置
    public synchronized static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    // 添加请求拦截器等配置
                    .addInterceptor(new RequestInterceptor())
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }
}
