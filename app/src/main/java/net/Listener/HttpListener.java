package net.Listener;

import com.android.volley.AuthFailureError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.example.hh.common_util.HttpCallBack;

import net.Response.BaseResponse;
/**
 * Created by Administrator on 2017/4/10 0010.
 */

    public abstract class HttpListener <T extends BaseResponse> extends HttpCallBack<T> {

    @Override
    public void onError(VolleyError error) {

        //错误处理
        if(error instanceof TimeoutError){     //超时

        }else if(error instanceof AuthFailureError){    //权限验证失败

        }else { //其他

        }
    }
}
