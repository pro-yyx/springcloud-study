package com.yyx.springcloud;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/9 19:34
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> data=new ArrayList<>();
        List<Integer> data2=new ArrayList<>();
        data2.add(null);
        System.out.println(data==null);
        System.out.println(":");
        System.out.println(data2==null);
        System.out.println(data.size());
        System.out.println(":");
        System.out.println(data2.size());
    }
}
