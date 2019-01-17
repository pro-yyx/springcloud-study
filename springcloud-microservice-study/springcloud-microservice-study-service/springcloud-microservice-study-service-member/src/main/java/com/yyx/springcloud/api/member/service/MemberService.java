package com.yyx.springcloud.api.member.service;

import com.yyx.springcloud.api.member.dto.UserDto;
import com.yyx.springcloud.common.entity.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 12:59
 */
public interface MemberService {

    @RequestMapping(value = "member/queryMemberById",method = RequestMethod.GET)
    UserDto queryMemberById(@RequestParam("id") Integer id);

    @RequestMapping(value = "member/queryMemberByIdOfSleep",method = RequestMethod.GET)
    BaseResult<UserDto> queryMemberByIdOfSleep(@RequestParam("id") Integer id) ;
}
