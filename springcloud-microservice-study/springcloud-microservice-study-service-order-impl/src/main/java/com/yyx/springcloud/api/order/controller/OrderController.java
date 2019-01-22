package com.yyx.springcloud.api.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yyx.springcloud.api.member.dto.UserDto;
import com.yyx.springcloud.api.order.feign.member.MemberFeign;
import com.yyx.springcloud.common.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 13:25
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private MemberFeign memberFeign;

    @RequestMapping(value = "queryMemberFromApiById",method = RequestMethod.GET)
    public UserDto queryMemberFromApiById(@RequestParam("id") Integer id) {
        return memberFeign.queryMemberById(id);
    }

    /**
     * 没有解决服务雪崩效应
     * @param id
     * @return
     */
    @RequestMapping(value = "queryMemberFromApiByIdOfSleep",method = RequestMethod.GET)
    public BaseResult<UserDto> queryMemberFromApiByIdOfSleep(@RequestParam("id") Integer id) {
        return memberFeign.queryMemberByIdOfSleep(id);
    }

    /**
     * 解决了服务雪崩效应：@HystrixCommand 该注解默认开启线程池隔离、服务降级、服务熔断
     * @param id
     * @return
     */
    @RequestMapping(value = "queryMemberFromApiByIdOfSleepHystrix",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "queryMemberFromApiByIdOfSleepHystrixFallback")
    //@HystrixCommand
    public BaseResult<UserDto> queryMemberFromApiByIdOfSleepHystrix(@RequestParam("id") Integer id) {
        log.info("queryMemberFromApiByIdOfSleepHystrix -->线程池名称:{}",Thread.currentThread().getName());
        return memberFeign.queryMemberByIdOfSleep(id);
    }


    public BaseResult<UserDto> queryMemberFromApiByIdOfSleepHystrixFallback(Integer id) {
        log.info("queryMemberFromApiByIdOfSleepHystrixFallback -->线程池名称:{},id{}",Thread.currentThread().getName(),id);
        return BaseResult.success("这是hystrix服务降级方法");
    }

    @RequestMapping(value = "queryOrder",method = RequestMethod.GET)
    public BaseResult queryOrder() {
        log.info("queryOrder -->线程池名称:{}",Thread.currentThread().getName());
        return BaseResult.success("这是order服务其他正常方法");
    }

    @RequestMapping(value = "queryMemberByHystrix",method = RequestMethod.GET)
    public BaseResult queryMemberByHystrix() {
        log.info("orderController-->queryMemberByHystrix -->线程池名称:{}",Thread.currentThread().getName());
        BaseResult<String> stringBaseResult = memberFeign.queryMemberServiceByHystrix();
        return stringBaseResult;
    }
}
