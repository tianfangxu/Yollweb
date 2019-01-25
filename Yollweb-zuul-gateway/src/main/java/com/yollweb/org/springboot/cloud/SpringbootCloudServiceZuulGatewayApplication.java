package com.yollweb.org.springboot.cloud;

import com.yollweb.org.springboot.cloud.filter.RequestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy//注解中包含@EnableDiscoveryClient
public class SpringbootCloudServiceZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCloudServiceZuulGatewayApplication.class, args);
	}

	@Bean
	public RequestFilter requestLogFilter(){
		return new RequestFilter();
	}
}
