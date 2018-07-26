package com.andy.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Mr.lyon
 * @CreateBy: 2017-11-6 4:47:04
 */
@Slf4j
@Component
public class TimeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("time filter init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start = System.currentTimeMillis();
//		System.out.println("time filter start");
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
//		System.out.println("time filter finish");
		log.info("time :" + (end - start)+"毫秒！");
	}

	@Override
	public void destroy() {
		log.info("time filter destroy");
	}

}
