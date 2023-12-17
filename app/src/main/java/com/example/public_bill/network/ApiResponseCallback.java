package com.example.public_bill.network;

/**
 * shenchong
 * 2023.12.17
 * @param <T>
 */
public interface ApiResponseCallback<T> {
    void onSuccess(T response);

    void onFailure(Throwable throwable);
}
