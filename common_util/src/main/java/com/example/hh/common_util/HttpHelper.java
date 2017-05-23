package com.example.hh.common_util;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

/**
 * Created by haohe on 2017/4/10 0010.
 *
 * 通过该类获取参数{
 *     url，地址
 *     responseClass，获取相应参数的响应Bean
 *     HttpCallBack 回调接口，处理响应成功/失败的操作
 *     postBean，上传参数bean，如果不为空会将值拼入到url中
 *     method 请求方法，默认为post
 * }
 * 向服务器发送 get/post请求。
 * 服务器响应后返回
 */

public class HttpHelper<T extends ResponseBean> {

    private String url;
    private Class<T> responseClass;
    private HttpCallBack<T> callback;
    private PostBean postBean;
    private int method = Request.Method.POST;

    public HttpHelper(String url,PostBean postBean, Class<T>responseClass,HttpCallBack<T>callBack) {
        this(Request.Method.POST, url, postBean, responseClass, callBack);
    }

    public HttpHelper(int method ,String url,PostBean postBean, Class<T>responseClass,HttpCallBack<T>callBack) {
        this.url = url;
        this.responseClass = responseClass;
        this.callback = callBack;
        this.method = method;
        this.postBean = postBean;
    }

    //在HttpManager中被调用
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

                callback.onError(error);
            }
        };
        HttpRequest<T> request;

        if(method != Request.Method.GET){  // post
            request = new HttpRequest<>(method, responseClass,url, postBean == null? null:postBean.getJson(),listener,errorListener);
        }else{ // get
            if(postBean != null){
                Class mClass = postBean.getClass();
                //getDeclaredFields()返回Class中所有的字段，包括私有字段；
                //getFields  只返回公共字段，即有public修饰的字段
                Field[]fields = mClass.getFields();
                StringBuilder sb = new StringBuilder();
                for(Field field : fields){
                    try {
                        String value = URLEncoder.encode(field.get(postBean).toString(),"utf-8");
                        sb.append(field.getName()).append("=").append(value).append("&");
                    } catch (UnsupportedEncodingException e) {
                    } catch (IllegalAccessException e) {
                    }
                }
            }

            request = new HttpRequest<>(Request.Method.GET, responseClass, url, listener, errorListener);
        }

        return request;
    }

    public void start(){
        HttpManager.add(this);
    }

}
