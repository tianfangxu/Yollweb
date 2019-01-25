package com.yollweb.springboot.cloud.service.impl.web.rest;

import com.yollweb.springboot.cloud.service.domain.BusinessOperationApi;
import com.yollweb.springboot.cloud.service.impl.feign.AgricultureOperationApiFeign;
import com.yollweb.springboot.cloud.service.impl.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class BusinessOperationApiImplController implements BusinessOperationApi {

	@Autowired
	BusinessService businessService;

	@Autowired
	AgricultureOperationApiFeign agricultureOperationApiFeign;
	@Override
	//服务熔断
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	//服务熔断和服务降级不同（fallbackFactory）
	public ResponseEntity<String> business(String business) {
		ResponseEntity agriculture = agricultureOperationApiFeign.agriculture("呵呵呵");
		System.out.println(business + "==========================" + agriculture.getStatusCode());
		//throw new RuntimeException();
		return ResponseEntity.ok("ok01");
	}
	
	//服务熔断时调用的方法
	public ResponseEntity<String> processHystrix_Get(String business){
		return ResponseEntity.ok("该"+business+"没有对应的信息,@HystrixCommand生效");
	}
}
