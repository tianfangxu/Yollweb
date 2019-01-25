package com.yollweb.org.springboot.cloud.conf;


import com.yollweb.org.springboot.cloud.conf.properties.AppProperties;
import com.yollweb.org.springboot.cloud.conf.properties.IdProperties;
import com.yollweb.org.springboot.cloud.id.IdGenerator;
import com.yollweb.org.springboot.cloud.id.SnowflakeId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public AppProperties appProperties() {
        return new AppProperties();
    }

    @Bean
    public IdProperties idProperties() {
        return new IdProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    public IdGenerator snowflakeId(IdProperties idp) {
        return new SnowflakeId(idp.getWorker(),
                idp.getCenter(), 0, idp.getEpoch());
    }

}
