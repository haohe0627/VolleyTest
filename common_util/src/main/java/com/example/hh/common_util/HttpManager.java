package com.example.hh.common_util;

import android.content.Context;
import android.net.http.HttpResponseCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by haohe on 2017/4/11 0011.
 */

public class HttpManager {

    private static RequestQueue requestQueue;

    public static void init(Context context){
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.start();
    }

    public static void add(HttpHelper<? extends ResponseBean>helper){
        HttpRequest<? extends ResponseBean> request = helper.getRequest();
//        request.addHeaders("","");
        requestQueue.add(request);
    }
}
