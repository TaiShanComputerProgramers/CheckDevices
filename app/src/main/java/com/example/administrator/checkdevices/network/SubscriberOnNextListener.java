package com.example.administrator.checkdevices.network;

/**
 * Created by liukun on 16/3/10.
 */
public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onComplete(T t);
}
