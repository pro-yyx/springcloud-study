package com.yyx.springcloud.api.member.dto;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/10 12:57
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = -4115790322077008682L;

    private Integer id;

    private String name;

    private Integer age;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
