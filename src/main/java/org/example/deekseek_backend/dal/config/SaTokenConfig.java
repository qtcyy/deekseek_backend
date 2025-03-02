package org.example.deekseek_backend.dal.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chengyiyang
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Bean
    public StpLogic userLogin() {
        return new StpLogic("user");
    }

    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                .addInclude("/**").addExclude("/login", "/register", "/proxy/**", "/api/user/**")
                .setAuth(obj -> {
                    // 在这里可以添加自定义的认证逻辑
                    String token = SaHolder.getRequest().getHeader("satoken");
                    if (token != null) {
                        // 验证 token
                        StpUtil.checkActiveTimeout();
                        StpUtil.checkLogin();
                    }
                })
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                })
                .setBeforeAuth(obj -> {
                    String origin = SaHolder.getRequest().getHeader("Origin");
                    SaHolder.getResponse()
                            .setHeader("Access-Control-Allow-Origin", origin)
                            .setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                            .setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization, X-Requested-With, satoken")
                            .setHeader("Access-Control-Expose-Headers", "satoken")
                            .setHeader("Access-Control-Allow-Credentials", "true")
                            .setHeader("Access-Control-Max-Age", "3600");
                });
    }

}
