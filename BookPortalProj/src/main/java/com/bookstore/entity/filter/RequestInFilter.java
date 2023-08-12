package com.bookstore.entity.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;


@Component
public class RequestInFilter extends CommonsRequestLoggingFilter {
    //GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD
    private static Logger LOGGER = LoggerFactory.getLogger(RequestInFilter.class);

    @Override
    protected boolean shouldLog(HttpServletRequest req) {
        var pathInfo = req.getRequestURI();
        return pathInfo.contains("/api/");
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        LOGGER.info("Request filter started: {} {}", request.getRequestURI(), request.getMethod());
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String name) {
        LOGGER.info("Request filter finished: {} {}", request.getRequestURI(), request.getMethod());
    }

}