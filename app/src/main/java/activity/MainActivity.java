package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.example.hh.common_util.CommonVolleyFunction;
import com.example.hh.common_util.HttpManager;
import com.example.hh.volleytest.R;

import net.HttpGo;
import net.Listener.HttpListener;
import net.Response.testResponse;

public class MainActivity extends AppCompatActivity {

    private String common_url = "http://192.168.1.164:8080/User/Login";
    private String username = "haohe";
    private String pwd = "123456";

    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (TextView)findViewById(R.id.show);

//        doCommonVolleyFunction();     // 直接使用Volley方法
        doCustomerVolleyFunction(); // 自定义调用volley方法

    }

    private void doCommonVolleyFunction(){

        CommonVolleyFunction commonVolleyFunction = new CommonVolleyFunction();
        commonVolleyFunction.doFunction(common_url, getApplicationContext());
    }

    private void doCustomerVolleyFunction(){
        HttpManager.init(getApplicationContext());

        HttpGo.getTestInfo(common_url, username, pwd, new HttpListener<testResponse>() {
            @Override
            public void onSuccess(testResponse picResponse) {
                //提示成功
                Toast.makeText(getApplicationContext(),"success!",Toast.LENGTH_SHORT).show();
                show.setText("success!!!");
            }

            @Override
            public void onError(VolleyError error) {
                //错误处理
                if(error instanceof TimeoutError){     //超时
                    show.setText("time out!!!");
//                    Toast.makeText(getApplicationContext(),"time out!",Toast.LENGTH_SHORT).show();
                }else if(error instanceof AuthFailureError){    //权限验证失败
                    show.setText("authorize false!!!");
//                    Toast.makeText(getApplicationContext(),"authorize false!",Toast.LENGTH_SHORT).show();
                }else { //其他
                    show.setText(error.getMessage());
//                    Toast.makeText(getApplicationContext(),"connect error!"+error.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
