package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/21 17:29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerStarter {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerStarter.class, args);
    }
}
