package com.yollweb.org.springboot.cloud.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yollweb.org.springboot.cloud.shiro.token.TokenSessionHolder;
import com.yollweb.org.springboot.cloud.shiro.token.UserServToken;
import com.yollweb.org.springboot.cloud.utils.StringUtils;
import com.yollweb.org.springboot.cloud.utils.WebUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import com.yollweb.org.springboot.cloud.ctx.AppContext;
import com.yollweb.org.springboot.cloud.domain.bean.UserInfo;
import com.yollweb.org.springboot.cloud.domain.bean.web.ResponseCode;
import com.yollweb.org.springboot.cloud.domain.bean.web.ResponseResultBuiler;
import com.yollweb.org.springboot.cloud.shiro.token.RestUserService;
import com.yollweb.org.springboot.cloud.web.WebHelper;


public class UserServFilter extends AccessControlFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (isLoginRequest(request, response)) {
            return true;
        } else {
            Subject subject = getSubject(request, response);
//            subject.getSession().setTimeout(1800000);
            if (subject.getPrincipal() == null) {
                // try resolve session from token
                try {
					checkToken(request, response, subject);
				} catch (Exception e) {
					WebUtils.renderString((HttpServletResponse)response,
			                ResponseResultBuiler.build(ResponseCode.INVALIDTOKEN.getCode(), ResponseCode.INVALIDTOKEN.getDesc()));
			        return false;
				}
            }

            // If principal is not null, then the user is known and should be allowed access.
            return subject.getPrincipal() != null;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.renderString((HttpServletResponse)response,
                ResponseResultBuiler.build(ResponseCode.UNAUTH.getCode(), ResponseCode.UNAUTH.getDesc()));
        return false;
    }

    private boolean checkToken(ServletRequest request, ServletResponse response, Subject subject) {
        String token = WebHelper.containsAccessToken(request);
        if (StringUtils.isNotBlank(token)) {
            RestUserService restUserService = AppContext.getBean(RestUserService.class);
            UserInfo user = restUserService.fetchUserInfo(token, (HttpServletRequest) request);
            if (user == null || user.getId() == null) {
                return false;
            }

            UserServToken userServToken = new UserServToken(
                    user.getAccount(), StringUtils.trimToEmpty(user.getPassword()), false, request.getRemoteHost());
            userServToken.setUserInfo(user);
            subject.login(userServToken);
            TokenSessionHolder.instance().setSID(token, subject.getSession(false).getId().toString());
        }

        return false;
    }

}
