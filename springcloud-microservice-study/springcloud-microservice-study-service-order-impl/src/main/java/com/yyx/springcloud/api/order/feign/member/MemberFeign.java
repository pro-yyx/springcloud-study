package com.yyx.springcloud.api.order.feign.member;

import com.yyx.springcloud.api.member.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 13:20
 */
@FeignClient(name = "springcloud-microservice-study-service-member")
public interface MemberFeign extends MemberService {

}
