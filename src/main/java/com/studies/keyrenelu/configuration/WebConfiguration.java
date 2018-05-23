package com.studies.keyrenelu.configuration;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器
 */
@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter getRemoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new myFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("myFilter");
        registrationBean.setOrder(1);
        registrationBean.addInitParameter("ppm","ZMT");
        return registrationBean;
    }

    public class myFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("this is my filter,url:"+request.getRequestURL());
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }
}
