package com.BrowserAuthenticationWithRedis.RedisSession.configuration;

import com.BrowserAuthenticationWithRedis.RedisSession.Filter.FirstFilter;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Filter {

    @Bean
    public FilterRegistrationBean<FirstFilter> myFirstFilter(){
        FilterRegistrationBean<FirstFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new FirstFilter());
        registrationBean.addUrlPatterns("/healthcheck/*");
        return registrationBean;
    }
}
