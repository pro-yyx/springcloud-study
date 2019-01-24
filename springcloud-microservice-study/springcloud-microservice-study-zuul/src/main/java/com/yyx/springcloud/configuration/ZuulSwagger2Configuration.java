package com.yyx.springcloud.configuration;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/24 10:17
 */
@Configuration
@Primary
public class ZuulSwagger2Configuration implements SwaggerResourcesProvider {

    @Autowired
    private SwaggerResources swaggerResources;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResourceList = new ArrayList<>();
        Optional<SwaggerResources> optional = Optional.ofNullable(swaggerResources);
        optional.orElseGet((    )->new SwaggerResources());
        Optional<List<SwaggerResourceYyx>> optionalResourceYyxes = Optional.ofNullable(Arrays.asList(optional.get().getList()));
        optionalResourceYyxes.orElseGet(()->Lists.newArrayList()).stream().filter(obj->obj!=null).forEach(obj->{
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(obj.getName());
            swaggerResource.setLocation(obj.getLocation());
            swaggerResource.setSwaggerVersion(obj.getVersion());
            swaggerResourceList.add(swaggerResource);
        });
        return swaggerResourceList;
    }

}
