package com.yollweb.springboot.cloud.service.impl.feign.fallbackfactory;

import com.yollweb.springboot.cloud.service.impl.feign.AgricultureOperationApiFeign;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

//一个实现了FallbackFactory接口的类AgricultureOperationServiceFallbackFactory
@Component
public class AgricultureOperationServiceFallbackFactory implements FallbackFactory<AgricultureOperationApiFeign>{

	@Override
	public AgricultureOperationApiFeign create(Throwable arg0) {
		return new AgricultureOperationApiFeign() {
			//服务降级后，会调用以下重新实现的方法
			@Override
			public ResponseEntity agriculture(String agriculture) {
				System.out.println("服务降级处理逻辑");
				return ResponseEntity.ok("服务降级处理逻辑");
			}
		};
	}

}
