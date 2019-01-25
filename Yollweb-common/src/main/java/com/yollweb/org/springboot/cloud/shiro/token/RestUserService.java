package com.yollweb.org.springboot.cloud.shiro.token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yollweb.org.springboot.cloud.utils.BeanUtils;
import com.yollweb.org.springboot.cloud.conf.properties.ServiceIdProps;
import com.yollweb.org.springboot.cloud.ctx.AppContext;
import com.yollweb.org.springboot.cloud.domain.bean.UserInfo;
import com.yollweb.org.springboot.cloud.exception.AppException;
import com.yollweb.org.springboot.cloud.service.CrudService;
import com.yollweb.org.springboot.cloud.service.RestBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestUserService extends RestBaseService {

    @Autowired
    private ServiceIdProps serviceIdProperties;

    public UserInfo fetchUserInfo(String token, HttpServletRequest request) {
        CrudService usrSer = usrSer();
        if (usrSer != null) {
        	 List list = new ArrayList();
             Map<String, Object> params = new HashMap<>();
             params.put("token", token);
             list = usrSer.selectByMap(params,request);
            if (list.size() == 1) {
                Object usr = list.get(0);
                UserInfo userInfo = new UserInfo();
                BeanUtils.setPropertyValue(userInfo, "id", BeanUtils.getPropertyValue(usr, "id"));
                //BeanUtils.setPropertyValue(userInfo, "mid", BeanUtils.getPropertyValue(usr, "mid"));
                BeanUtils.setPropertyValue(userInfo, "account", BeanUtils.getPropertyValue(usr, "account"));
                BeanUtils.setPropertyValue(userInfo, "name", BeanUtils.getPropertyValue(usr, "name"));
                BeanUtils.setPropertyValue(userInfo, "password", BeanUtils.getPropertyValue(usr, "password"));
                BeanUtils.setPropertyValue(userInfo, "nickname", BeanUtils.getPropertyValue(usr, "nickname"));
                BeanUtils.setPropertyValue(userInfo, "img", BeanUtils.getPropertyValue(usr, "img"));
                return userInfo;
            } else {
                throw new AppException("Invalid token");
            }
        }
        return get(serviceIdProperties.getUser(), "/user/token/" + token, UserInfo.class, request);
    }

    public List<String> fetchRolesByUser(UserInfo userInfo) {

        return Collections.emptyList();
    }


    public CrudService usrSer() {
        try {
            return  (CrudService) AppContext.getBean("userService", CrudService.class);
        } catch (Exception e) {
            // ignore e
        }
        return null;
    }

}
