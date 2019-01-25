package com.yollweb.org.springboot.cloud.conf.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sc.msm")
public class MsmProperties {

    // sms url
    private String url;

    // appkey
    private String appkey;

    // secret
    private String secret;

    // 短信签名管理中已存在的签名
    private String freeSignName;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getFreeSignName() {
        return freeSignName;
    }

    public void setFreeSignName(String freeSignName) {
        this.freeSignName = freeSignName;
    }


}
