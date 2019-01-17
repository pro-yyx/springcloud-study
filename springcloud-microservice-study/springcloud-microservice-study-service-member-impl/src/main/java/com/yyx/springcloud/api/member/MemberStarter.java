package com.yyx.springcloud.api.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 13:14
 */
@SpringBootApplication
@EnableEurekaClient
public class MemberStarter {

    public static void main(String[] args) {
        SpringApplication.run(MemberStarter.class, args);
    }
}
