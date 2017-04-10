package com.example.hh.common_util;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by haohe on 2017/4/10 0010.
 */

public class HttpHelper<T extends PostBean> {

    private String url;
    private Class<T> tClass;
    private HttpCallBack<T> callback;
    private PostBean postBean;
    private int method = Request.Method.POST;

    public HttpHelper(String url,PostBean postBean, Class<T>mClass,HttpCallBack<T>callBack) {
        this(Request.Method.POST, url, postBean, mClass, callBack);
    }

    public HttpHelper(int method ,String url,PostBean postBean, Class<T>mClass,HttpCallBack<T>callBack) {
        this.url = url;
        this.tClass = mClass;
        this.callback = callBack;
    }

    public HttpRequest<T>getRequest(){

        Response.Listener<T>listener = new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                //调用自定义返回接口中的返回成功方法，待继承方法实现内容。
                //Q：为什么不用本身的
                //A：返回内容在CommonUtil中，一般返回结果需要调用界面上的信息，且作为util最好只被引用，
                //      UI交互在活动中完成。
                callback.onSuccess(response);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //错误
                callback.onError(error);
            }
        };
        HttpRequest<T> request = null;

        if(method != Request.Method.GET){
            request = new HttpRequest<>(method, tClass, postBean == null? null:postBean.getJson(),listener,errorListener);
        }else{

        }

        return request;
    }

}
