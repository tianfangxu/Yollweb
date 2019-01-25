package com.yollweb.springboot.cloud.service2.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 
 * @author xiexie
 *
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard//服务监控hystrixDashboard
@EnableCircuitBreaker//对hystrixR熔断机制的支持
public class SpringbootCloudServiceProject02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCloudServiceProject02Application.class, args);
	}
}
