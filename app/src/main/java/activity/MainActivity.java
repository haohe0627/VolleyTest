package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.hh.common_util.CommonVolleyFunction;
import com.example.hh.volleytest.R;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doCommonVolleyFunction();     //一般使用Volley方法
    }

    private void doCommonVolleyFunction(){
        webView = (WebView)findViewById(R.id.webview);
        webView.loadData("","text/html","utf-8");

        CommonVolleyFunction commonVolleyFunction = new CommonVolleyFunction();
        commonVolleyFunction.doFunction(getApplicationContext());
    }
}
