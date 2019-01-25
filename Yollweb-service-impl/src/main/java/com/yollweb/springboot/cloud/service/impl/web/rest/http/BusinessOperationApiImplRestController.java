//package com.yollweb.springboot.cloud.service.impl.web.rest.http;
//
//import com.yollweb.org.springboot.cloud.constant.RibbonServiceIdConstant;
//import com.yollweb.springboot.cloud.service.domain.BusinessOperationApi;
//import com.yollweb.springboot.cloud.service.impl.service.BusinessService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//
//
//@RestController
//public class BusinessOperationApiImplRestController implements BusinessOperationApi {
//
//	//使用常量类管理：RibbonServiceIdConstant
//	//存放在公共依赖包：springboot-cloud-api
//	//private static final String REST_URL_PREFIX="http://springboot-cloud-service-project02";
//
//	@Autowired
//	BusinessService businessService;
//
//	//ribbon
//	@Autowired
//	RestTemplate  restTemplate;
//
//	@Override
//	//服务熔断
//	@HystrixCommand(fallbackMethod="processHystrix_Get")
//	//服务熔断和服务降级不同（fallbackFactory）
//	@GetMapping("/businessRest")
//	public ResponseEntity<String> business(String business) {
//		//ribbon
//		return restTemplate.postForObject(RibbonServiceIdConstant.REST_URL_PREFIX_PROJECT01+RibbonServiceIdConstant.REST_URL_SUFFIX_PROJECT01_AGRICULTURE,business, ResponseEntity.class);
//	}
//
//	//服务熔断是，调用的方法
//	public ResponseEntity<String> processHystrix_Get(String business){
////	   return ResponseEntity.ok("该"+business+"没有对应的信息,@HystrixCommand生效");
//		return null;
//	}
//}
