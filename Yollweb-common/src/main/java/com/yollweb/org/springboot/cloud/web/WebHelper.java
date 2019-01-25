package com.yollweb.org.springboot.cloud.web;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.yollweb.org.springboot.cloud.shiro.token.RequestHeaderType;
import com.yollweb.org.springboot.cloud.utils.StringUtils;
import com.yollweb.org.springboot.cloud.utils.WebUtils;

public class WebHelper {

    private static final WebHelper instance = new WebHelper();

    private WebHelper(){}

    public static final WebHelper instance() {
        return instance;
    }

    public static String containsAccessToken(ServletRequest request) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("token");

        return token;
    }

    public static boolean isMobileLogin(ServletRequest request) {
        return WebUtils.containsInHeader((HttpServletRequest) request,
                RequestHeaderType.mobile.name()) ||
                StringUtils.isNotBlank(request.getParameter(RequestHeaderType.mobile.name()));
    }

    public static boolean isDesktopLogin(ServletRequest request) {
        return WebUtils.containsInHeader((HttpServletRequest) request,
                RequestHeaderType.desktop.name()) ||
                StringUtils.isNotBlank(request.getParameter(RequestHeaderType.desktop.name()));
    }

    public static boolean isWebRequest(ServletRequest request) {
        return request.getAttribute(RequestHeaderType.web.name()) != null;
    }


    public static boolean isMobile(ServletRequest request) {
        return WebHelper.isMobileLogin(request);
    }

    public static boolean isAsyc(ServletRequest request) {
        String reqType = ((HttpServletRequest)request).getHeader("x-requested-with");
        return StringUtils.isNotBlank(reqType);
    }

    public static boolean isNeedJson(ServletRequest request) {
        return isMobile(request) || isAsyc(request);
    }

}
