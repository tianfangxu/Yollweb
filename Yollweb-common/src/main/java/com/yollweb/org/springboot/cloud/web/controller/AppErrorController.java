package com.yollweb.org.springboot.cloud.web.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import com.yollweb.org.springboot.cloud.utils.WebUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import com.yollweb.org.springboot.cloud.domain.bean.web.ResponseResultBuiler;
import com.yollweb.org.springboot.cloud.exception.AppException;
import com.yollweb.org.springboot.cloud.web.WebHelper;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jlj on 2017/7/6.
 */
@Controller
public class AppErrorController implements ErrorController {

    private static final Log LOGGER = LogFactory.getLog(AppErrorController.class);

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public String appNotFound(Exception e, ServletRequest request, ServletResponse response) {
        LOGGER.error("Catch system runtime exception...", e);
        if (WebHelper.isNeedJson(request)) {
            return WebUtils.renderString((HttpServletResponse) response, e instanceof AppException ?
                    ResponseResultBuiler.failure(e.getMessage()) : ResponseResultBuiler.failure("Internal server error"));
        }

        if (e instanceof BindException || e instanceof ConstraintViolationException
                || e instanceof ValidationException) {
            return "view/error/400";
        }

        if (e instanceof UnauthorizedException || e instanceof AuthenticationException) {
            return "view/error/403";
        }

        return "view/error/500";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
