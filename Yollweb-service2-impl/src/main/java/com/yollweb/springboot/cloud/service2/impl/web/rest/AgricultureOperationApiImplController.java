package com.yollweb.springboot.cloud.service2.impl.web.rest;

import com.yollweb.springboot.cloud.service.domain.BusinessOperationApi;
import com.yollweb.springboot.cloud.service2.domain.AgricultureOperationApi;
import com.yollweb.springboot.cloud.service2.impl.feign.BusinessOperationApiFeign;
import com.yollweb.springboot.cloud.service2.impl.service.AgricultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AgricultureOperationApiImplController implements AgricultureOperationApi {

	@Autowired
	AgricultureService agricultureDTOService;

	@Autowired
	BusinessOperationApiFeign businessOperationApiFeign;

	@Override
	public ResponseEntity<String> agriculture(String agriculture) {
		ResponseEntity business = businessOperationApiFeign.business("哈哈哈哈哈");
		//throw new RuntimeException();
		return ResponseEntity.ok("ok");
	}
	
}
