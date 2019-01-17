package com.yyx.springcloud.controller;

import com.yyx.springcloud.feign.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/8 14:24
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MemberFeign memberFeign;

    @GetMapping("/getMemberInfoById")
    public String getMemberInfoById(@RequestParam(required = false) Integer id) {
        String url="http://springcloud-study-member/api/member/queryMemberById";

        String result = restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/queryMemberById")
    public String queryMemberById(@RequestParam(required = false) Integer id) {

        return memberFeign.queryMemberById(25);
    }
}
