package com.ok.rest.client;

import com.ok.item.Item;

/**
 * Created by Okan on 31.3.2016.
 */
public interface ICallback {
    void onSuccess(Item result);
    void onFailure(Throwable t);
}
