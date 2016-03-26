package com.ok.rest.client;

import com.ok.item.FileListItem;

import java.util.List;

/**
 * Created by Okan on 23.3.2016.
 */
public interface FieldListCallback {
    void onSuccess(List<FileListItem> result);
    void onFailure(Throwable t);
}
