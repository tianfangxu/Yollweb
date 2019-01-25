package com.yollweb.org.springboot.cloud.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;
import com.yollweb.org.springboot.cloud.domain.bean.UserInfo;

/**
 * Created by jlj on 2017/6/30.
 */
public class UserServToken extends UsernamePasswordToken {

    private UserInfo userInfo;

    public UserServToken(String username, String password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
