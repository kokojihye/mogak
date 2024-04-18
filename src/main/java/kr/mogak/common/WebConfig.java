package kr.mogak.common;

import kr.mogak.common.interceptor.AuthCheckInterceptor;
import kr.mogak.common.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns() // 적용할 경로
                .excludePathPatterns(); // 제외할 경로
    }

    public void addAuthInterceptor(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthCheckInterceptor())
                .addPathPatterns()
                .excludePathPatterns();
    }

}
