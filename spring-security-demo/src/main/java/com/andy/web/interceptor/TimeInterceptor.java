package com.andy.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: lyon
 * @since: 2017-11-6 5:06
 */
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     * 执行控制器之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
//		System.out.println(((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("start", System.currentTimeMillis());
        return true;
    }

    /**
     * 控制器返回前调用
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long start = (long) request.getAttribute("start");
//        log.info("TimeInterceptor :" + (System.currentTimeMillis() - start) + "毫秒！");
    }

    /**
     * 执行控制器之后调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long start = (long) request.getAttribute("start");
        log.info("TimeInterceptor :" + (System.currentTimeMillis() - start) + "毫秒！");
    }

}
