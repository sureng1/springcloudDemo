package com.spcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        System.out.println("type");
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        System.out.println("order");

        return 0;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("should");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("run");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token!~");
            return null;
        }
        return null;
    }
}
