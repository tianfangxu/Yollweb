package com.yollweb.org.springboot.cloud.conf;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "sc.apr", name = "enable", havingValue = "true")
public class AprConfiguration {

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        AprLifecycleListener aprLifecycle = new AprLifecycleListener();
        tomcatFactory.addContextLifecycleListeners(aprLifecycle);
        tomcatFactory.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
        tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                Http11AprProtocol handler = (Http11AprProtocol)connector.getProtocolHandler();
                handler.setMaxThreads(1000);
                handler.setAcceptorThreadCount(4);
//                handler.setPollerSize(40 * 1024);
            }

        });


        return tomcatFactory;
    }

}
