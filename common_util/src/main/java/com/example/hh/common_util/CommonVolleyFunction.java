package com.example.hh.common_util;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by haohe on 2017/4/10 0010.
 */

public class CommonVolleyFunction {

    public void doFunction(String url, Context context){
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest
                (url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", response);
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                });

        queue.add(stringRequest);
    }
}
