package com.yyx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/21 18:33
 */
@RestController
@RequestMapping("/test")
public class SpringcloudConfigTestController {

    @Value("${user.age}")
    private Integer userAge;

    @GetMapping("/config")
    public Integer testConfig() {
        return userAge;
    }
}
