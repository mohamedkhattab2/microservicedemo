package com.msa.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class ZuulPreFilter extends ZuulFilter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String headerAuth = request.getHeader("AUTH-VAL");
        if (null == headerAuth || headerAuth.isEmpty()) {
            ctx.setSendZuulResponse(false);
            log.error("Not Authorized");

            return null;
        }
        log.info("{} request {}", request.getMethod(), request.getRequestURL().toString());

        return null;
    }
}
