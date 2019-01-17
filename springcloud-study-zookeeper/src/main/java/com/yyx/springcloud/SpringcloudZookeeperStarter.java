package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/9 16:00
 */
@SpringBootApplication
@EnableDiscoveryClient   //如果注册中心使用 consul或者是zookeeper ，使用该注解
public class SpringcloudZookeeperStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZookeeperStarter.class, args);
    }
}
