package com.huxzhi.springboot.config;


import com.huxzhi.springboot.config.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现webMvcConfigurer的addInterceptors)
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/api/**")  // 拦截所有请求，通过判断token是否合法来决定是否需要登录
                .excludePathPatterns("/api/user/login", "/api/user/register", "/**/export", "/**/import",
                        "/swagger-resources/**", "/webjars/**", "/swagger-ui.html/**", "/api", "/api-docs", "/api-docs/**");
    }

    @Bean
    //注册到容器中
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}
