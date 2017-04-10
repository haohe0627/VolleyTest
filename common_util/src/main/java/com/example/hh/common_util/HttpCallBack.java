package com.example.hh.common_util;

import com.android.volley.VolleyError;

/**
 * Created by haohe on 2017/4/10 0010.
 */

public abstract class HttpCallBack<T> {

    public abstract void onSuccess(T t);
    public abstract void onError(VolleyError error);
}
