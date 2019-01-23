package com.yyx.springcloud.api.order.feign.member;

import com.yyx.springcloud.api.member.service.MemberService;
import com.yyx.springcloud.api.order.feign.fallback.MemberFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 13:20
 */
@FeignClient(name = "springcloud-microservice-study-zuul/api-member",fallback = MemberFeignFallback.class)
public interface MemberFeign extends MemberService {

}
