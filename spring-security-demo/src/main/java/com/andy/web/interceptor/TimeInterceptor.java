package com.andy.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Mr.lyon
 * @createBy 2017年11月6日下午5:06:20
 */
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("preHandler 执行控制器之前调用");
//		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
//		System.out.println(((HandlerMethod)handler).getMethod().getName());
		request.setAttribute("start", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long start = (long) request.getAttribute("start");
//		System.out.println("time :" + (System.currentTimeMillis() - start)+"毫秒！");
//		System.out.println("preHandler 控制器返回前调用");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
//		System.out.println("preHandler 执行控制器之后调用");
		long start = (long)request.getAttribute("start");
//		System.out.println("time :" + (System.currentTimeMillis() - start)+"毫秒！");
	}
	
}
