package com.example.hh.common_util;

import com.google.gson.Gson;

/**
 * Created by haohe on 2017/4/10 0010.
 */

public class PostBean {

    // 继承该postbean的类为app中的BaseResponse及其子类，将该bean中存储的参数转化为json形式。
    public String getJson(){
        return new Gson().toJson(this);
    }
}
