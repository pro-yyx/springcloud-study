package com.yyx.springcloud;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/22 22:52
 */
@SpringBootApplication
@EnableEurekaClient
public class MemberStarter {
    public MemberStarter() {
    }

    public static void main(String[] args) {
        SpringApplication.run(MemberStarter.class, args);
    }

    @RefreshScope
    @ConfigurationProperties("member")
    public PropertiesConfiguration refreshPropertiesConfiguration() {
        return new PropertiesConfiguration();
    }


}