package com.yollweb.springboot.cloud.service.impl.service;

import com.yollweb.springboot.cloud.service.impl.feign.AgricultureOperationApiFeign;
import com.yollweb.springboot.cloud.service.impl.mapper.BusinessDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BusinessService {
	
	@Autowired
    private BusinessDtoMapper businessDtoMapper;
	
	//调用其他服务的接口：通过Feign
	@Autowired
    AgricultureOperationApiFeign agricultureOperationApiFeign;

}
