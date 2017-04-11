package net.Post;

/**
 * Created by haohe on 2017/4/11 0011.
 */

public class testPost extends BasePost {

    private String LoginName;
    private String LoginPassword;

    public testPost(String loginName, String loginPassword) {
        LoginName = loginName;
        LoginPassword = loginPassword;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getLoginPassword() {
        return LoginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        LoginPassword = loginPassword;
    }
}
