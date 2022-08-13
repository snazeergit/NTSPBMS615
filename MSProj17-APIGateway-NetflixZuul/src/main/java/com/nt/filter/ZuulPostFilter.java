package com.nt.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulPostFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulPostFilter.class);

	@Override
	public boolean shouldFilter() {
		//enables filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		//get RequestCOntext object(it contains access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();

		//get HttpServletResponse object from this
		HttpServletResponse response = context.getResponse();
		System.out.println("ZuulPostFilter.run()::from Post filter");

		//Write log messages about the current request
		logger.info("==========================From Post Filter===========================");
		logger.info("response content type::" + response.getContentType());
		logger.info("response status::" + response.getStatus());
		logger.info("response status code::" + response.getHeader("host"));
		return null;
	}

	@Override
	public String filterType() {
		// makes this as zuul post filter
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		// 0 indicate high priority
		return 0;
	}

}
