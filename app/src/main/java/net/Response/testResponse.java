package net.Response;

import bean.TestBean;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class testResponse extends BaseResponse {  //在根请求基础上 获取返回结果

    private String Ticket; // head验证口令
    private TestBean testBean;

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public TestBean getTestBean() {
        return testBean;
    }

    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }
}
