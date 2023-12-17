package com.example.public_bill.network;

import com.example.public_bill.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * shenchong
 * 2023.12.17
 * api主要请求管理类
 */
public class ApiManager {
    private static final String BASE_URL = "http://127.0.0.1:8000";
    private static ApiService apiService;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientManager.getOkHttpClient())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static void getUser(int userId, final ApiResponseCallback<User> callback) {
        Call<User> call = apiService.getUser(userId);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    String errorMessage = parseError(response);
                    callback.onFailure(new Exception(errorMessage));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    private static String parseError(Response<?> response) {
        // 在这里可以根据实际情况解析服务器返回的错误信息
        // 例如，可以使用 response.errorBody() 来获取错误的原始内容
        // 然后根据具体的错误格式进行解析
        return "Request failed with code: " + response.code();
    }
}
