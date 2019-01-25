package com.yollweb.springboot.cloud.service.impl.feign;

import com.yollweb.springboot.cloud.service2.domain.AgricultureOperationApi;
import com.yollweb.springboot.cloud.service.impl.feign.fallbackfactory.AgricultureOperationServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 调用方式：@FeignClient
 * 调用Yollweb-service2的接口
 *
 */
//一个实现了FallbackFactory接口的类AgricultureOperationServiceFallbackFactory
//服务降级处理是在客户端实现完成的，与服务端没有关系
@FeignClient(value="Yollweb-service2",fallbackFactory=AgricultureOperationServiceFallbackFactory.class)
public interface AgricultureOperationApiFeign extends AgricultureOperationApi {

}
