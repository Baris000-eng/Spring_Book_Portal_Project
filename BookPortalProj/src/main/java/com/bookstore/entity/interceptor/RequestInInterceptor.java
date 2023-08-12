package com.bookstore.entity.interceptor;

import com.bookstore.entity.filter.RequestInFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class RequestInInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestInFilter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startDate", new Date());
        System.out.println("Request interceptor started !!! \n\n");
        LOGGER.info("Request interceptor started: {} {}.", request.getRequestURI(), request.getMethod());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        var start = (Date) request.getAttribute("startDate");
        var end = new Date();
        var elapsedTime = end.getTime() - start.getTime();
        System.out.println("Request interceptor finished !!! \n\n");
        LOGGER.info("Request interceptor finished: {} {}. Elapsed: {}", request.getRequestURI(), request.getMethod(), elapsedTime);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
