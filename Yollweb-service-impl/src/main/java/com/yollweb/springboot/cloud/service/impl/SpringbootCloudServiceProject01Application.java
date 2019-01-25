package com.yollweb.springboot.cloud.service.impl;

import com.yollweb.springboot.cloud.service.impl.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;



@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableEurekaClient
//服务监控hystrixDashboard
//http://localhost:8001/hystrix--访问路径
@EnableHystrixDashboard
//对hystrixR熔断机制的支持
@EnableCircuitBreaker
@EnableConfigurationProperties({ApplicationProperties.class})
//@EnableEurekaIsonaServer
public class SpringbootCloudServiceProject01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCloudServiceProject01Application.class, args);
	}
}
