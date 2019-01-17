package com.yyx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/8 13:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringcloudOrderStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOrderStarter.class, args);
    }

    /**
     * 解决使用restTemplate请求远程服务时 注入restTemplate失败的问题
     * 如果要使用别名请求eureka上的服务，需要依赖ribbon的负载均衡器 LoadBalanced
     * LoadBalanced 能让restTempalte在请求时拥有客户端负载均衡的能力
     * @return
     */
    @Bean
    //@LoadBalanced
    RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
