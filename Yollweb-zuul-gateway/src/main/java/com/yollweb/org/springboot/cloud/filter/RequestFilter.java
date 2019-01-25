package com.yollweb.org.springboot.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;


public class RequestFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    /*
    PRE: 这种过滤器在请求被路由之前调用。可利用其实现身份验证等
    ROUTING: 这种过滤器将请求路由到微服务，用于构建发送给微服务的请求，并使用Apache Http Client或者Netflix Ribbon请求微服务
    POST: 这种过滤器在路由到微服务以后执行，比如为响应添加标准的HTTP Header，收集统计信息和指标，将响应从微服务发送到客户端等
    ERROR: 在其他阶段发生错误时执行该过滤器
     */
    @Override
    public String filterType() {
        //过滤器类型 (PRE,ROUTING,POST,ERROR)
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //过滤器的优先级，越大越靠后执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //判断是否需要过滤
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        System.out.println("zuul拦截器运行了=========");
        logger.info(String.format("send %srequest to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
