package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/8 13:51
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringcloudMemberStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMemberStarter.class, args);
    }


}
