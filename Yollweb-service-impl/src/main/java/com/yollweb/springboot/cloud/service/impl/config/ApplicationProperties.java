package com.yollweb.springboot.cloud.service.impl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private Druid druid;
    private String ruleRegister;
    private String rulePerfectInfo;

    public String getRuleRegister() {
        return ruleRegister;
    }

    public void setRuleRegister(String ruleRegister) {
        this.ruleRegister = ruleRegister;
    }

    public String getRulePerfectInfo() {
        return rulePerfectInfo;
    }

    public void setRulePerfectInfo(String rulePerfectInfo) {
        this.rulePerfectInfo = rulePerfectInfo;
    }

    public Druid getDruid() {
        return druid;
    }

    public void setDruid(Druid druid) {
        this.druid = druid;
    }

    public static class Druid {
        private String username;
        private String password;
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

}
