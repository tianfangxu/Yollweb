package com.yollweb.org.springboot.cloud;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * EurekaServer服务器端启动类,接受其它微服务注册进来
 */
@SpringBootApplication
@EnableEurekaServer
//@EnableAdminServer
public class SpringbootCloudServiceEurekaCenterApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootCloudServiceEurekaCenterApplication.class, args);
	}
}


