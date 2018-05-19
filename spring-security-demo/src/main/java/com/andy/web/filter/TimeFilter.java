package com.andy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author ruolin create by 2017年11月6日下午4:47:04
 */
//@Component
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("time filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
//		System.out.println("time filter start");
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
//		System.out.println("time filter finish");
//		System.out.println("time :" + (end - start)+"毫秒！");
	}

	@Override
	public void destroy() {
		System.out.println("time filter destroy");
	}

}
