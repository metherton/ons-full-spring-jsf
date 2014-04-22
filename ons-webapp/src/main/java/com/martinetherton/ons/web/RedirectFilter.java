package com.martinetherton.ons.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectFilter implements Filter {

    private FilterConfig cfg;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        EmbeddedServletResponseWrapper responseWrapper = new EmbeddedServletResponseWrapper(httpResponse);
        chain.doFilter(httpRequest, responseWrapper);
        System.out.println(responseWrapper.toString());

    }

    @Override
    public void init(FilterConfig cfg) throws ServletException {
        this.cfg = cfg;
    }

}
