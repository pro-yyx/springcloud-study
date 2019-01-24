package com.yyx.springcloud.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/24 11:12
 */
@Component
@ConfigurationProperties("swaggerresources")
@Data
@RefreshScope
public class SwaggerResources {

    private SwaggerResourceYyx[] list={};
}
