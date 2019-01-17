package com.yyx.springcloud.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 会员服务api controller
 * @Auther: yinyuxin
 * @Date: 2019/1/8 13:58
 */
@RestController
@RequestMapping("api/member")
public class MemberController {

    @Value("${server.port}")
    private String port;

    @GetMapping("queryMemberById")
    public String queryMemberById(@RequestParam(required = false) Integer id) {
        return "哈哈哈:"+port;
    }


}
