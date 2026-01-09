package com.example.SYP_System.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NoCacheConfig implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpRes = (HttpServletResponse) response;

        httpRes.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate");
        httpRes.setHeader("Pragma", "no-cache");
        httpRes.setHeader("Expires", "0");
        httpRes.setHeader("Surrogate-Control", "no-store");

        chain.doFilter(request, response);
    }
}
