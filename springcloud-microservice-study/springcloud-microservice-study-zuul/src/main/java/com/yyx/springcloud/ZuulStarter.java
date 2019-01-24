package com.yyx.springcloud;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/22 18:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableSwagger2Doc
public class ZuulStarter {

    public static void main(String[] args) {
        SpringApplication.run(ZuulStarter.class, args);
    }

    @RefreshScope
    @ConfigurationProperties("zuulProperties")
    public ZuulProperties setZuulProperties() {
        return new ZuulProperties();
    }

}
