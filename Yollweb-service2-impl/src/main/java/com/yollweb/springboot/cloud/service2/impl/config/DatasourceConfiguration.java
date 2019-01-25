package com.yollweb.springboot.cloud.service2.impl.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
//@ConditionalOnClass
@EnableConfigurationProperties({ApplicationProperties.class})
public class DatasourceConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.db01")
    public DataSource ccmdbDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sp02DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db02")
    public DataSource ccmvehicleDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sp03DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db03")
    public DataSource ccmmemberDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("loginUsername", applicationProperties.getDruid().getUsername());
        registrationBean.addInitParameter("loginPassword", applicationProperties.getDruid().getPassword());
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }

}
