package com.example.hh.common_util;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haohe on 2017/4/10 0010.
 * 继承JsonRequest 重写
 */

public class HttpRequest<T>extends JsonRequest<T> {

    private Class<T>mClass;
    private Map<String, String> header;

    public HttpRequest(int method,
                       Class<T>mClass,
                       String url,
                       String requestBody,
                       Response.Listener<T> listener,
                       Response.ErrorListener errorListener){

        super(method, url, requestBody, listener, errorListener);
        this.mClass = mClass;
        header = new HashMap<>();
    }

    public HttpRequest(int method,
                       Class<T>mClass,
                       String url,
                       Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, null, listener, errorListener);
        this.mClass = mClass;
        header = new HashMap<>();
    }

    /**
     *  重写response方法，
     * @param response
     * @return
     */
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {
            String json = new String(response.data,"utf-8");
            T t = new Gson().fromJson(json,mClass);
            Log.i("hh", json);
            return Response.success(t, null);
        } catch (UnsupportedEncodingException e) {
            return Response.error(new VolleyError(e));
        }
    }

    public void addHeaders(String key, String value){
        header.put(key, value);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return header;
    }
}
