package com.nt.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulRouteFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulRouteFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//get RequestContext object (it contains access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();
		System.out.println("Zuul RouteFilter.run():: from route-filter");
		//write log messages about current request
		logger.info("==========================From Route Filter===========================");
		logger.info("route host::" + context.getRouteHost());
		return null;
	}

	@Override
	public String filterType() {
		//makes the filter as Zuul route filter
		return FilterConstants.ROUTE_TYPE;
	}

	@Override
	public int filterOrder() {
		return 0;//indicated high priority
	}

}
