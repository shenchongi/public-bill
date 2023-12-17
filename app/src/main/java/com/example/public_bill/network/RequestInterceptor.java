package com.example.public_bill.network;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * shenchong
 * 2023.12.17
 * 请求拦截器
 */
public class RequestInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Request newRequest = originalRequest.newBuilder()
                // 添加我的服务器token，但现在我还没加token，暂时还用不到
//                .addHeader()
                .build();

        return chain.proceed(newRequest);
    }
}
