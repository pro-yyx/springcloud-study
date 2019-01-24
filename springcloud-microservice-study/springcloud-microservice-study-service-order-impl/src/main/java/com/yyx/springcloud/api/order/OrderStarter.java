package com.yyx.springcloud.api.order;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 13:27
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableSwagger2Doc
public class OrderStarter {


    public static void main(String[] args) {
        SpringApplication.run(OrderStarter.class, args);
    }

    @RefreshScope
    @ConfigurationProperties("order")
    public PropertiesConfiguration refreshPropertiesConfiguration() {
        return new PropertiesConfiguration();
    }
}
