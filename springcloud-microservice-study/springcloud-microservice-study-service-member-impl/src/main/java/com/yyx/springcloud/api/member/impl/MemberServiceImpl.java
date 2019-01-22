package com.yyx.springcloud.api.member.impl;

import com.yyx.springcloud.api.member.dto.UserDto;
import com.yyx.springcloud.api.member.service.MemberService;
import com.yyx.springcloud.common.entity.BaseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 13:08
 */
@RestController
public class MemberServiceImpl implements MemberService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    @RequestMapping(value = "member/queryMemberById",method = RequestMethod.GET)
    public UserDto queryMemberById(Integer id) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName("yinyuxin:"+serverPort);
        userDto.setAge(25);
        return userDto;
    }

    @Override
    @RequestMapping(value = "member/queryMemberByIdOfSleep",method = RequestMethod.GET)
    public BaseResult<UserDto> queryMemberByIdOfSleep(Integer id) {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程:"+Thread.currentThread().getName());
        UserDto userDto = new UserDto();
        userDto.setName("这事测试sleep");
        return BaseResult.success(userDto);
    }

    @Override
    public BaseResult<String> queryMemberServiceByHystrix() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("member微服务接口的线程:"+Thread.currentThread().getName());
        return BaseResult.success("这是通过类的方式使用hystrix");
    }
}
