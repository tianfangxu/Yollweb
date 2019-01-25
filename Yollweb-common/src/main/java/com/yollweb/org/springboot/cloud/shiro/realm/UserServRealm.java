package com.yollweb.org.springboot.cloud.shiro.realm;

import java.util.List;

import com.yollweb.org.springboot.cloud.shiro.Principal;
import com.yollweb.org.springboot.cloud.shiro.token.RestUserService;
import com.yollweb.org.springboot.cloud.shiro.token.UserServToken;
import com.yollweb.org.springboot.cloud.utils.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.yollweb.org.springboot.cloud.domain.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jlj on 2017/6/30.
 */
public class UserServRealm extends AuthorizingRealm {

    @Autowired
    private RestUserService restUserService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Principal principal = (Principal) getAvailablePrincipal(principals);
        UserInfo user = principal.getUser();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> roleCodes = restUserService.fetchRolesByUser(user);
        for (String roleCode : roleCodes) {
            info.addRole(roleCode);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UserServToken token = (UserServToken) authenticationToken;

        UserInfo user = token.getUserInfo();
        if (user != null) {
            Principal principal = new Principal(user.getId(), user.getAccount(), user.getName());
            principal.setUser(user);
            return new SimpleAuthenticationInfo(principal, StringUtils.trimToEmpty(user.getPassword()), getName());
        }
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UserServToken;
    }
}
