package com.yyx.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/9 22:03
 */
@FeignClient(name="springcloud-study-member")
public interface MemberFeign {

    @RequestMapping(value = "/api/member/queryMemberById")
    String queryMemberById(@RequestParam(value = "id",required = false) Integer id);
}
