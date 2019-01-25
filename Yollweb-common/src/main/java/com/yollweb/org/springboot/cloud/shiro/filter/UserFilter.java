package com.yollweb.org.springboot.cloud.shiro.filter;

import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class UserFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

//    private OAuthProperties oauthProperties;
//
//    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//        if (isLoginRequest(request, response)) {
//            return true;
//        } else {
//            Subject subject = getSubject(request, response);
//
//            if (subject.getPrincipal() == null || subject.getSession(false) == null) {
//                // try resolve session from token
//                checkToken(request, response, subject);
//            }
//
//            // If principal is not null, then the user is known and should be allowed access.
//            return subject.getPrincipal() != null;
//        }
//    }

//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        if (ShiroHelper.isMobileLogin(request)) {
//            com.saicmotor.framework.utils.WebUtils.renderString((HttpServletResponse) response,
//                    res(ResCode.UNAUTH.toString(), "", null,
//                            ShiroHelper.iamAuthorizeUrl(oauthProperties.getAuthorizeUrl(),
//                                    oauthProperties.getClientId(), oauthProperties.getRedirectUrl())));
//        } else {
//            saveRequestAndRedirectToLogin(request, response);
//        }
//
//        return false;
//    }

//    public void checkToken(ServletRequest request, ServletResponse response, Subject subject) {
//        if (ShiroHelper.isMobileLogin(request)) {
//            String token = ShiroHelper.containsAccessToken(request);
//            if (StringUtils.isNotBlank(token)) {
//                String userInfoJson = WebUtils.executeHttpGet(
//                        ShiroHelper.iamUserUrl(oauthProperties.getUserInfoUrl(), token));
//                if (StringUtils.isBlank(userInfoJson)) {
//                    WebUtils.renderString((HttpServletResponse) response,
//                            ResultUtils.failure(ResCode.UNAUTH.toString(), "Could not obtain user info"));
//                    return;
//                }
//                UserInfo iamUserInfo = (UserInfo) JsonUtils.fromJsonString(userInfoJson, UserInfo.class);
//                String account = iamUserInfo.getSaicId();
//                // check the user in local db
//                UserService userService = AppContext.getBean(UserService.class);
//                User user = userService.selectByAccount(account);
//                if (user == null) {
//                    user = iamUserInfo.toUser();
//                    userService.insert(user);
//                }
//
//                UserToken userToken = new UserToken(account, StringUtils.trimToEmpty(user.getPassword()), false, request.getRemoteHost());
//                subject.login(userToken);
//                TokenSessionHolder.setSessionId(token, subject.getSession(false).getId().toString());
//            }
//        } else if (ShiroHelper.isDesktopLogin(request)) {
//            DesktopSecret desktopSecret = ShiroHelper.containsAccessSecret(request);
//            if (StringUtils.isNotBlank(desktopSecret.getSecret())) {
//                try {
//                    String decryptAdAccount = Des.decryptString(
//                            desktopSecret.getSecret());
//                    String adAccount = desktopSecret.getAdAccount();
//                    if (adAccount.equals(decryptAdAccount)) {
//                        // check the user in local db
//                        UserService userService = AppContext.getBean(UserService.class);
//                        User user = userService.selectByAccount(adAccount);
//                        if (user == null) {
//                            user = new User();
//                            user.setAccount(adAccount);
//                            user.setPassword(UserInfo.noPasswordRequired);
//                            userService.insert(user);
//                        }
//                        UserToken userToken = new UserToken(adAccount, StringUtils.trimToEmpty(user.getPassword()), false, request.getRemoteHost());
//                        subject.login(userToken);
//                        TokenSessionHolder.setSessionId(adAccount, subject.getSession(false).getId().toString());
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }



//    public BaseRes res(String code, String message, String token, String oauthUrl) {
//        LoginRes loginRes = new LoginRes();
//        loginRes.setCode(code);
//        loginRes.setMessage(message);
//        loginRes.setToken(token);
//        loginRes.setOauthUrl(oauthUrl);
//        return loginRes;
//    }
//
//    public void setOauthProperties(OAuthProperties oauthProperties) {
//        this.oauthProperties = oauthProperties;
//    }
}
