package com.yollweb.springboot.cloud.service2.impl.feign;

import com.yollweb.springboot.cloud.service.domain.BusinessOperationApi;
import org.springframework.cloud.netflix.feign.FeignClient;


/**
 * 调用方式：@FeignClient
 * 调用Yollweb-service2的接口
 *
 */
@FeignClient("Yollweb-service")
public interface BusinessOperationApiFeign extends BusinessOperationApi{
	
	
}
