package com.yyx.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/9 19:26
 */
@RestController
public class RibbonHandsWrite {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    private AtomicInteger requestCount = new AtomicInteger(1);

    @GetMapping("/getMemberInfoById")
    public String getMemberInfoById(@RequestParam(required = false) Integer id) {
        String url=this.getUrl("springcloud-study-member");
        String result = restTemplate.getForObject(url+"api/member/queryMemberById", String.class);
        return result;
    }

    public  String getUrl(String serviceId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if (null == instances || instances.size() <= 0) {
            return null;
        }
        int instanceSize = instances.size();
        int serviceIndex = requestCount.intValue() % instanceSize;
        requestCount.incrementAndGet();
        return instances.get(serviceIndex).getUri().toString();
    }
}
