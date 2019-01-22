package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
}