package com.yollweb.springboot.cloud.service2.impl.service;

import com.yollweb.springboot.cloud.service2.impl.feign.BusinessOperationApiFeign;
import com.yollweb.springboot.cloud.service2.impl.mapper.AgricultureDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AgricultureService {
	@Autowired
    private AgricultureDtoMapper agricultureDtoMapper;
	
	//调用其他服务的接口：通过Feign
	@Autowired
	BusinessOperationApiFeign businessOperationApiFeign;

}
