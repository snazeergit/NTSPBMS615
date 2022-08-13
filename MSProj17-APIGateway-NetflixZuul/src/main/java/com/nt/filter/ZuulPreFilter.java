package com.nt.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPreFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulPreFilter.class);

	@Override
	public boolean shouldFilter() {
		//Enables the filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//get Current request context
		RequestContext context = RequestContext.getCurrentContext();
		//get request object from context obj
		HttpServletRequest request = context.getRequest();
		System.out.println("Zuul PreFilter.run():: from Pre-filter");
		//log request trapping information
		logger.info("==========================From Pre Filter===========================");
		logger.info("Request uri::" + request.getRequestURI());
		logger.info("Request path::" + request.getServletPath());
		logger.info("Request method::" + request.getMethod());
		logger.info("Request data content type::" + request.getContentType());
		return null;
	}

	@Override
	public String filterType() {
		//makes the filter as Zuul Pre Filter
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		//if you multiple filter specify the order else 0 indicates high priority
		return 0;
	}

}
