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
public class ZuulErrorFilter extends ZuulFilter {

	private Logger logger = LoggerFactory.getLogger(ZuulPostFilter.class);

	@Override
	public boolean shouldFilter() {
		// enables the filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		//get RequestCOntext object(it contains access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();

		//get HttpServletResponse object from this
		HttpServletResponse response = context.getResponse();
		System.out.println("ZuulErrorFilter.run()::from Error filter");

		//Write log messages about the current request
		logger.info("==========================From Error Filter===========================");
		logger.info("response content type::" + response.getContentType());
		return null;
	}

	@Override
	public String filterType() {
		// specify the filter type
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		//  0 indicates high priority
		return 0;
	}

}
