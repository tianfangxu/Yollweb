package com.yollweb.org.springboot.cloud.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserToken extends UsernamePasswordToken {

    public UserToken(String username, String password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }
}
