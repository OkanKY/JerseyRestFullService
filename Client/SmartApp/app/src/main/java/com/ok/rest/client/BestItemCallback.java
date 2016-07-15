package com.ok.rest.client;

import com.ok.item.BestPlantItem;

/**
 * Created by Okan on 11.5.2016.
 */
public interface BestItemCallback {
    void onSuccess(BestPlantItem result);
    void onFailure(Throwable t);
}
