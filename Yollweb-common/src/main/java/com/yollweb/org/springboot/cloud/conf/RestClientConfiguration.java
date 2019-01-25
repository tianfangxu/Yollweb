package com.yollweb.org.springboot.cloud.conf;

import com.yollweb.org.springboot.cloud.conf.properties.ServiceIdProps;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

    @Bean
    public ServiceIdProps serviceIdProps() {
        return new ServiceIdProps();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplateBuilder().requestFactory(
        		clientHttpRequestFactory()).build();
        return restTemplate;
    }
    
    private ClientHttpRequestFactory clientHttpRequestFactory() {  
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();  
        factory.setReadTimeout(10000);  
        factory.setConnectTimeout(10000);  
        return factory;  
    }
}
