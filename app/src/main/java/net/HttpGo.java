package net;

import com.example.hh.common_util.HttpHelper;

import net.Listener.HttpListener;
import net.Post.testPost;
import net.Response.testResponse;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class HttpGo {

    public static void getTestInfo(String comm_url, String username, String pwd, HttpListener<testResponse> picListener){
        HttpHelper<testResponse> helper = new HttpHelper<>(
                comm_url,
                new testPost(username, pwd),
                testResponse.class,
                picListener
                );

        helper.start();
    }
}