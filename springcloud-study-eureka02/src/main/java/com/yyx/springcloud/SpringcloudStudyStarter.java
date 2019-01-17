package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/9 11:26
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringcloudStudyStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudStudyStarter.class, args);
    }
}
