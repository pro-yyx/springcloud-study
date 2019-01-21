package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/21 18:31
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientStarter {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientStarter.class, args);
    }
}
