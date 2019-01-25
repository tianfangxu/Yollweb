package com.yollweb.org.springboot.cloud.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.yollweb.org.springboot.cloud.exception.AppException;
import com.yollweb.org.springboot.cloud.utils.JsonUtils;
import com.yollweb.org.springboot.cloud.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.yollweb.org.springboot.cloud.domain.bean.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;


public class RestBaseService {

    protected static final Log log = LogFactory.getLog(RestBaseService.class);

    @Autowired
    protected RestTemplate rest;


    protected <T> T get(String serviceId, String uri,
                        Class<T> responseType, HttpServletRequest request) {
        String url = reqUrl(serviceId, uri);
        ResponseEntity<T> responseEntity = rest.exchange(url, HttpMethod.GET,
                entity(headers(request), null), responseType);
        if (responseEntity.getStatusCodeValue() != 200) {
            log.error("Failed to access " + url);
            throw new AppException("Failed to access service");
        }
        return responseEntity.getBody();
    }
    
    protected <T> T get(String serviceId, String uri,
            Class<T> responseType, Object requestParams, HttpServletRequest request) {
		String url = reqUrl(serviceId, uri);
		
		ResponseEntity<T> responseEntity = rest.exchange(url, HttpMethod.GET, 
				entity(headers(request), null), responseType, requestParams);
		if (responseEntity.getStatusCodeValue() != 200) {
		log.error("Failed to access " + url);
		throw new AppException("Failed to access service");
		}
		return responseEntity.getBody();
	}

    protected <E> E post(String serviceId, String uri,
                         Class<E> responseType, Object requestParams, HttpServletRequest request) {
        String url = reqUrl(serviceId, uri);
        ResponseEntity<E> responseEntity = rest.exchange(url, HttpMethod.POST,
                entity(headers(request), requestParams), responseType);
        if (responseEntity.getStatusCodeValue() != 200) {
            log.error("Failed to access " + url);
            throw new AppException("Failed to access service");
        }
        return responseEntity.getBody();
    }
    protected ResponseResult post1(String serviceId, String uri,
            Class<ResponseResult> class1, LinkedMultiValueMap requestParams, HttpServletRequest request) {
		String url = reqUrl(serviceId, uri);
		ResponseEntity<ResponseResult> responseEntity = rest.exchange(url, HttpMethod.POST,entity(headers2(request), requestParams), class1);
		if (responseEntity.getStatusCodeValue() != 200) {
			log.error("Failed to access " + url);
			throw new AppException("Failed to access service");
		}
			return responseEntity.getBody();
	}
    
    protected HttpHeaders headers2(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/x-www-form-urlencoded"));
        headers.add("Accept", MediaType.APPLICATION_FORM_URLENCODED_VALUE.toString());
        if(request == null) {
        	return headers;
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        String token  = request.getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            headers.set("token", token);
        }
        String mobile  = request.getHeader("mobile");
        if (StringUtils.isNotBlank(mobile)) {
            headers.add("mobile", mobile);
        }

        return headers;
    }

    protected HttpHeaders headers(HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        if(request == null) {
        	return headers;
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headers.add(key, value);
        }
        //headers.setExpires(0);
        //headers.add("Accept-Encoding", "gzip,deflate");
       // headers.add("Accept-Language", "zh-CN");
        //headers.add("Pragma", "no-cache");
        String token  = request.getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            headers.set("token", token);
        }
        String mobile  = request.getHeader("mobile");
        if (StringUtils.isNotBlank(mobile)) {
            headers.add("mobile", mobile);
        }

        return headers;
    }
    
    

    protected HttpEntity<String> entity(HttpHeaders headers, Object requestParams) {
        HttpEntity<String> entity = new HttpEntity<>(
                requestParams == null ? null : JsonUtils.toJsonString(requestParams),headers);

        return entity;
    }

    protected String reqUrl(String serviceId, String uri) {
        return "http://" + serviceId + "/" + uri;
    }
}
