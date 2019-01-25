package com.yollweb.org.springboot.cloud.id;

import java.util.UUID;

import com.yollweb.org.springboot.cloud.shiro.token.TokenSessionHolder;
import com.yollweb.org.springboot.cloud.utils.StringUtils;


public class UserTokenGenerator {


    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
    
    public static void clearSid(String token) {
		String sid = TokenSessionHolder.instance().getSID(token);
		if (StringUtils.isNotBlank(sid)) {
			TokenSessionHolder.instance().rmSID(sid);
		}
	}
}
