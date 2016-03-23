package com.ok.rest.client;

/**
 * Created by Okan on 23.3.2016.
 */
public interface ResultCallback {
    void onSuccess(Object result);
    void onFailure(Throwable t);
}
