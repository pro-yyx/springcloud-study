package com.yyx.springcloud.api.order.feign.fallback;

import com.yyx.springcloud.api.member.dto.UserDto;
import com.yyx.springcloud.api.order.feign.member.MemberFeign;
import com.yyx.springcloud.common.entity.BaseResult;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/22 14:21
 */
@Component
public class MemberFeignFallback implements MemberFeign {
    @Override
    public UserDto queryMemberById(Integer id) {
        UserDto userDto = new UserDto();
        userDto.setName("这是降级过来的");
        return userDto;
    }

    @Override
    public BaseResult<UserDto> queryMemberByIdOfSleep(Integer id) {
        return null;
    }

    @Override
    public BaseResult<String> queryMemberServiceByHystrix() {
        return BaseResult.success("这是服务降级fabalk,线程名称:" + Thread.currentThread().getName());
    }
}
