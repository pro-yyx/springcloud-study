package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/22 18:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulStarter {

    public static void main(String[] args) {
        SpringApplication.run(ZuulStarter.class, args);
    }
}
