package com.yyx.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2019/1/22 22:13
 */
@Component
public class TokenFilter extends ZuulFilter {

    /**
     * 过滤器类型 pre表示在请求之前进行执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，当一个请求过来需要经过多个过滤器的时候，该过滤器执行的顺序，从0开始排序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }


    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 编写过滤器拦截业务请求代码
     * @return
     */
    @Override
    public Object run() throws ZuulException {
        //案例:拦截所有请求，判断请求上是都带有userToken信息
        //1：通过zuul的requestContext api获取当前请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2：获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //3：一般将token放置在请求头里，这里只为了演示效果，就以参数方式传递
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)) {
            //拦截请求，不转发给实际的接口服务器
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("userToken is null");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //转发到接口服务器 ...
        return null;
    }
}
