package com.ok.rest.callback;

import com.ok.item.FileListItem;
import com.ok.item.LoginItem;

import java.util.List;

/**
 * Created by Okan on 23.3.2016.
 */
public interface LoginCallback {
    void onSuccess(LoginItem result);
    void onFailure(Throwable t);
}
